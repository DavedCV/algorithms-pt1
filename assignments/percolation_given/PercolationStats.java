/* *****************************************************************************
 *  Name:              Alan Turing
 *  Coursera User ID:  123456
 *  Last modified:     1/1/2019
 **************************************************************************** */

import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.StdStats;

public class PercolationStats {

    private double[] dataRecopilation;
    private int trials;

    // perform independent trials on an n-by-n grid
    public PercolationStats(int n, int trials) {
        if (n <= 0 || trials <= 0) throw new IllegalArgumentException();

        this.trials = trials;
        dataRecopilation = new double[trials];

        for (int i = 0; i < trials; i++) {
            Percolation percolationTrial = new Percolation(n);

            while (!percolationTrial.percolates()) {
                int randomRow = StdRandom.uniformInt(1, n + 1);
                int randomColumn = StdRandom.uniformInt(1, n + 1);

                while (percolationTrial.isOpen(randomRow, randomColumn)) {
                    randomRow = StdRandom.uniformInt(1, n + 1);
                    randomColumn = StdRandom.uniformInt(1, n + 1);
                }

                percolationTrial.open(randomRow, randomColumn);
            }

            dataRecopilation[i] = (double) percolationTrial.numberOfOpenSites() / (n * n);
        }
    }

    // sample mean of percolation threshold
    public double mean() {
        return StdStats.mean(dataRecopilation);
    }

    // sample standard deviation of percolation threshold
    public double stddev() {
        return StdStats.stddev(dataRecopilation);
    }

    // low endpoint of 95% confidence interval
    public double confidenceLo() {
        return mean() - (1.96 * stddev()) / Math.sqrt(trials);
    }

    // high endpoint of 95% confidence interval
    public double confidenceHi() {
        return mean() + (1.96 * stddev()) / Math.sqrt(trials);
    }


    public static void main(String[] args) {
        PercolationStats stats = new PercolationStats(Integer.parseInt(args[0]),
                                                      Integer.parseInt(args[1]));

        System.out.printf("%s = %.10f\n", "mean", stats.mean());
        System.out.printf("%s = %.10f\n", "stddev", stats.stddev());
        System.out.printf("%s = [%.10f, %.10f]\n", "95% confidence interval",
                          stats.confidenceLo(),
                          stats.confidenceHi());
    }
}
