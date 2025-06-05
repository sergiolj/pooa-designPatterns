/**
 * ReportFormater é uma Strategy Interface e se configura como uso de Padrão Strategy uma vez que
 * possibilita o uso de duas formas de saída para a classe SystemReport, podendo inclusive
 * comportar novas implementações para outros formatos.
 * As classes JsonFormatter e TxtFormatter implementam a classe e o SystemReport usa ela como injeção de dependência.
 */
package br.ucsal.info.refactor.interfaces;
import br.ucsal.info.refactor.util.CommandOptions;
import java.util.function.Function;

public interface ReportFormatter {
    StringBuilder formatReport();
    Function<Long,String> formatter();
    CommandOptions getCommandOptions();
}
