package baldurs;

import agentesolitario.AgenteSolitario;

public class AgenteOctile extends AgenteSolitario<Mapa> {
    private static final int COSTE_SIMPLE = 1000;
    private static final int COSTE_DIAGONAL = 1414;
    /**
     * Guarda el estado de salida.
     *
     * @param mapa estado de salida
     */
    protected AgenteOctile(Mapa mapa) {
        super(mapa);
    }

    @Override
    public boolean esFinal(Mapa mapa) {
        return mapa.getPosicion_jugador().equals(mapa.getPosicion_objetivo());
    }

    @Override
    public int h(Mapa mapa) {
        int diferencia_filas = Math.abs(mapa.getPosicion_jugador().getX() - mapa.getPosicion_objetivo().getX());
        int diferencia_columnas = Math.abs(mapa.getPosicion_jugador().getY() - mapa.getPosicion_objetivo().getY());

        int h1 = diferencia_filas * COSTE_DIAGONAL + (diferencia_columnas - diferencia_filas) * COSTE_SIMPLE;
        int h2 = diferencia_columnas * COSTE_DIAGONAL + (diferencia_filas - diferencia_columnas) * COSTE_SIMPLE;

        return Math.min(h1, h2);
    }
}
