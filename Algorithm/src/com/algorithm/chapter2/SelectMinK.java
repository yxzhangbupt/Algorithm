package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdRandom;

public class SelectMinK <item extends Comparable<item>>{
	
	public item select(item[] a,int k){
		StdRandom.shuffle(a);
		int lo = 0,hi = a.length-1;
		while(hi > lo){
			int j = Quick.partition(a, lo, hi);
			if(j < k) lo = j+1;
			else if(j > k) hi = j-1;
			else return a[k];
		}
		
		return a[k]; 
	}

}
