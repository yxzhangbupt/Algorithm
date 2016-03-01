package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Shell {
	public static void sort(Comparable[] a){
		int N = a.length;
		int h = 1;
		while(h<N/3) h = 3 * h + 1;
		while(h >= 1){
			for(int i=h;i<N;i++){
				for(int j=i;j>=h&&less(a[j],a[j-h]);j-=h)
					each(a, j, j-h);
			}
			h /=3;
		}
	}
	
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void each(Comparable[] a,int i,int j){
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Comparable[] a){
		for(Comparable i:a){
			StdOut.print(i+" ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=0;i<a.length-1;i++){
			if(a[i].compareTo(a[i+1])>0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		String[] a = StdIn.readAllStrings();
		sort(a);
		assert isSorted(a);
		show(a);	}
}
