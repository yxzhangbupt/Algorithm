package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_15 {
	
	static int[] histogram(int[] a,int M){
		int[] b = new int[M];
		for(int i=0;i<a.length;i++){
			if(a[i]<M){
				b[a[i]]++;
			}
		}
		return b;
	}
	public static void main(String[] args){
		int[] a = {1,1,1,2,2,3,4,4,5,6,7};
		int[] b = histogram(a, 10);
		for(int i=0;i<b.length;i++){
			StdOut.print(b[i]+"  ");
		}
//		StdOut.println(histogram(a, 5));
		

    }
}
