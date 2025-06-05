package br.ucsal.info.refactor;

import java.io.File;

public class SystemCheck {
    private final CommandOptions commandOpt;
    protected int numberOfProcessors;
    protected long freeMemoryBytes;
    protected long totalMemoryBytes;
    protected long maxMemoryBytes;
    protected long totalDiskSpace;
    protected long freeDiskSpace;

    public SystemCheck(CommandOptions commandOpt) {
        this.commandOpt = commandOpt;
        detectSystemOS();
        detectCommonOptions();
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
        String displayOS = System.getProperty("os.name") + " (" + commandOpt.getOsOption() + ")";

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

        String swapUsage = "N/A";
        String loadAverage = "N/A";
        String uptimeValue = "N/A";

    }

    public void detectOSSpecificOptions(OperationalSystem operationalSystem){

    }
}
