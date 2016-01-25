package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_5 {
	public static void main(String args[]){
		double[] a = new double[2];
		for(int i=0;i<2;i++){
			a[i]=StdIn.readDouble();
		}
		if(a[0]>0&&a[0]<1&&a[1]>0&&a[1]<1){
			StdOut.println("true");
		}
		else StdOut.println("false");
	}
}
