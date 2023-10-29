package baldurs;

import mundosolitario.OverrideHashCode;
import mundosolitario.RepresentacionEstadoOptimizacion;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;
import java.util.Objects;

public class Mapa extends OverrideHashCode implements RepresentacionEstadoOptimizacion<Mapa> {
    // Simboliza una posicion valida para el jugador en el mapa
    private static final char HUECO = '.';
    // Simboliza una posicion no valida para el jugador en el mapa
    private static final char OBSTACULO = '@';

    // Grid del mapa, cada valor indica una posicion del mapa
    private char[][] grid;
    // Punto en el que se encuentra el jugador
    private Punto posicion_jugador;
    // Punto objetivo al que hay que llegar
    private Punto posicion_objetivo;

    public Mapa(char[][] grid, Punto posicion_jugador, Punto posicion_objetivo) {
        this.grid = grid;
        this.posicion_jugador = posicion_jugador;
        this.posicion_objetivo = posicion_objetivo;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Mapa mapa = (Mapa) o;
        return Arrays.deepEquals(grid, mapa.grid) && Objects.equals(posicion_jugador, mapa.posicion_jugador) &&
                Objects.equals(posicion_objetivo, mapa.posicion_objetivo);
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(posicion_jugador, posicion_objetivo);
        result = 31 * result + Arrays.deepHashCode(grid);
        return result;
    }

    @Override
    public List<Mapa> calculaSucesores() {
        List<Mapa> sucesores = new LinkedList<>();
        Punto punto = new Punto(0, 0);

        punto.setPunto(this.posicion_jugador.getX() + 1, this.posicion_jugador.getY());
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX() - 1, this.posicion_jugador.getY());
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX(), this.posicion_jugador.getY() + 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX(), this.posicion_jugador.getY() - 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX() + 1, this.posicion_jugador.getY() + 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX() + 1, this.posicion_jugador.getY() - 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX() - 1, this.posicion_jugador.getY() + 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        punto.setPunto(this.posicion_jugador.getX() - 1, this.posicion_jugador.getY() - 1);
        if (this.grid[punto.getX()][punto.getY()] == HUECO){
            Mapa sucesor = new Mapa(this.grid, new Punto(punto.getX(), punto.getY()), this.posicion_objetivo);
            sucesores.add(sucesor);
        }

        return sucesores;
    }

    @Override
    public int costeArco(Mapa destino) {
        Punto punto_destino = destino.getPosicion_jugador();
        // Por defecto un movimiento normal cuesta 1000
        int coste = 1000;
        // Si ambas coordenadas son distintas entre actual y destino, el movimiento es diagonal
        if (punto_destino.getX() != this.posicion_jugador.getX() &&
                punto_destino.getY() != this.posicion_jugador.getY()){
            coste = 1414;
        }
        return coste;
    }

    public char[][] getGrid() {
        return grid;
    }

    public void setGrid(char[][] grid) {
        this.grid = grid;
    }

    public Punto getPosicion_jugador() {
        return posicion_jugador;
    }

    public void setPosicion_jugador(Punto posicion_jugador) {
        this.posicion_jugador = posicion_jugador;
    }

    public Punto getPosicion_objetivo() {
        return posicion_objetivo;
    }

    public void setPosicion_objetivo(Punto posicion_objetivo) {
        this.posicion_objetivo = posicion_objetivo;
    }
}
