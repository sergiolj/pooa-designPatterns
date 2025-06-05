package br.ucsal.info.refactor.util;

import java.text.DecimalFormat;
import java.util.function.Function;

public interface ReportFormater {
    StringBuilder formatReport();
    Function<Long,String> formatter();
}
