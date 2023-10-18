package parte1;

import agentesolitario.AgenteSolitario;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class AgentePancakes extends AgenteSolitario<Pancakes> {
    /**
     * Guarda el estado de salida.
     *
     * @param pancakes estado de salida
     */
    protected AgentePancakes(Pancakes pancakes) {
        super(pancakes);
    }

    @Override
    public boolean esFinal(Pancakes pancakes) {
        return isCollectionSorted(pancakes.pancakes);
    }

    // I have to check that the sort is ascending
    private boolean isCollectionSorted(List list) {
        List copy = new ArrayList(list);
        Collections.sort(copy);
        return copy.equals(list);
    }
}
