import java.util.concurrent.TimeUnit;

public class TorreDeHanoi {
    private static long contadorMovimentos;
    public static void main(String[] args) {
        int[] instancias = {1, 10, 20, 30, 40, 41};

        System.out.println("Iniciando a execução do algoritmo Torre de Hanói...");
        System.out.println("-------------------------------------------------");

        for (int n : instancias) {
            System.out.printf("Executando para a instância com %d discos...\n", n);
            contadorMovimentos = 0;
            long tempoInicial = System.nanoTime();
            resolverHanoi(n, 'A', 'C', 'B');
            long tempoFinal = System.nanoTime();
            long duracaoNano = tempoFinal - tempoInicial;
            String tempoFormatado = formatarDuracao(duracaoNano);
            System.out.printf("-> Instância com %d discos concluída!\n", n);
            System.out.printf("   - Quantidade de movimentos: %,d\n", contadorMovimentos);
            System.out.printf("   - Tempo de execução: %s\n\n", tempoFormatado);
        }
        
        System.out.println("-------------------------------------------------");
        System.out.println("Todos os testes foram concluídos.");
    }

    /**
     * @param n
     * @param origem
     * @param destino
     * @param auxiliar
     */
    public static void resolverHanoi(int n, char origem, char destino, char auxiliar) {
        if (n == 1) {
            contadorMovimentos++;
            return;
        }
        resolverHanoi(n - 1, origem, auxiliar, destino);
        contadorMovimentos++;
        resolverHanoi(n - 1, auxiliar, destino, origem);
    }

    /**
     * @param nanosegundos
     * @return
     */
    public static String formatarDuracao(long nanosegundos) {
        long totalMillis = TimeUnit.NANOSECONDS.toMillis(nanosegundos);
        long horas = TimeUnit.MILLISECONDS.toHours(totalMillis);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(totalMillis) % 60;
        long segundos = TimeUnit.MILLISECONDS.toSeconds(totalMillis) % 60;
        long millis = totalMillis % 1000;
        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, millis);
    }
}