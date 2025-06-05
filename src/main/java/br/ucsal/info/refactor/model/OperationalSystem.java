package br.ucsal.info.refactor.model;

public interface OperationalSystem {
    void info();
    String getSwapUsageData();
    String getLoadAverageData();
    String getUptimeValueData();
}
