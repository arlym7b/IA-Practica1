package parte1;

import mundosolitario.OverrideHashCode;
import mundosolitario.RepresentacionEstadoOptimizacion;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

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
        List<Pancakes> lista = new ArrayList<>();

        // To-Do
        for (int i = this.pancakes.size(); i > 0; i--){
            if (this.pancakes.get(i - 1) != i){
                // Flip the first "half"
                List<Integer> first_half = new ArrayList<Integer>(this.pancakes.subList(0, i));
                first_half = flip_pancakes(first_half);
                // Get second "half"
                List<Integer> second_half = new ArrayList<Integer>(this.pancakes.subList(i, this.pancakes.size()));
                // Make a new pancakes tower adding both "halves"
                List<Integer> new_list = first_half;
                new_list.addAll(second_half);

                Pancakes new_pancakes = new Pancakes(new_list);

                lista.add(new_pancakes);
            }
        }

        return lista;
    }

    private List<Integer> flip_pancakes(List<Integer> subList) {
        Collections.reverse(subList);
        return subList;
    }

    @Override
    public int costeArco(Pancakes eDestino) {
        return 1;
    }

    // To-Do
    @Override
    public int hashCode() {
        return 0;
    }

    // To-Do
    @Override
    public boolean equals(Object obj) {
        return false;
    }
}
