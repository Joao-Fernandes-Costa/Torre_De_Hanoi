import java.math.BigInteger;

/**
 * Classe que implementa a lógica recursiva para resolver o problema da Torre de Hanói.
 * Utiliza BigInteger para contar os movimentos, permitindo calcular para um número
 * grande de discos sem estourar o limite de tipos de dados primitivos.
 */
public class TorreDeHanoi {

    private BigInteger movimentos = BigInteger.ZERO;

    /**
     * Método público que inicia a resolução do problema e retorna o total de movimentos.
     *
     * @param nDiscos Número de discos a serem movidos.
     * @param origem  Pino de origem (ex: 'A').
     * @param destino Pino de destino (ex: 'C').
     * @param aux     Pino auxiliar (ex: 'B').
     * @return O número total de movimentos realizados.
     */
    public BigInteger resolver(int nDiscos, char origem, char destino, char aux) {
        // Zera o contador a cada nova chamada principal
        this.movimentos = BigInteger.ZERO;
        moverDiscos(nDiscos, origem, destino, aux);
        return this.movimentos;
    }

    /**
     * Método recursivo privado que executa a lógica de movimentação dos discos.
     *
     * @param n       Número de discos no pino atual.
     * @param origem  Pino de onde o disco será movido.
     * @param destino Pino para onde o disco será movido.
     * @param aux     Pino de apoio.
     */
    private void moverDiscos(int n, char origem, char destino, char aux) {
        if (n > 0) {
            // 1. Mover n-1 discos da origem para o pino auxiliar, usando o destino como apoio.
            moverDiscos(n - 1, origem, aux, destino);

            // 2. Mover o disco n (o maior) da origem para o destino.
            // Em uma implementação visual, aqui seria exibido o movimento.
            // Para este problema, apenas contamos o movimento.
            this.movimentos = this.movimentos.add(BigInteger.ONE);

            // 3. Mover os n-1 discos do pino auxiliar para o pino de destino, usando a origem como apoio.
            moverDiscos(n - 1, aux, destino, origem);
        }
    }
}