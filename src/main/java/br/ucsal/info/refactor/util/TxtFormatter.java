package br.ucsal.info.refactor.util;


import br.ucsal.info.refactor.core.SystemInfo;
import br.ucsal.info.refactor.factory.ReportFormatter;

import java.text.DecimalFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.function.Function;

public class TxtFormatter implements ReportFormatter {
    private final SystemInfo sysCheck;
    private final CommandOptions cmdOpt;

    public TxtFormatter(SystemInfo sysCheck) {
        this.sysCheck = sysCheck;
        this.cmdOpt = sysCheck.getCommandOpt();
        formatReport();
    }

    @Override
    public StringBuilder formatReport() {
        StringBuilder reportBuilder = new StringBuilder();
        // Format timestamp
        String currentTime = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));

        if (cmdOpt.isIncludeTimestamp()) {
            reportBuilder.append("Relatório de sistema gerado em: " + currentTime + "\n");
            reportBuilder.append("----------------------------------------\n");
        }
        reportBuilder.append("Sistema Operacional: " + sysCheck.getDisplayOS() + "\n");
        if (cmdOpt.isIncludeProcessors()) {
            reportBuilder.append("Número de processadores disponíveis: " + sysCheck.getNumberOfProcessors() + "\n");
        }
        if (cmdOpt.isIncludeMemory()) {
            reportBuilder.append("Memória (JVM):\n");
            reportBuilder.append("  Livre: " + formatter().apply(sysCheck.getFreeMemoryBytes()) + "\n");
            reportBuilder.append("  Total: " + formatter().apply(sysCheck.getTotalMemoryBytes()) + "\n");
            reportBuilder.append("  Máxima permitida: " + formatter().apply(sysCheck.getMaxMemoryBytes()) + "\n");
        }
        if (cmdOpt.isIncludeDisk()) {
            reportBuilder.append("Espaço em Disco (todos os volumes):\n");
            reportBuilder.append("  Livre: " + formatter().apply(sysCheck.getFreeDiskSpace()) + "\n");
            reportBuilder.append("  Total: " + formatter().apply(sysCheck.getTotalDiskSpace()) + "\n");
        }
        reportBuilder.append("Swap utilizado: " + sysCheck.getSwapUsage() + "\n");
        reportBuilder.append("Carga média (1,5,15 min): " + sysCheck.getLoadAverage() + "\n");
        reportBuilder.append("Tempo de atividade: " + sysCheck.getUptimeValue() + "\n");

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
