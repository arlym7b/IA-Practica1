package baldurs;

import agentesolitario.AgenteSolitario;

public class AgenteOctile extends AgenteSolitario<Punto> {
    private static final int COSTE_SIMPLE = 1000;
    private static final int COSTE_DIAGONAL = 1414;

    public AgenteOctile(Punto punto) {
        super(punto);
    }

    @Override
    public boolean esFinal(Punto punto) {
        return punto.equals(TestMapa.getPosicion_objetivo());
    }

    @Override
    public int h(Punto punto) {
        int diferencia_filas = Math.abs(punto.getX() - TestMapa.getPosicion_objetivo().getX());
        int diferencia_columnas = Math.abs(punto.getY() - TestMapa.getPosicion_objetivo().getY());

        int h1 = diferencia_filas * COSTE_DIAGONAL + (diferencia_columnas - diferencia_filas) * COSTE_SIMPLE;
        int h2 = diferencia_columnas * COSTE_DIAGONAL + (diferencia_filas - diferencia_columnas) * COSTE_SIMPLE;

        return Math.min(h1, h2);
    }
}
