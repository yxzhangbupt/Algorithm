package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class MergeBU {
private static Comparable[] aux;
	//自底而上的归并排序
	public static void merge(Comparable[] a,int lo,int mid,int hi){
		int i = lo;
		int j = mid + 1;
		for(int k = lo;k <= hi;k++){
			aux[k] = a[k];
		}
		for(int k = lo;k <= hi;k++){
			if(i>mid) a[k] = aux[j++];
			else if(j>hi) a[k] = aux[i++];
			else if(less(aux[j], aux[i])) a[k] = aux[j++];
			else a[k] = aux[i++];
		}
	}
	
	public static void sort(Comparable[] a){
		aux = new Comparable[a.length];
		int N = a.length;
		for(int sz=1;sz<N;sz*=2){
			for(int lo=0;lo<=N-sz;lo+=2*sz){
				merge(a, lo,lo+sz-1, Math.min(lo+2*sz-1, N-1));
			}
		}
	}

	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void each(Comparable[] a,int i,int j){ 		Comparable temp = a[i];
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
//		String[] a = StdIn.readAllStrings();
		int N = StdIn.readInt();
		Double[] a = new Double[N];
		for(int i = 0;i < N;i++){
			a[i] = StdRandom.uniform()*10;
		}
		sort(a);
		assert isSorted(a);
		show(a);	
		}
}
