package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick3way {
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);	
		sort(a,0,a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo) {
			return;
		};
		int it = lo , i = lo + 1, gt = hi;
		Comparable v = a[lo];
		while(i <= gt){
			int cmp = v.compareTo(a[i]);
			if(cmp > 0){
				each(a, i++, it++);
			}
			if(cmp < 0){
				each(a, i, gt--);
			}
			else i++;
		}
		sort(a, lo, it-1);
		sort(a, gt+1, hi);
	}
	

	
	public static int partition(Comparable[] a,int lo,int hi){
		int i = lo,j = hi + 1;
		Comparable u = a[lo];
		while(true){
			while(less(a[++i],u)){
				//由于一定有a[hi+1]>u,因此无需边界判断
				if(i == hi)
					break;
			}
			while(less(u,a[--j])){
				//由于一定有a[lo]=u,因此无需边界判断
//				if(j == lo)
//					break;
			}
			if(i >= j){
				break;
			}
			each(a, i, j);
		}
		each(a, lo, j);
		return j;
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
		int N = StdIn.readInt();
		Double[] a = new Double[N];
		for(int i = 0;i < N;i++){
			a[i] = StdRandom.uniform();
		}
		sort(a);
		assert isSorted(a);
		show(a);		
		}

}
