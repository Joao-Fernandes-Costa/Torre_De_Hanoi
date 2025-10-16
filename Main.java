import java.math.BigInteger;
import java.util.concurrent.TimeUnit;


/**
 * Classe principal para executar o algoritmo da Torre de Hanói para várias
 * instâncias e medir seu desempenho.
 */
public class Main {

    public static void main(String[] args) {
        // Instâncias de discos a serem testadas, conforme solicitado.
        int[] instancias = {1, 10, 20, 30, 40, 41};

        System.out.println("### INICIANDO EXECUÇÃO DO ALGORITMO TORRES DE HANÓI ###\n");

        for (int nDiscos : instancias) {
            TorreDeHanoi torre = new TorreDeHanoi();

            System.out.println("=======================================================");
            System.out.println(">>> Iniciando execução para " + nDiscos + " discos...");

            // Marca o tempo de início em nanossegundos para maior precisão
            long startTime = System.nanoTime();

            // Chama o método que resolve o problema e retorna o número de movimentos
            BigInteger totalMovimentos = torre.resolver(nDiscos, 'A', 'C', 'B');

            // Marca o tempo de fim
            long endTime = System.nanoTime();

            // Calcula a duração da execução
            long duracaoEmNanos = endTime - startTime;

            System.out.println("<<< Execução para " + nDiscos + " discos finalizada.");
            System.out.println("    - Quantidade de movimentos: " + totalMovimentos);
            System.out.println("    - Tempo gasto para execução: " + formatarDuracao(duracaoEmNanos));
            System.out.println("=======================================================\n");
        }
    }

    /**
     * Formata uma duração em nanossegundos para o formato HH:MM:SS:ms.
     *
     * @param nanos Duração em nanossegundos.
     * @return String formatada.
     */
    public static String formatarDuracao(long nanos) {
        // Converte nanossegundos para milissegundos
        long milissegundos = TimeUnit.NANOSECONDS.toMillis(nanos);

        long horas = TimeUnit.MILLISECONDS.toHours(milissegundos);
        milissegundos -= TimeUnit.HOURS.toMillis(horas);

        long minutos = TimeUnit.MILLISECONDS.toMinutes(milissegundos);
        milissegundos -= TimeUnit.MINUTES.toMillis(minutos);

        long segundos = TimeUnit.MILLISECONDS.toSeconds(milissegundos);
        milissegundos -= TimeUnit.SECONDS.toMillis(segundos);

        // Formata a string de saída, garantindo que cada campo tenha o preenchimento de zeros adequado
        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, milissegundos);
    }
}
