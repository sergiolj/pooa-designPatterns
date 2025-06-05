package br.ucsal.info.refactor.model;

import br.ucsal.info.refactor.interfaces.OperationalSystem;

import java.io.IOException;

public class LinuxOS implements OperationalSystem {
    private String swapUsage = "N/A";
    private String loadAverage = "N/A";
    private String uptimeValue = "N/A";

    @Override
    public void info() {
        // Linux specific info
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

    @Override
    public String getSwapUsageData() {
        return swapUsage;
    }

    @Override
    public String getLoadAverageData() {
        return loadAverage;
    }

    @Override
    public String getUptimeValueData() {
        return uptimeValue;
    }
}
