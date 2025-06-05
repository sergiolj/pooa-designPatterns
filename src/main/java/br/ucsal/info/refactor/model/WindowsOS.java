package br.ucsal.info.refactor.model;

import br.ucsal.info.refactor.interfaces.OperationalSystem;

public class WindowsOS implements OperationalSystem {
    @Override
    public void info() {

    }

    @Override
    public String getSwapUsageData() {
        return "";
    }

    @Override
    public String getLoadAverageData() {
        return "";
    }

    @Override
    public String getUptimeValueData() {
        return "";
    }
}
