package pancakes;

import java.util.*;

public class MainPancakes {
    public static void main(String[] args) {
        //test_print();
        //test_print_sucesores();
        test_final();

    }

    public static void test_print(){
        //Pancakes pancakes = new Pancakes(Arrays.asList(2,4,3,1,5));
        Pancakes pancakes = new Pancakes(Arrays.asList(7,3,1,6,2,4,5));

        System.out.println(pancakes.toString());
    }

    public static void test_print_sucesores(){
        //Pancakes pancakes = new Pancakes(Arrays.asList(2,4,3,1,5));
        Pancakes pancakes = new Pancakes(Arrays.asList(7,3,1,6,2,4,5));

        System.out.println(pancakes.toString());

        System.out.println("Sucesores");
        for (Pancakes pancakes2: pancakes.calculaSucesores()){
            System.out.println(pancakes2.toString());
        }
    }

    public static void test_final(){
        Pancakes pancakes = new Pancakes(getIntegerList());

        AgentePancakes ag = new AgentePancakes(pancakes);

        List<Pancakes> solucion = ag.amplitud();

        if (solucion != null){
            // La solución devuelve el estado inicial también, no podemos contarlo como movimiento
            System.out.println("Solucion (" + (solucion.size() - 1) + " movimientos):");
            for (Pancakes pancakes2: solucion){
                System.out.println(pancakes2.toString());
            }
        }
        else {
            System.out.println("No se encontro solucion");
        }
    }

    private static List<Integer> getIntegerList() {
        List<Integer> pancake_list;
        try (Scanner scanner = new Scanner(System.in)) {
            System.out.println("Introduce los tamaños de los pancakes separados por espacios:");
            pancake_list = new ArrayList<>();
            String line = scanner.nextLine();
            String[] numbers = line.split(" ");
            for (String number: numbers) {
                pancake_list.add(Integer.parseInt(number));
            }
        }
        return pancake_list;
    }

}
