package br.ucsal.info.refactor;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class SystemReport {
    private SystemCheck systemCheck;

    public SystemReport(SystemCheck systemCheck) {
        this.systemCheck = systemCheck;
    }

    private void saveReport() {
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
                reportBuilder.append("  \"processors\": " + systemCheck.numberOfProcessors + ",\n");
            }
            if (includeMemory) {
                reportBuilder.append("  \"memory\": {\n");
                reportBuilder.append("    \"free\": \"" + byteFormatter.apply(systemCheck.freeMemoryBytes) + "\",\n");
                reportBuilder.append("    \"total\": \"" + byteFormatter.apply(systemCheck.totalMemoryBytes) + "\",\n");
                reportBuilder.append("    \"max\": \"" + byteFormatter.apply(systemCheck.maxMemoryBytes) + "\"\n");
                reportBuilder.append("  },\n");
            }
            if (includeDisk) {
                reportBuilder.append("  \"disk\": {\n");
                reportBuilder.append("    \"free\": \"" + byteFormatter.apply(systemCheck.freeDiskSpace) + "\",\n");
                reportBuilder.append("    \"total\": \"" + byteFormatter.apply(systemCheck.totalDiskSpace) + "\"\n");
                reportBuilder.append("  },\n");
            }
            reportBuilder.append("  \"swapUsed\": \"" + systemCheck.swapUsage + "\",\n");
            reportBuilder.append("  \"loadAverage\": \"" + systemCheck.loadAverage + "\",\n");
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
                reportBuilder.append("  Livre: " + byteFormatter.apply(systemCheck.freeDiskSpace) + "\n");
                reportBuilder.append("  Total: " + byteFormatter.apply(systemCheck.totalDiskSpace) + "\n");
            }
            reportBuilder.append("Swap utilizado: " + systemCheck.swapUsage + "\n");
            reportBuilder.append("Carga média (1,5,15 min): " + systemCheck.loadAverage + "\n");
            reportBuilder.append("Tempo de atividade: " + systemCheck.uptimeValue + "\n");
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
