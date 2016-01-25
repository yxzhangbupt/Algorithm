package com.algorithm.chapter1;


import edu.princeton.cs.algs4.Point2D;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_2_1 {
	public static void main(String args[]){
		int N = StdIn.readInt();
		Point2D[] point2ds = new Point2D[N];
		for(int i=0;i<N;i++){
			point2ds[i]=new Point2D(Math.random(), Math.random());
			point2ds[i].draw();
		}
		
		double min=1;
		double distance=1;
		for(int i=0;i<N;i++){
			for(int j=i+1;j<N;j++){
				distance=point2ds[i].distanceTo(point2ds[j]);
				if(distance<min)
					min = distance;
			}
		}
		
		StdOut.println(min);
	}
}
