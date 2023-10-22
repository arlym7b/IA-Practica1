package parte1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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

        System.out.println("Sucesores");
        for (Pancakes pancakes2: pancakes.calculaSucesores()){
            System.out.println(pancakes2.toString());
        }
    }

    public static void test_final(){
        //Pancakes pancakes = new Pancakes(Arrays.asList(2,4,3,1,5));
        Pancakes pancakes = new Pancakes(Arrays.asList(7,3,1,6,2,4,5));
        System.out.println(pancakes.toString());

        System.out.println("Solucion:");
        AgentePancakes ag = new AgentePancakes(pancakes);

        List<Pancakes> solucion = ag.amplitud();

        if (solucion != null){
            for (Pancakes pancakes2: solucion){
                System.out.println(pancakes2.toString());
            }
        }
        else {
            System.out.println("No se encontro solucion");
        }
    }

}
