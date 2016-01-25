package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_13 {
	public static void main(String[] args) {
		int index=1;
		int[][] a = new int[2][3];
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[1].length;j++){
				a[i][j]=index;
				index++;
			}
		}
		for(int i=0;i<a.length;i++){
			for(int j=0;j<a[1].length;j++){
				StdOut.print(a[i][j]);
				StdOut.print("   ");
			}
			StdOut.println();
		}
		for(int i=0;i<a[1].length;i++){
			for(int j=0;j<a.length;j++){
				StdOut.print(a[j][i]);
				StdOut.print("   ");
			}
			StdOut.println();
		}

    }
}
