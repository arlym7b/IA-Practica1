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
            System.out.println("iteraciones: " + problema.getIteraciones());
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
        int[][] p1 = {{3,2,5}, {6,8,4}, {7,1,0}};
        Puzzle puzzle1 = new Puzzle(p1);
        int[][] p2 = {{0,1,5}, {4,2,8}, {3,6,7}};
        Puzzle puzzle2 = new Puzzle(p2);
        AgentePuzzleBDP problema = new AgentePuzzleBDP(puzzle1, 5);

        List<Puzzle> l = problema.aMono();

        if (l != null) {
            System.out.println("\nNúmero de comodines: " + 5);
            System.out.println("Profundidad de la solucion: " + (l.size()-1));
            System.out.println("Camino Solucion:");
            for (Puzzle e : l) {
                e.ver();
            }
        } else {
            System.out.println("No se ha podido encontrar la Solucion");
        }
    }
	
}
