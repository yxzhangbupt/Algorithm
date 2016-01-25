package com.algorithm.chapter1;


import edu.princeton.cs.algs4.Interval1D;
import edu.princeton.cs.algs4.Interval2D;
import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Ex_1_2_3 {
	public static void main(String args[]){
		int N = StdIn.readInt();
		int min = StdIn.readInt();
		int max = StdIn.readInt();
		assert min<max :"min must smaller than max!";
		Interval2D[] interval2ds = new Interval2D[N];
		for(int i=0;i<N;i++){
			int a,b,c,d;
			a = StdRandom.uniform(min, max);
			c = StdRandom.uniform(min, max);
			b = StdRandom.uniform(a, max);
			d = StdRandom.uniform(c, max);
			interval2ds[i]=new Interval2D(new Interval1D(a, b), new Interval1D(c, d));
			interval2ds[i].draw();
		}
		

		StdOut.println(min);
		
		Interval1D interval1da = new Interval1D(0.1, 0.2);
		Interval1D interval1db = new Interval1D(0.2, 0.3);
		Interval2D interval2d = new Interval2D(interval1da, interval1db);
		interval2d.draw();
	}
}
