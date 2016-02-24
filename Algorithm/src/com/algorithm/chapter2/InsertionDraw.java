package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdDraw;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class InsertionDraw {
	public static void sort(Double[] a){
		int N = a.length;
		//∆’Õ®∞Ê
//		for(int i=1;i<N;i++){
//			for(int j=i;j>0&&less(a[j],a[j-1]);j--)
//				each(a, j, j-1);
//			show(a);
//		}
		//”≈ªØ∞Ê
		for(int i=1;i<N;i++){
			int j;
			Double u;
			u = a[i];
			for(j=i;j>0&&less(u,a[j-1]);j--){
				a[j] = a[j-1];}
			a[j] = u;
			show(a);
		}
		
		
	}
	
	public static boolean less(Double v,Double w){
		return v.compareTo(w)<0;
	}
	
	public static void each(Double[] a,int i,int j){
		Double temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Double[] a){
		StdDraw.clear();
		int N = a.length;
		for(int i=0;i<N;i++){
			double x = 1.0*i/N;
			double y = a[i]/2.0;
			double rw = 0.25/N;
			double rh = a[i]/2.0;
			StdDraw.filledRectangle(x, y, rw, rh);;
		}
//		for(Comparable i:a){
//			StdOut.print(i+" ");
//		}
//		StdOut.println();
	}
	
	public static boolean isSorted(Double[] a){
		for(int i=0;i<a.length-1;i++){
			if(a[i].compareTo(a[i+1])>0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		Double[] a = new Double[50];
		for(int i=0;i<a.length;i++){
			a[i] = StdRandom.random();
		}
		sort(a);
		assert isSorted(a);
		show(a);
			}
}
