package pancakes;

import agentesolitario.AgenteSolitario;

import java.util.LinkedList;
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

    private boolean isCollectionSorted(List<Integer> list) {
        List<Integer> copy = new LinkedList<>(list);
        Collections.sort(copy);
        return copy.equals(list);
    }
}
