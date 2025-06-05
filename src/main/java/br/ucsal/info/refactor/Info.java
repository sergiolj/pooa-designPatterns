package br.ucsal.info.refactor;

import br.ucsal.info.refactor.model.*;
import br.ucsal.info.refactor.util.*;

public class Info {
    public static void main(String[] args) {
        //Recebe e armazena os argumentos de linha de comando
        CommandOptions opts = new CommandOptions(args);
        OperationalSystem selectedOS = null;

        //Verfica os argumentos para criar a instância do SO escolhido pelo usuário
        if (opts.getOsOption().equalsIgnoreCase("linux")) {
            selectedOS = new LinuxOS();
        } else if (opts.getOsOption().equalsIgnoreCase("windows")) {
            selectedOS = new WindowsOS();
        } else if (opts.getOsOption().equalsIgnoreCase("mac")) {
            selectedOS = new MacOS();
        }

        SystemInfo info = null;

        //Se um sistema operacional suportado foi escolhido executa a checagem
        if (selectedOS != null) {
            info = new SystemInfo(opts, selectedOS);
        }
        System.out.println(info);

        ReportFormater reportFormater = null;

        //Verfica os argumentos para identificar o tipo de saída escolhida
        if (opts.getFormatOption().equalsIgnoreCase("json") && info != null) {
            reportFormater = new JsonFormatter(info);
        } else if (opts.getFormatOption().equalsIgnoreCase("txt") && info != null) {
            reportFormater = new TxtFormatter(info);
        }

        if (reportFormater != null) {
            SystemReport report = new SystemReport(reportFormater);
            report.outPutReport(opts);
        }
    }
}


