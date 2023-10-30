package baldurs;

import mundosolitario.OverrideHashCode;

import java.util.Arrays;

public class Grid extends OverrideHashCode {
    private char[][] grid;

    public Grid(char[][] grid) {
        this.grid = grid;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Grid grid1 = (Grid) o;
        return Arrays.deepEquals(grid, grid1.grid);
    }

    @Override
    public int hashCode() {
        return Arrays.deepHashCode(grid);
    }

    public char[][] getGrid() {
        return grid;
    }
}
