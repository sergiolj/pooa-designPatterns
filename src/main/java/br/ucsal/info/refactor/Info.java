package br.ucsal.info.refactor;

public class Info {
    public static void main(String[] args) {
       CommandOptions opts = new CommandOptions(args);
       SystemCheck check = new SystemCheck(opts);
       SystemReport report = new SystemReport(check);
    }
}


