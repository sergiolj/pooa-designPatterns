package br.ucsal.info.refactor.model;

import br.ucsal.info.refactor.interfaces.OperationalSystem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MacOS implements OperationalSystem {
    private String swapUsage = "N/A";
    private String loadAverage = "N/A";
    private String uptimeValue = "N/A";

    @Override
    public void info() {
        // macOS specific info
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
