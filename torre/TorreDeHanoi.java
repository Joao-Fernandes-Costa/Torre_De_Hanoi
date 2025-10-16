import java.util.concurrent.TimeUnit;

public class TorreDeHanoi {

    private long movimentos = 0;

    /**
     * Método principal que executa o algoritmo para uma lista pré-definida de instâncias.
     */
    public static void main(String[] args) {
        // Instâncias a serem executadas, conforme solicitado.
        int[] instancias = {1, 10, 20, 30, 35, 38, 39, 40, 41};

        System.out.println("Iniciando a execução do algoritmo Torre de Hanói Recursiva.");
        
        for (int discos : instancias) {
            TorreDeHanoi hanoiSolver = new TorreDeHanoi();
            hanoiSolver.executarEmedir(discos);
        }
    }

    /**
     * Orquestra a execução do algoritmo, medindo o tempo e imprimindo os resultados.
     * @param numDiscos O número de discos para a instância atual.
     */
    public void executarEmedir(int numDiscos) {
        System.out.println("\n=======================================================");
        System.out.printf("Executando para a instância de %d discos...\n", numDiscos);

        // Zera o contador de movimentos para cada nova execução
        this.movimentos = 0;

        // Medição do tempo de início
        long tempoInicial = System.currentTimeMillis();

        // Chamada do método recursivo que resolve o problema
        resolverHanoi(numDiscos, 'A', 'B', 'C');

        // Medição do tempo final
        long tempoFinal = System.currentTimeMillis();

        // Cálculo da duração
        long duracao = tempoFinal - tempoInicial;

        System.out.println("Execução finalizada.");
        System.out.printf(" -> Tempo gasto: %s\n", formatarDuracao(duracao));
        System.out.printf(" -> Movimentos realizados: %,d\n", this.movimentos);
        System.out.println("=======================================================");
    }

    /**
     * Implementação do algoritmo recursivo da Torre de Hanói.
     * A lógica é mover n-1 discos para o pino auxiliar, mover o disco n para o destino,
     * e depois mover os n-1 discos do auxiliar para o destino.
     *
     * @param n O número de discos a serem movidos.
     * @param origem O pino de origem.
     * @param auxiliar O pino auxiliar.
     * @param destino O pino de destino.
     */
    private void resolverHanoi(int n, char origem, char auxiliar, char destino) {
        if (n > 0) {
            // 1. Move a torre de n-1 discos da origem para o pino auxiliar.
            resolverHanoi(n - 1, origem, destino, auxiliar);

            // 2. Move o disco n (o que sobrou na origem) para o pino de destino.
            // Cada chamada aqui representa um único movimento.
            this.movimentos++;

            // 3. Move a torre de n-1 discos do pino auxiliar para o pino de destino.
            resolverHanoi(n - 1, auxiliar, origem, destino);
        }
    }

    /**
     * Formata uma duração em milissegundos para o formato HH:MM:SS:ms.
     * @param millis A duração total em milissegundos.
     * @return Uma string formatada representando o tempo.
     */
    private String formatarDuracao(long millis) {
        if (millis < 0) {
            return "N/A";
        }

        long horas = TimeUnit.MILLISECONDS.toHours(millis);
        millis -= TimeUnit.HOURS.toMillis(horas);
        long minutos = TimeUnit.MILLISECONDS.toMinutes(millis);
        millis -= TimeUnit.MINUTES.toMillis(minutos);
        long segundos = TimeUnit.MILLISECONDS.toSeconds(millis);
        millis -= TimeUnit.SECONDS.toMillis(segundos);

        return String.format("%02d:%02d:%02d:%03d", horas, minutos, segundos, millis);
    }
}