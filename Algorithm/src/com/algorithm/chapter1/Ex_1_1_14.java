package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_14 {
	static int lg(int N) throws Exception{
		if(N<=1){
			throw new IllegalArgumentException();
		}
		if(N==2)
			return 0;
		int sum=2,i=1;
		while(sum<N){
			sum*=2;
			i++;
		}
		return i-1;
	}
	public static void main(String[] args) throws Exception {
		StdOut.println(lg(4));
		

    }
}
