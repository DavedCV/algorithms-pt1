import edu.princeton.cs.algs4.WeightedQuickUnionUF;

public class Percolation {

    private boolean[][] grid;
    private WeightedQuickUnionUF uf;
    // to prevent backwash
    private WeightedQuickUnionUF uf2;
    private int size;
    private int virtualTopSite;
    private int virtualBottomSite;
    private int counterOpenSites;

    public Percolation(int N) {
        size = N;
        if (size <= 0) throw new IllegalArgumentException();

        // create a grid table with size x size dimension
        grid = new boolean[size][size];

        // create the quick union data structure with the entries of the grid, plus 2 additional entries to the virtual sites
        uf = new WeightedQuickUnionUF((size * size) + 2);
        uf2 = new WeightedQuickUnionUF((size * size) + 1);

        virtualTopSite = size * size;
        virtualBottomSite = size * size + 1;
    }

    private boolean validateCornerCases(int rowIndex, int colIndex) {
        if ((rowIndex <= 0 || rowIndex > size) || (colIndex <= 0 || colIndex > size))
            return false;
        return true;
    }

    private int getUnidimensionalValue(int row, int column) {
        // return the unidimensional index from an already scaled index [0...size-1]
        return size * row + column;
    }

    // opens the site (row, col) if it is not open already
    public void open(int row, int col) {
        if (!validateCornerCases(row, col)) throw new IllegalArgumentException();

        // transform the original values in the range (0...size-1), in order to properly access the indexes in the grid
        int scaledRowIndex = row - 1;
        int scaledColIndex = col - 1;
        int unidimensional = getUnidimensionalValue(scaledRowIndex, scaledColIndex);

        // open the grid entry in the position passed
        if (!grid[scaledRowIndex][scaledColIndex]) {
            grid[scaledRowIndex][scaledColIndex] = true;
            counterOpenSites++;
        }

        // conditional to connect the virtual sites
        if (scaledRowIndex == 0) {
            uf.union(unidimensional, virtualTopSite);
            uf2.union(unidimensional, virtualTopSite);
        }
        if (scaledRowIndex == size - 1) uf.union(unidimensional, virtualBottomSite);

        // connect the opened site to the adjacent sites if they are opened too
        // case for row - 1
        if (scaledRowIndex > 0 && isOpen(row - 1, col)) {
            uf.union(unidimensional, getUnidimensionalValue(scaledRowIndex - 1, scaledColIndex));
            uf2.union(unidimensional, getUnidimensionalValue(scaledRowIndex - 1, scaledColIndex));
        }
        // case for row + 1
        if (scaledRowIndex < size - 1 && isOpen(row + 1, col)) {
            uf.union(unidimensional, getUnidimensionalValue(scaledRowIndex + 1, scaledColIndex));
            uf2.union(unidimensional, getUnidimensionalValue(scaledRowIndex + 1, scaledColIndex));
        }

        // case for col - 1
        if (scaledColIndex > 0 && isOpen(row, col - 1)) {
            uf.union(unidimensional, getUnidimensionalValue(scaledRowIndex, scaledColIndex - 1));
            uf2.union(unidimensional, getUnidimensionalValue(scaledRowIndex, scaledColIndex - 1));
        }
        // case for col + 1
        if (scaledColIndex < size - 1 && isOpen(row, col + 1)) {
            uf.union(unidimensional, getUnidimensionalValue(scaledRowIndex, scaledColIndex + 1));
            uf2.union(unidimensional, getUnidimensionalValue(scaledRowIndex, scaledColIndex + 1));
        }

    }

    public boolean isOpen(int row, int col) {

        if (!validateCornerCases(row, col)) throw new IllegalArgumentException();
        return grid[row - 1][col - 1];
    }

    public boolean isFull(int row, int col) {

        if (!validateCornerCases(row, col)) throw new IllegalArgumentException();
        return uf2.find(virtualTopSite) == uf2.find(getUnidimensionalValue(row - 1, col - 1));
    }

    public int numberOfOpenSites() {
        return counterOpenSites;
    }

    public boolean percolates() {
        return uf.find(virtualBottomSite) == uf.find(virtualTopSite);
    }
}
