package baldurs;

import java.io.File;
import java.io.FileNotFoundException;

public class TestMapa {
    public static void main(String[] args) {
        String ruta = "mapas/AR0011SR.map";
        try {
            Mapa mapa = leer_map_file(ruta);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

    private static Mapa leer_map_file(String ruta) throws FileNotFoundException {
        File file = new File(ruta);

        char[][] grid = leer_grid(file);
    }

    private static char[][] leer_grid(File file) {

    }
}
