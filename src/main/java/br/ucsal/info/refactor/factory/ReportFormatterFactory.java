/**
 * Uso do padrão Factory para verificar qual o tipo de formato de saída o algoritmo deve implementar
 * com base no CommandOptions (default) e escolha do usuário
 */
package br.ucsal.info.refactor.factory;

import br.ucsal.info.refactor.core.SystemInfo;
import br.ucsal.info.refactor.util.JsonFormatter;
import br.ucsal.info.refactor.util.TxtFormatter;

public class ReportFormatterFactory {
    public static ReportFormatter createFormatter(String formatOption, SystemInfo systemInfo) {
        if (formatOption != null) {
            if (formatOption.equalsIgnoreCase("txt")) {
                return new TxtFormatter(systemInfo);
            }else if (formatOption.equalsIgnoreCase("json")) {
                return new JsonFormatter(systemInfo);
            }
        }
        //default
        return new TxtFormatter(systemInfo);
    }
}
