/**
 * Interface do tipo Strategy para possibilitar o uso de variados tipos de implementações concretas
 * de SO.
 */
package br.ucsal.info.refactor.interfaces;

public interface OperationalSystem {
    void info();
    String getSwapUsageData();
    String getLoadAverageData();
    String getUptimeValueData();
}
