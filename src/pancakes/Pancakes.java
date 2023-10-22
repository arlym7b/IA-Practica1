package pancakes;

import mundosolitario.OverrideHashCode;
import mundosolitario.RepresentacionEstadoOptimizacion;

import java.util.LinkedList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Pancakes extends OverrideHashCode implements RepresentacionEstadoOptimizacion<Pancakes> {
    List<Integer> pancakes;

    public Pancakes(List<Integer> pancakes) {
        this.pancakes = pancakes;
    }

    @Override
    public String toString() {
        return pancakes.toString();
    }

    @Override
    public List<Pancakes> calculaSucesores() {
        List<Pancakes> lista = new LinkedList<>();

        // To-Do
        for (int i = 1; i <= this.pancakes.size(); i++){
            // Flip the first "half"
            List<Integer> first_half = new LinkedList<Integer>(this.pancakes.subList(0, i));
            flip_pancakes(first_half);
            // Get second "half"
            List<Integer> second_half = new LinkedList<Integer>(this.pancakes.subList(i, this.pancakes.size()));
            // Make a new pancakes tower adding both "halves"
            first_half.addAll(second_half);

            Pancakes new_pancakes = new Pancakes(first_half);

            lista.add(new_pancakes);
        }

        return lista;
    }

    private void flip_pancakes(List<Integer> subList) {
        Collections.reverse(subList);
    }

    @Override
    public int costeArco(Pancakes eDestino) {
        return 1;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pancakes pancakes1 = (Pancakes) o;
        return Objects.equals(pancakes, pancakes1.pancakes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(pancakes);
    }
}
