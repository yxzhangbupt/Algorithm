package com.algorithm.chapter1;

import java.lang.reflect.Array;
import java.util.Arrays;

import edu.princeton.cs.algs4.BinarySearch;
import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class TwoSumFast {
	public static int count(int[] a){
		Arrays.sort(a);
		int cnt = 0;
		int N = a.length;
		for(int i = 0;i<N;i++){
			if(BinarySearch.indexOf(a, -a[i])>i)
			cnt++;
		}
		return cnt;
	}
	
	public static void main(String args[]){
		In input = new In("D:/data/algs4-data/8Kints.txt");
		int[] a = input.readAllInts();
		StdOut.print(count(a));
	}
}
