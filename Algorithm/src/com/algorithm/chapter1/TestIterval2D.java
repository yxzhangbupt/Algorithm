package com.algorithm.chapter1;

import edu.princeton.cs.algs4.Counter;
import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class TestIterval2D {
	public static void main(String[] args) {
        double xlo = 0.2;
        double xhi = 0.5;
        double ylo = 0.5;
        double yhi = 0.6;
        int T = 10000;

        Interval1D xinterval = new Interval1D(xlo, xhi);
        Interval1D yinterval = new Interval1D(ylo, yhi);
        Interval2D box = new Interval2D(xinterval, yinterval);
        box.draw();

        Counter counter = new Counter("hits");
        for (int t = 0; t < T; t++) {
            double x = StdRandom.uniform(0.0, 1.0);
            double y = StdRandom.uniform(0.0, 1.0);
            Point2D p = new Point2D(x, y);

            if (box.contains(p)) counter.increment();
            else                 p.draw();
        }

        StdOut.println(counter);
        StdOut.printf("box area = %.2f\n", box.area());
    }
}
