/**
 * A classe SystemReport é a classe Context que se utiliza dos objetos que implementam a classe ReportFormatter.
 */
package br.ucsal.info.refactor.core;

import br.ucsal.info.refactor.interfaces.ReportFormatter;
import br.ucsal.info.refactor.util.CommandOptions;

import java.io.FileWriter;
import java.io.IOException;

public class SystemReport {
    private final ReportFormatter reportFormatter;
    private final StringBuilder reportBuilder;
    private final CommandOptions cmdOpt;

    public SystemReport(ReportFormatter reportFormatter) {
        this.reportFormatter = reportFormatter;
        this.reportBuilder = reportFormatter.formatReport();
        this.cmdOpt = reportFormatter.getCommandOptions();
    }

    public void outPutReport() {
        if(cmdOpt.isFileOutputFlag()){
            String filename = "info." + cmdOpt.getFormatOption();
            boolean verboseFlag = cmdOpt.isVerboseFlag();
            String formatOption = cmdOpt.getFormatOption();
            saveFile(filename, verboseFlag, formatOption);
        }else{
            consoleOutput();
        }
    }

    private void saveFile(String fileName, boolean verboseFlag, String formatOption) {
            try {
                FileWriter writer = new FileWriter(fileName);
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

    private void consoleOutput() {
        System.out.println(reportBuilder.toString());
    }
}
