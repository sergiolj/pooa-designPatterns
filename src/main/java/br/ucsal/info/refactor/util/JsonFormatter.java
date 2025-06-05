/**
 * Implementação concreta da interface ConcreteStrategy ReportFormatter
 */
package br.ucsal.info.refactor.util;

import br.ucsal.info.refactor.core.SystemInfo;
import br.ucsal.info.refactor.interfaces.ReportFormatter;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class JsonFormatter implements ReportFormatter {
    private final SystemInfo sysCheck;
    private final CommandOptions cmdOpt;

    public JsonFormatter(SystemInfo sysCheck) {
        this.sysCheck = sysCheck;
        this.cmdOpt = sysCheck.getCommandOpt();
    }

    @Override
    public StringBuilder formatReport() {
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        StringBuilder reportBuilder = new StringBuilder();

            reportBuilder.append("{\n");
            if (cmdOpt.isIncludeTimestamp()) {
                reportBuilder.append("  \"collectedAt\": \"" + currentTime + "\",\n");
            }
            reportBuilder.append("  \"operatingSystem\": \"" + sysCheck.getDisplayOS() + "\",");
            reportBuilder.append("\n");
            if (cmdOpt.isIncludeProcessors()) {
                reportBuilder.append("  \"processors\": " + sysCheck.getNumberOfProcessors() + ",\n");
            }
            if (cmdOpt.isIncludeMemory()) {
                reportBuilder.append("  \"memory\": {\n");
                reportBuilder.append("    \"free\": \"" + formatter().apply(sysCheck.getFreeMemoryBytes()) + "\",\n");
                reportBuilder.append("    \"total\": \"" + formatter().apply(sysCheck.getTotalMemoryBytes()) + "\",\n");
                reportBuilder.append("    \"max\": \"" + formatter().apply(sysCheck.getMaxMemoryBytes()) + "\"\n");
                reportBuilder.append("  },\n");
            }
            if (cmdOpt.isIncludeDisk()) {
                reportBuilder.append("  \"disk\": {\n");
                reportBuilder.append("    \"free\": \"" + formatter().apply(sysCheck.getFreeDiskSpace()) + "\",\n");
                reportBuilder.append("    \"total\": \"" + formatter().apply(sysCheck.getTotalDiskSpace()) + "\"\n");
                reportBuilder.append("  },\n");
            }
            reportBuilder.append("  \"swapUsed\": \"" + sysCheck.getSwapUsage() + "\",\n");
            reportBuilder.append("  \"loadAverage\": \"" + sysCheck.getLoadAverage() + "\",\n");
            reportBuilder.append("  \"uptime\": \"" + sysCheck.getUptimeValue() + "\"\n");
            reportBuilder.append("}");

        return reportBuilder;
    }

    @Override
    public Function<Long, String> formatter() {
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
        return byteFormatter;
    }

    @Override
    public CommandOptions getCommandOptions() {
        return this.cmdOpt;
    }
}
