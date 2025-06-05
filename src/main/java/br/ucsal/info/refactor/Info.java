package br.ucsal.info.refactor;

import br.ucsal.info.refactor.util.JsonFormatter;

public class Info {
    public static void main(String[] args) {
       CommandOptions opts = new CommandOptions(args);
       SystemCheck check = new SystemCheck(opts);
       SystemReport report = new SystemReport(new JsonFormatter(check));
       report.outPutReport(opts);
    }
}


