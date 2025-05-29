## Funcionalidades do `Info.java`

- **Seleção de Sistema Operacional**  
  - `-s linux` ou `-s osx`  
  - Se omitido, assume **linux**.  
  - Emite aviso caso o SO real não coincida.

- **Formato de Saída**  
  - `-f txt` → gera `info.txt` como texto simples.  
  - `-f json` → gera `info.json` no formato JSON.  
  - Padrão: **txt**.

- **Modo Verbose**  
  - `-v` → imprime o relatório no console.  
  - Se nenhum de `-f` ou `-v` for fornecido, `-v` é ligado automaticamente.

- **Geração de Arquivo**  
  - Passar `-f` ativa a escrita em arquivo.  
  - Sem `-v`, só gera o arquivo; com ambos, gera e imprime.

- **Seleção de Seções**  
  - `-p` → inclui **Processadores**.  
  - `-m` → inclui **Memória** (JVM).  
  - `-d` → inclui **Disco** (todos os volumes).  
  - `-t` → inclui **Timestamp** de coleta.  
  - Se nenhuma flag de seção for usada, todas as quatro seções são incluídas.

- **Coleta de Informações**  
  - **Processadores**: `Runtime.getRuntime().availableProcessors()`  
  - **Memória JVM**: `freeMemory()`, `totalMemory()`, `maxMemory()`  
  - **Disco**: soma de `getTotalSpace()` e `getFreeSpace()` em todas as raízes (`/`, etc.)  
  - **Swap**:  
    - Linux: leitura de `/proc/meminfo` (SwapTotal e SwapFree)  
    - macOS: `sysctl -n vm.swapusage`  
  - **Load average**:  
    - Linux: `/proc/loadavg` (três primeiros valores)  
    - macOS: saída de `uptime` parseada  
  - **Uptime**:  
    - Linux: `/proc/uptime` → convertido em dias, horas e minutos  
    - macOS: trecho “up …,” de `uptime`

- **Formatação de Unidades**  
  - Converte bytes em B, KB, MB, GB, TB com dois dígitos decimais.

- **Detecção de SO Real**  
  - Compara `System.getProperty("os.name")` (linux/mac) com o `-s` fornecido e emite aviso se divergirem.
