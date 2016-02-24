package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Insertion {
	public static void sort(Comparable[] a){
		int N = a.length;
		//∆’Õ®∞Ê
//		for(int i=1;i<N;i++){
//			for(int j=i;j>0&&less(a[j],a[j-1]);j--)
//				each(a, j, j-1);
//		}
		//”≈ªØ∞Ê
		for(int i=1;i<N;i++){
			int j;
			Comparable u;
			u = a[i];
			for(j=i;j>0&&less(u,a[j-1]);j--)
				a[j] = a[j-1];
			a[j] = u;
		}	
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		int N = hi - lo + 1;
		Comparable temp;
		int i,j;
		for(i =lo+1;i<=hi;i++){
			temp = a[i];
			for(j=i;j>lo&&less(temp, a[j-1]);j--){
				a[j] = a[j-1];
			}
			a[j] = temp;
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
