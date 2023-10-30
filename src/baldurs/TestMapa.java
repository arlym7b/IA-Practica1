package baldurs;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class TestMapa {
    // Simboliza una posicion valida para el jugador en el mapa
    public static final char HUECO = '.';
    // Simboliza una posicion no valida para el jugador en el mapa
    public static final char OBSTACULO = '@';
    // Simboliza una posicion no valida para el jugador en el mapa
    public static final char CAMINO = 'o';

    private static Grid grid;
    private static Punto posicion_objetivo;

    public static void main(String[] args) {
        String ruta = "src/baldurs/mapas/AR0011SR.map";
        try {
            File file = new File(ruta);
            grid = leer_grid(file);
            Punto[] posiciones = pedir_posiciones();
            Punto posicion_inicial = posiciones[0];
            posicion_objetivo = posiciones[1];
            AgenteOctile problema = new AgenteOctile(posicion_inicial);

            // Usamos A*
            List<Punto> puntos_solucion = problema.aMono();
            if (puntos_solucion == null){
                throw new RuntimeException("No se ha encontrado solución");
            }
            imprimir_solucion(puntos_solucion);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimir_solucion(List<Punto> puntos_solucion) {
        System.out.println("Dimensiones:.." + puntos_solucion.get(0).toString() +
                " " + posicion_objetivo.toString());

        // Variables para guardar los puntos que delimitan el area de visualización. Valores iniciales límite
        Punto punto_minimo = new Punto(grid.getGrid().length, grid.getGrid()[0].length);
        Punto punto_maximo = new Punto(0, 0);

        // Tras la primera iteración, punto min y max se han actualizado. A partir de ahí el área crece
        for (Punto estado: puntos_solucion) {
            if (estado.getX() < punto_minimo.getX()){
                punto_minimo.setX(estado.getX());
            }
            if (estado.getY() < punto_minimo.getY()){
                punto_minimo.setY(estado.getY());
            }
            if (estado.getX() > punto_maximo.getX()){
                punto_maximo.setX(estado.getX());
            }
            if (estado.getY() > punto_maximo.getY()){
                punto_maximo.setY(estado.getY());
            }

        }

        imprimir_camino(punto_minimo, punto_maximo, puntos_solucion);
    }

    private static void imprimir_camino(Punto punto_minimo, Punto punto_maximo, List<Punto> mapas_solucion) {
        Punto punto_aux = new Punto(0, 0);

        for (int x = punto_minimo.getX(); x <= punto_maximo.getX(); x++){
            for (int y = punto_minimo.getY(); y <= punto_maximo.getY(); y++){
                punto_aux.setPunto(x, y);

                if (grid.getGrid()[x][y] == HUECO && mapas_solucion.contains(punto_aux)){
                    System.out.print(CAMINO);
                } else if (grid.getGrid()[x][y] == HUECO){
                    System.out.print(HUECO);
                } else {
                    System.out.print(OBSTACULO);
                }
            }
            System.out.println();
        }
    }

    // Crea un punto pidiendo las coordenadas por teclado. Recive el string de instrucciones al usuario
    private static Punto[] pedir_posiciones() {
        try (Scanner scanner = new Scanner(System.in)) {
            Punto[] puntos = new Punto[2];

            System.out.print("Introduce las posiciones inicial y objetivo: ");
            String[] linea = scanner.nextLine().split(" ");

            int x = Integer.parseInt(linea[0]);
            int y = Integer.parseInt(linea[1]);
            puntos[0] = new Punto(x, y);

            x = Integer.parseInt(linea[2]);
            y = Integer.parseInt(linea[3]);
            puntos[1] = new Punto(x, y);

            return puntos;
        }
    }

    private static Grid leer_grid(File file) throws FileNotFoundException{
        //char[][] grid = new char[][];
        ArrayList<char[]> grid = new ArrayList<>();

        try (Scanner scanner = new Scanner(file)) {
            while (scanner.hasNextLine()){
                String linea = scanner.nextLine();

                // Podemos asumir que @ y . solo forman parte del mapa en el .map y no se encuentran en otras lineas
                if (!linea.isEmpty() && (linea.contains(".") || linea.contains("@"))){
                    grid.add(linea.toCharArray());
                }
            }

            char[][] array = grid.toArray(new char[grid.size()][]);
            return new Grid(array);
        }
    }

    public static Grid getGrid() {
        return grid;
    }

    public static void setGrid(Grid grid) {
        TestMapa.grid = grid;
    }

    public static Punto getPosicion_objetivo() {
        return posicion_objetivo;
    }
}
