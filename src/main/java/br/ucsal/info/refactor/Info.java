/**
 *
 */
package br.ucsal.info.refactor;

import br.ucsal.info.refactor.core.*;
import br.ucsal.info.refactor.factory.*;
import br.ucsal.info.refactor.interfaces.*;
import br.ucsal.info.refactor.util.CommandOptions;

public class Info {
    public static void main(String[] args) {
        //Recebe e armazena os argumentos de linha de comando
        CommandOptions opts = new CommandOptions(args);

        //Define o sistema operacional a ser utilizado ou o default conforme CommandOptions.
        OperationalSystem selectedOS = OperationSystemFactory.createOS(opts.getOsOption());
        SystemInfo info = new SystemInfo(opts, selectedOS);

        //Define o formato de saída a ser utilizado ou o default conforme CommandOptions.
        ReportFormatter reportFormatter = ReportFormatterFactory.createFormatter(opts.getFormatOption(),  info);
        SystemReport report = new SystemReport(reportFormatter);

        //executa o relatório de saída conforme especificado para saída em console ou arquivo.
        report.outPutReport();
    }
}


