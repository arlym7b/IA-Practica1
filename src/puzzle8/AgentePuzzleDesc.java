package puzzle8;

public class AgentePuzzleDesc extends AgentePuzzleH0{
    /**
     * Constructor for objects of class ProbPuzzleH0
     *
     * @param p
     */
    public AgentePuzzleDesc(Puzzle p) {
        super(p);
    }

    @Override
    public int h(Puzzle puzzle) {
        int[][] tablero = puzzle.tab;
        int piezas_descolocadas = 0;
        int posicion_bucle = 0;
        for (int i = 0; i < tablero.length; i++){
            for (int j = 0; j < tablero[i].length; j++){
                if (tablero[i][j] != posicion_bucle){
                    piezas_descolocadas++;
                }
                posicion_bucle++;
            }
        }

        return piezas_descolocadas;
    }
}
