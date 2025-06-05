package br.ucsal.info.refactor;

import br.ucsal.info.refactor.util.ReportFormater;

import java.io.FileWriter;
import java.io.IOException;

public class SystemReport {
    private final ReportFormater reportFormater;
    private final StringBuilder reportBuilder;

    public SystemReport(ReportFormater reportFormater) {
        this.reportFormater = reportFormater;
        this.reportBuilder = reportFormater.formatReport();
    }

    public void outPutReport(CommandOptions cmdOPt) {
        if(cmdOPt.isFileOutputFlag()){
            String filename = "info." + cmdOPt.getFormatOption();
            boolean verboseFlag = cmdOPt.isVerboseFlag();
            String formatOption = cmdOPt.getFormatOption();
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
