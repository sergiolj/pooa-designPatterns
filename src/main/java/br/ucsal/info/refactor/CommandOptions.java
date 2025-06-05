package br.ucsal.info.refactor;

public class CommandOptions {
    private String[] args;
    private String osOption = null;
    private String formatOption = null;
    private boolean verboseFlag = false;
    private boolean fileOutputFlag = false;
    private boolean includeProcessors = false;
    private boolean includeMemory = false;
    private boolean includeDisk = false;
    private boolean includeTimestamp = false;

    public CommandOptions(String[] args) {
        this.args = args;
        commandSet();
        defaultOptions();
        validateOptions();
    }

    private void validateOptions() {
        // Validate OS option
        if (!osOption.equals("linux") && !osOption.equals("osx")) {
            System.err.println("Erro: apenas linux ou osx suportados como seleção de SO.\n");
            System.exit(1);
        }

        // Validate format option
        if (!formatOption.equals("txt") && !formatOption.equals("json")) {
            System.err.println("Erro: formato inválido. Use txt ou json.\n");
            System.exit(1);
        }
    }

    public void commandSet(){
        for (int index = 0; index < args.length; index++) {
            String argument = args[index];
            if ("-s".equals(argument)) {
                if ((index + 1) < args.length) {
                    osOption = args[index + 1].toLowerCase();
                    index = index + 1;
                } else {
                    System.err.println("Erro: parâmetro -s requer valor (linux ou osx).\n");
                    System.exit(1);
                }
            } else if ("-f".equals(argument)) {
                if ((index + 1) < args.length) {
                    formatOption = args[index + 1].toLowerCase();
                    fileOutputFlag = true;
                    index = index + 1;
                } else {
                    System.err.println("Erro: parâmetro -f requer valor (txt ou json).\n");
                    System.exit(1);
                }
            } else if ("-v".equals(argument)) {
                verboseFlag = true;
            } else if ("-p".equals(argument)) {
                includeProcessors = true;
            } else if ("-m".equals(argument)) {
                includeMemory = true;
            } else if ("-d".equals(argument)) {
                includeDisk = true;
            } else if ("-t".equals(argument)) {
                includeTimestamp = true;
            } else {
                System.err.println("Aviso: opção desconhecida '" + argument + "'. Ignorando.\n");
            }
        }
    }

    private void defaultOptions() {
        if (osOption == null) {
            osOption = "linux";
        }

        if (formatOption == null) {
            formatOption = "txt";
        }

        if (!fileOutputFlag && !verboseFlag) {
            verboseFlag = true;
        }

        if (!includeProcessors && !includeMemory && !includeDisk && !includeTimestamp) {
            includeProcessors = true;
            includeMemory = true;
            includeDisk = true;
            includeTimestamp = true;
        }
    }

    public String getOsOption() {
        return osOption;
    }
}
