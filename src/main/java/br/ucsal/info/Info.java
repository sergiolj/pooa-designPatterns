package br.ucsal.info;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Info {
    public static void main(String[] args) {
        String osOption = null;
        String formatOption = null;
        boolean verboseFlag = false;
        boolean fileOutputFlag = false;
        boolean includeProcessors = false;
        boolean includeMemory = false;
        boolean includeDisk = false;
        boolean includeTimestamp = false;

        // Parse command-line arguments
        for (int index = 0; index < args.length; index++) {
            String argument = args[index];
            if ("-s".equals(argument)) {
                if ((index + 1) < args.length) {
                    osOption = args[index + 1].toLowerCase();
                    index = index + 1;
                } else {
                    System.err.println("Erro: parâmetro -s requer valor (linux ou osx).\n");
                    System.exit(1);
                }
            } else if ("-f".equals(argument)) {
                if ((index + 1) < args.length) {
                    formatOption = args[index + 1].toLowerCase();
                    fileOutputFlag = true;
                    index = index + 1;
                } else {
                    System.err.println("Erro: parâmetro -f requer valor (txt ou json).\n");
                    System.exit(1);
                }
            } else if ("-v".equals(argument)) {
                verboseFlag = true;
            } else if ("-p".equals(argument)) {
                includeProcessors = true;
            } else if ("-m".equals(argument)) {
                includeMemory = true;
            } else if ("-d".equals(argument)) {
                includeDisk = true;
            } else if ("-t".equals(argument)) {
                includeTimestamp = true;
            } else {
                System.err.println("Aviso: opção desconhecida '" + argument + "'. Ignorando.\n");
            }
        }

        // Set defaults
        if (osOption == null) {
            osOption = "linux";
        }

        if (formatOption == null) {
            formatOption = "txt";
        }

        if (!fileOutputFlag && !verboseFlag) {
            verboseFlag = true;
        }

        if (!includeProcessors && !includeMemory && !includeDisk && !includeTimestamp) {
            includeProcessors = true;
            includeMemory = true;
            includeDisk = true;
            includeTimestamp = true;
        }

        // Validate OS option
        if (!osOption.equals("linux") && !osOption.equals("osx")) {
            System.err.println("Erro: apenas linux ou osx suportados como seleção de SO.\n");
            System.exit(1);
        }

        // Validate format option
        if (!formatOption.equals("txt") && !formatOption.equals("json")) {
            System.err.println("Erro: formato inválido. Use txt ou json.\n");
            System.exit(1);
        }

        // Detect actual OS
        String systemPropertyOS = System.getProperty("os.name");
        String detectedOS = "unknown";
        if (systemPropertyOS.toLowerCase().contains("linux")) {
            detectedOS = "linux";
        } else if (systemPropertyOS.toLowerCase().contains("mac")) {
            detectedOS = "osx";
        }
        if (!detectedOS.equals(osOption)) {
            System.err.println("Aviso: você escolheu '-s " + osOption + "', mas o sistema real é " + detectedOS + ".\n");
        }

        // Gather static info
        String displayOS = systemPropertyOS + " (" + osOption + ")";

        // Gather dynamic info
        int numberOfProcessors = Runtime.getRuntime().availableProcessors();
        long freeMemoryBytes = Runtime.getRuntime().freeMemory();
        long totalMemoryBytes = Runtime.getRuntime().totalMemory();
        long maxMemoryBytes = Runtime.getRuntime().maxMemory();
        long totalDiskSpace = 0L;
        long freeDiskSpace = 0L;

        File[] roots = File.listRoots();
        for (File root : roots) {
            totalDiskSpace = totalDiskSpace + root.getTotalSpace();
            freeDiskSpace = freeDiskSpace + root.getFreeSpace();
        }

        String swapUsage = "N/A";
        String loadAverage = "N/A";
        String uptimeValue = "N/A";

        // Linux specific info
        if (osOption.equals("linux")) {
            try {
                java.nio.file.Path meminfoPath = java.nio.file.Paths.get("/proc/meminfo");
                java.util.List<String> meminfoLines = java.nio.file.Files.readAllLines(meminfoPath);
                for (String line : meminfoLines) {
                    if (line.startsWith("SwapTotal:")) {
                        swapUsage = "";
                    }
                    if (line.startsWith("SwapTotal:") || line.startsWith("SwapFree:")) {
                        String valueOnly = line.replaceAll("\\D+", "");
                        swapUsage = swapUsage + valueOnly + " kB ";
                    }
                }

                java.nio.file.Path loadavgPath = java.nio.file.Paths.get("/proc/loadavg");
                String loadavgLine = java.nio.file.Files.readAllLines(loadavgPath).get(0);
                String[] loadParts = loadavgLine.split(" ");
                loadAverage = loadParts[0] + ", " + loadParts[1] + ", " + loadParts[2];

                java.nio.file.Path uptimePath = java.nio.file.Paths.get("/proc/uptime");
                String uptimeLine = java.nio.file.Files.readAllLines(uptimePath).get(0);
                String uptimeSecondsString = uptimeLine.split(" ")[0];
                long uptimeSeconds = (long) Double.parseDouble(uptimeSecondsString);
                long days = uptimeSeconds / 86400;
                long hours = (uptimeSeconds % 86400) / 3600;
                long minutes = (uptimeSeconds % 3600) / 60;
                uptimeValue = days + "d " + hours + "h " + minutes + "m";
            } catch (IOException exception) {
                // Ignoring read errors
            }
        }
        // macOS specific info
        else {
            try {
                Process swapProcess = Runtime.getRuntime().exec(new String[]{"sh", "-c", "sysctl -n vm.swapusage"});
                BufferedReader swapReader = new BufferedReader(new InputStreamReader(swapProcess.getInputStream()));
                String swapLine = swapReader.readLine();
                if (swapLine != null) {
                    Pattern swapPattern = Pattern.compile("used = ([0-9.]+[A-Za-z])");
                    Matcher swapMatcher = swapPattern.matcher(swapLine);
                    if (swapMatcher.find()) {
                        swapUsage = swapMatcher.group(1);
                    }
                }

                Process uptimeProcess = Runtime.getRuntime().exec(new String[]{"sh", "-c", "uptime"});
                BufferedReader uptimeReader = new BufferedReader(new InputStreamReader(uptimeProcess.getInputStream()));
                String uptimeLineFull = uptimeReader.readLine();
                if (uptimeLineFull != null) {
                    Pattern upPattern = Pattern.compile("up ([^,]+),");
                    Matcher upMatcher = upPattern.matcher(uptimeLineFull);
                    if (upMatcher.find()) {
                        uptimeValue = upMatcher.group(1);
                    }
                    Pattern loadPattern = Pattern.compile("load averages?: ([0-9.]+),? ([0-9.]+),? ([0-9.]+)");
                    Matcher loadMatcher = loadPattern.matcher(uptimeLineFull);
                    if (loadMatcher.find()) {
                        loadAverage = loadMatcher.group(1) + ", " + loadMatcher.group(2) + ", " + loadMatcher.group(3);
                    }
                }
            } catch (IOException exception) {
                // Ignoring execution errors
            }
        }

        // Format timestamp
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        // Byte formatting function
        Function<Long, String> byteFormatter = bytes -> {
            if (bytes < 1024) {
                return bytes + " B";
            } else {
                int exponent = (int) (Math.log(bytes) / Math.log(1024));
                char unit = "KMGTPE".charAt(exponent - 1);
                DecimalFormat df = new DecimalFormat("#.##");
                double value = bytes / Math.pow(1024, exponent);
                return df.format(value) + " " + unit + "B";
            }
        };

        StringBuilder reportBuilder = new StringBuilder();

        if (formatOption.equals("json")) {
            reportBuilder.append("{\n");
            if (includeTimestamp) {
                reportBuilder.append("  \"collectedAt\": \"" + currentTime + "\",\n");
            }
            reportBuilder.append("  \"operatingSystem\": \"" + displayOS + "\",");
            reportBuilder.append("\n");
            if (includeProcessors) {
                reportBuilder.append("  \"processors\": " + numberOfProcessors + ",\n");
            }
            if (includeMemory) {
                reportBuilder.append("  \"memory\": {\n");
                reportBuilder.append("    \"free\": \"" + byteFormatter.apply(freeMemoryBytes) + "\",\n");
                reportBuilder.append("    \"total\": \"" + byteFormatter.apply(totalMemoryBytes) + "\",\n");
                reportBuilder.append("    \"max\": \"" + byteFormatter.apply(maxMemoryBytes) + "\"\n");
                reportBuilder.append("  },\n");
            }
            if (includeDisk) {
                reportBuilder.append("  \"disk\": {\n");
                reportBuilder.append("    \"free\": \"" + byteFormatter.apply(freeDiskSpace) + "\",\n");
                reportBuilder.append("    \"total\": \"" + byteFormatter.apply(totalDiskSpace) + "\"\n");
                reportBuilder.append("  },\n");
            }
            reportBuilder.append("  \"swapUsed\": \"" + swapUsage + "\",\n");
            reportBuilder.append("  \"loadAverage\": \"" + loadAverage + "\",\n");
            reportBuilder.append("  \"uptime\": \"" + uptimeValue + "\"\n");
            reportBuilder.append("}");
        } else {
            if (includeTimestamp) {
                reportBuilder.append("Relatório de sistema gerado em: " + currentTime + "\n");
                reportBuilder.append("----------------------------------------\n");
            }
            reportBuilder.append("Sistema Operacional: " + displayOS + "\n");
            if (includeProcessors) {
                reportBuilder.append("Número de processadores disponíveis: " + numberOfProcessors + "\n");
            }
            if (includeMemory) {
                reportBuilder.append("Memória (JVM):\n");
                reportBuilder.append("  Livre: " + byteFormatter.apply(freeMemoryBytes) + "\n");
                reportBuilder.append("  Total: " + byteFormatter.apply(totalMemoryBytes) + "\n");
                reportBuilder.append("  Máxima permitida: " + byteFormatter.apply(maxMemoryBytes) + "\n");
            }
            if (includeDisk) {
                reportBuilder.append("Espaço em Disco (todos os volumes):\n");
                reportBuilder.append("  Livre: " + byteFormatter.apply(freeDiskSpace) + "\n");
                reportBuilder.append("  Total: " + byteFormatter.apply(totalDiskSpace) + "\n");
            }
            reportBuilder.append("Swap utilizado: " + swapUsage + "\n");
            reportBuilder.append("Carga média (1,5,15 min): " + loadAverage + "\n");
            reportBuilder.append("Tempo de atividade: " + uptimeValue + "\n");
        }

        if (verboseFlag) {
            System.out.println(reportBuilder.toString());
        }

        if (fileOutputFlag) {
            try {
                FileWriter writer = new FileWriter("info." + formatOption);
                writer.write(reportBuilder.toString());
                writer.close();
                if (verboseFlag) {
                    System.out.println("Arquivo de relatório gerado: info." + formatOption + "\n");
                }
            } catch (IOException ioe) {
                System.err.println("Erro ao escrever no arquivo: " + ioe.getMessage() + "\n");
                System.exit(1);
            }
        }
    }
}


