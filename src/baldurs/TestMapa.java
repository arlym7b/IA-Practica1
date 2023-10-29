package baldurs;

import javax.swing.plaf.PanelUI;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class TestMapa {
    // Simboliza una posicion valida para el jugador en el mapa
    private static final char HUECO = '.';
    // Simboliza una posicion no valida para el jugador en el mapa
    private static final char OBSTACULO = '@';
    // Simboliza una posicion no valida para el jugador en el mapa
    private static final char CAMINO = 'o';

    public static void main(String[] args) {
        String ruta = "src/baldurs/mapas/AR0011SR.map";
        try {
            Mapa mapa = leer_map_file(ruta);
            AgenteOctile problema = new AgenteOctile(mapa);

            // Usamos A*
            List<Mapa> mapas_solucion = problema.aMono();
            if (mapas_solucion == null){
                throw new RuntimeException("No se ha encontrado solución");
            }
            imprimir_solucion(mapas_solucion, mapa);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static void imprimir_solucion(List<Mapa> mapas_solucion, Mapa mapa) {
        System.out.println("Dimensiones:.." + mapas_solucion.get(0).getPosicion_jugador().toString() +
                " " + mapas_solucion.get(0).getPosicion_objetivo().toString());

        // Variables para guardar los puntos que delimitan el area de visualización. Valores iniciales límite
        Punto punto_minimo = new Punto(mapa.getGrid().length, mapa.getGrid()[0].length);
        Punto punto_maximo = new Punto(0, 0);

        // Tras la primera iteración, punto min y max se han actualizado. A partir de ahí el área crece
        for (Mapa estado: mapas_solucion) {
            if (estado.getPosicion_jugador().getX() < punto_minimo.getX()){
                punto_minimo.setX(estado.getPosicion_jugador().getX());
            }
            if (estado.getPosicion_jugador().getY() < punto_minimo.getY()){
                punto_minimo.setY(estado.getPosicion_jugador().getY());
            }
            if (estado.getPosicion_jugador().getX() > punto_maximo.getX()){
                punto_maximo.setX(estado.getPosicion_jugador().getX());
            }
            if (estado.getPosicion_jugador().getY() > punto_maximo.getY()){
                punto_maximo.setY(estado.getPosicion_jugador().getY());
            }

        }

        imprimir_camino(punto_minimo, punto_maximo, mapas_solucion, mapa);
    }

    private static void imprimir_camino(Punto punto_minimo, Punto punto_maximo, List<Mapa> mapas_solucion, Mapa mapa) {
        Mapa mapa_aux = new Mapa(mapa.getGrid(), new Punto(0, 0), mapa.getPosicion_objetivo());

        for (int x = punto_minimo.getX(); x <= punto_maximo.getX(); x++){
            for (int y = punto_minimo.getY(); y <= punto_maximo.getY(); y++){
                mapa_aux.setPosicion_jugador(new Punto(x, y));

                if (mapa_aux.getGrid()[x][y] == HUECO && mapas_solucion.contains(mapa_aux)){
                    System.out.print(CAMINO);
                } else if (mapa_aux.getGrid()[x][y] == HUECO){
                    System.out.print(HUECO);
                } else {
                    System.out.print(OBSTACULO);
                }
            }
            System.out.println();
        }
    }

    private static Mapa leer_map_file(String ruta) throws FileNotFoundException {
        File file = new File(ruta);

        char[][] grid = leer_grid(file);
        Punto[] posiciones = pedir_posiciones();
        Punto posicion_inicial = posiciones[0];
        Punto posicion_objetivo = posiciones[1];

        return new Mapa(grid, posicion_inicial, posicion_objetivo);
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

    private static char[][] leer_grid(File file) throws FileNotFoundException{
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
            return array;
        }
    }
}
