package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;
import edu.princeton.cs.algs4.Stopwatch;

public class SortCompare {
	public static double time(String alg,Comparable[] a){
		Stopwatch timer = new Stopwatch();
		if(alg.equals("Insertion")) Insertion.sort(a);
		if(alg.equals("Selection")) Selection.sort(a);
		if(alg.equals("Shell")) Shell.sort(a);
		if(alg.equals("Merge")) Merge.sort(a);
		if(alg.equals("Merge_1")) Merge_1.sort(a);
		if(alg.equals("MergeBU")) MergeBU.sort(a);
		if(alg.equals("Quick")) Quick.sort(a);
		if(alg.equals("Quick_3Sample")) Quick_3Sample.sort(a);
//		if(alg.equals("Heap") Heap.sort(a);
		return timer.elapsedTime();
		
	}
	
	public static double timeRandomInput(String alg,int N,int T){
		double total = 0.0;
		Double[] a = new Double[N];
		for(int t = 0;t < T;t++){
			for(int i = 0;i < N;i++){
				a[i] = StdRandom.uniform();
			}
			total += time(alg, a);
		}
		return total;
	}
	
	public static void main(String args[]){
		String alg1 = StdIn.readString();
		String alg2 = StdIn.readString();
		int N = StdIn.readInt();
		int T = StdIn.readInt();
		double t1 = timeRandomInput(alg1, N, T);
		double t2 = timeRandomInput(alg2, N, T);
		StdOut.printf("For %d random Doubles\n  %s is",N,alg1 );
		StdOut.printf(" %.1f times faster than %s\n",t2/t1,alg2 );
		
	}
}
