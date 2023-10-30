package puzzle8;

import static java.lang.Math.abs;

public class AgentePuzzleManh extends AgentePuzzleH0{
    /**
     * Constructor for objects of class ProbPuzzleH0
     *
     * @param p
     */
    public AgentePuzzleManh(Puzzle p) {
        super(p);
    }

    @Override
    public int h(Puzzle puzzle) {
        int[][] tablero = puzzle.tab;
        int piezas_descolocadas = 0;
        int posicion_bucle = 0;
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                if (tablero[i][j] != posicion_bucle && tablero[i][j] != 0){
                    piezas_descolocadas += abs(i - tablero[i][j]/tablero[i].length) +
                            abs(j - tablero[i][j]%tablero[i].length);
                }
                posicion_bucle++;
            }
        }

        return piezas_descolocadas;
    }
}
