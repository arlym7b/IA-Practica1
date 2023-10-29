package baldurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {
        //char[][] grid = new char[][];
        ArrayList<char[]> grid = new ArrayList<>();

        String ruta = "src/baldurs/mapas/AR0011SR.map";
        File file = new File(ruta);

        try (Scanner scanner = new Scanner(file)) {
            int contador_linea = 0;
            int contador_fila = 0;
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();

                // Podemos asumir que @ y . solo forman parte del mapa en el .map y no se encuentran en otras lineas
                if (!linea.isEmpty() && (linea.contains("."))){
                    grid.add(linea.toCharArray());

                    contador_fila++;
                }
            }

            char[][] array = grid.toArray(new char[grid.size()][]);
            print_array(array);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void print_array(char[][] array) {
        for (int i = 0; i < array.length; i++){
            for (int j = 0; j < array[i].length; j++){
                System.out.print(array[i][j]);
            }
            System.out.println();
        }
    }
}
