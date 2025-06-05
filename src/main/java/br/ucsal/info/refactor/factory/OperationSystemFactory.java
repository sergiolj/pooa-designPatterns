/**
 * Uso do padrão Factory para verificar qua a instância de SO será criada
 * com base no CommandOptions (default) e escolha do usuário.
 */
package br.ucsal.info.refactor.factory;

import br.ucsal.info.refactor.model.LinuxOS;
import br.ucsal.info.refactor.model.MacOS;
import br.ucsal.info.refactor.interfaces.OperationalSystem;
import br.ucsal.info.refactor.model.WindowsOS;

public class OperationSystemFactory {
    public static OperationalSystem createOS(String osOption) {
        if (osOption != null) {
            if(osOption.equalsIgnoreCase("linux")) {
                return new LinuxOS();
            }else if(osOption.equalsIgnoreCase("mac")) {
                return new MacOS();
            }else if(osOption.equalsIgnoreCase("windows")) {
                return new WindowsOS();
            }
        }
        //default
        return new LinuxOS();
    }
}
