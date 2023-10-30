package baldurs;

import mundosolitario.OverrideHashCode;
import mundosolitario.RepresentacionEstadoOptimizacion;

import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Punto extends OverrideHashCode implements RepresentacionEstadoOptimizacion<Punto> {
    private int x;
    private int y;

    public Punto(int x, int y) {
        this.x = x;
        this.y = y;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Punto punto = (Punto) o;
        return x == punto.x && y == punto.y;
    }

    @Override
    public int hashCode() {
        return Objects.hash(x, y);
    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public void setPunto(int x, int y){
        this.x = x;
        this.y = y;
    }

    @Override
    public String toString() {
        return x + " " + y;
    }

    @Override
    public List<Punto> calculaSucesores() {
        List<Punto> sucesores = new LinkedList<>();
        Punto punto = new Punto(0, 0);

        punto.setPunto(this.x + 1, this.y);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x - 1, this.y);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x, this.y + 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x, this.y - 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x + 1, this.y + 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x + 1, this.y - 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x - 1, this.y + 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        punto.setPunto(this.x - 1, this.y - 1);
        if (punto_en_mapa(punto) && TestMapa.getGrid().getGrid()[punto.getX()][punto.getY()] == TestMapa.HUECO){
            Punto sucesor = new Punto(punto.getX(), punto.getY());
            sucesores.add(sucesor);
        }

        return  sucesores;
    }

    private boolean punto_en_mapa(Punto punto) {
        return punto.getX() >= 0 && punto.getX() < TestMapa.getGrid().getGrid().length &&
                punto.getY() >= 0 && punto.getY() < TestMapa.getGrid().getGrid()[0].length;
    }

    @Override
    public int costeArco(Punto punto_destino) {
        // Por defecto un movimiento normal cuesta 1000
        int coste = 1000;
        // Si ambas coordenadas son distintas entre actual y destino, el movimiento es diagonal
        if (punto_destino.getX() != this.x &&
                punto_destino.getY() != this.y){
            coste = 1414;
        }
        return coste;
    }
}
