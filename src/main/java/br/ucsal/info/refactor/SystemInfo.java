package br.ucsal.info.refactor;

import br.ucsal.info.refactor.model.OperationalSystem;

import java.io.File;

public class SystemInfo {
    private final CommandOptions commandOpt;
    private final OperationalSystem operationalSystem;
    private int numberOfProcessors;
    private long freeMemoryBytes;
    private long totalMemoryBytes;
    private long maxMemoryBytes;
    private long totalDiskSpace;
    private long freeDiskSpace;
    private String displayOS;
    private String swapUsage = "N/A";
    private String loadAverage = "N/A";
    private String uptimeValue = "N/A";

    public SystemInfo(CommandOptions commandOpt, OperationalSystem system) {
        this.commandOpt = commandOpt;
        this.operationalSystem = system;
        this.swapUsage = system.getSwapUsageData();
        this.loadAverage = system.getLoadAverageData();
        this.uptimeValue = system.getUptimeValueData();
        systemCheck();
    }

    public void systemCheck(){
        detectSystemOS();
        detectCommonOptions();
        detectOSSpecificOptions(this.operationalSystem);
    }

    public void detectSystemOS(){
        String systemPropertyOS = System.getProperty("os.name");
        String detectedOS = "unknown";
        if (systemPropertyOS.toLowerCase().contains("linux")) {
            detectedOS = "linux";
        } else if (systemPropertyOS.toLowerCase().contains("mac")) {
            detectedOS = "osx";
        }
        if (!detectedOS.equals(commandOpt.getOsOption())) {
            System.err.println("Aviso: você escolheu '-s " + commandOpt.getOsOption() + "', mas o sistema real é " + detectedOS + ".\n");
        }
    }

    public void detectCommonOptions(){
        // Gather static info
        this.displayOS = System.getProperty("os.name") + " (" + commandOpt.getOsOption() + ")";

        // Gather dynamic info
        this.numberOfProcessors = Runtime.getRuntime().availableProcessors();
        this.freeMemoryBytes = Runtime.getRuntime().freeMemory();
        this.totalMemoryBytes = Runtime.getRuntime().totalMemory();
        this.maxMemoryBytes = Runtime.getRuntime().maxMemory();
        this.totalDiskSpace = 0L;
        this.freeDiskSpace = 0L;

        File[] roots = File.listRoots();
        for (File root : roots) {
            totalDiskSpace = totalDiskSpace + root.getTotalSpace();
            freeDiskSpace = freeDiskSpace + root.getFreeSpace();
        }
    }

    public void detectOSSpecificOptions(OperationalSystem operationalSystem){
        operationalSystem.info();
    }

    public CommandOptions getCommandOpt() {
        return commandOpt;
    }

    public int getNumberOfProcessors() {
        return numberOfProcessors;
    }

    public long getFreeMemoryBytes() {
        return freeMemoryBytes;
    }

    public long getTotalMemoryBytes() {
        return totalMemoryBytes;
    }

    public long getMaxMemoryBytes() {
        return maxMemoryBytes;
    }

    public long getTotalDiskSpace() {
        return totalDiskSpace;
    }

    public long getFreeDiskSpace() {
        return freeDiskSpace;
    }

    public String getDisplayOS() {
        return displayOS;
    }

    public String getSwapUsage() {
        return swapUsage;
    }

    public String getLoadAverage() {
        return loadAverage;
    }

    public String getUptimeValue() {
        return uptimeValue;
    }

    @Override
    public String toString() {
        return "SystemInfo{" +
                "commandOpt=" + commandOpt +
                ", operationalSystem=" + operationalSystem +
                ", numberOfProcessors=" + numberOfProcessors +
                ", freeMemoryBytes=" + freeMemoryBytes +
                ", totalMemoryBytes=" + totalMemoryBytes +
                ", maxMemoryBytes=" + maxMemoryBytes +
                ", totalDiskSpace=" + totalDiskSpace +
                ", freeDiskSpace=" + freeDiskSpace +
                ", displayOS='" + displayOS + '\'' +
                ", swapUsage='" + swapUsage + '\'' +
                ", loadAverage='" + loadAverage + '\'' +
                ", uptimeValue='" + uptimeValue + '\'' +
                '}';
    }
}
