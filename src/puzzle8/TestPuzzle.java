package puzzle8;

import java.util.List;
/**
 * Pruebas para el puzzle 2D de piezas deslizantes.
 * 
 * @Jose Miguel Horcas Aguilera, Lorenzo Mandow
 *
 */
public class TestPuzzle {
    
    public static void main(String[] args) {
    	//testH0();
    	testDPB(5);


    }
    
    public static void testH0(){
    //    Puzzle s = new Puzzle(3,3);
    	int[][] ttt = {{1,2,0},{3,4,5},{6,7,8}};
        Puzzle s = new Puzzle(ttt);
		AgentePuzzleH0 problema = new AgentePuzzleH0(s);
		
		List<Puzzle> l =  problema.aMono();
		
		if (l != null) {
			System.out.println("Profundidad de la solucion: " + (l.size()-1));
            System.out.println("Camino Solucion:");
            for (Puzzle e : l) {
               e.ver();
            }
        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }        
	}
	
	public static void testDPB(int comodines) {
        Puzzle s = new Puzzle(3,3);
		AgentePuzzleBDP problema = new AgentePuzzleBDP(s, comodines);
		
		List<Puzzle> l = problema.aMono();
		
		if (l != null) {
            System.out.println("Número de comodines: " + comodines);
			System.out.println("Profundidad de la solucion: " + (l.size()-1));
            System.out.println("Camino Solucion:");
            for (Puzzle e : l) {
               e.ver();
            }
        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }        
	}

    public static void test_multiple() {
        // Creamos los puzzles que vamos a resolver mediante los distintos algoritmos
        int[][] p1 = {{3,2,5}, {6,8,4}, {7,1,0}};
        Puzzle puzzle1 = new Puzzle(p1);
        int[][] p2 = {{0,1,5}, {4,2,8}, {3,6,7}};
        Puzzle puzzle2 = new Puzzle(p2);

        // Resolvemos los puzzles por los distintos algoritmos
        AgentePuzzleH0 h01 = new AgentePuzzleH0(puzzle1);
        List<Puzzle> lh01 = h01.aMono();
        AgentePuzzleH0 h02 = new AgentePuzzleH0(puzzle2);
        List<Puzzle> lh02 = h02.aMono();
        AgentePuzzleBDP bdp14 = new AgentePuzzleBDP(puzzle1, 4);
        List<Puzzle> lbdp14 = bdp14.aMono();
        AgentePuzzleBDP bdp15 = new AgentePuzzleBDP(puzzle1, 5);
        List<Puzzle> lbdp15 = bdp15.aMono();
        AgentePuzzleBDP bdp24 = new AgentePuzzleBDP(puzzle2, 4);
        List<Puzzle> lbdp24 = bdp24.aMono();
        AgentePuzzleBDP bdp25 = new AgentePuzzleBDP(puzzle2, 5);
        List<Puzzle> lbdp25 = bdp25.aMono();
        AgentePuzzleDesc desc1 = new AgentePuzzleDesc(puzzle1);
        List<Puzzle> ldesc1 = desc1.aMono();
        AgentePuzzleDesc desc2 = new AgentePuzzleDesc(puzzle2);
        List<Puzzle> ldesc2 = desc2.aMono();
        AgentePuzzleManh manh1 = new AgentePuzzleManh(puzzle1);
        List<Puzzle> lmanh1 = manh1.aMono();
        AgentePuzzleManh manh2 = new AgentePuzzleManh(puzzle2);
        List<Puzzle> lmanh2 = manh2.aMono();

        System.out.println(h01.getIteraciones());
    }

}
