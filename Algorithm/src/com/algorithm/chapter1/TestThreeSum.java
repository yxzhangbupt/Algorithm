package com.algorithm.chapter1;

import java.io.File;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Stopwatch;
import edu.princeton.cs.algs4.ThreeSum;

public class TestThreeSum {
	public static void main(String[] args)  { 
		
        In input = new In("D:/data/algs4-data/8Kints.txt");
        int[] a = input.readAllInts();

        Stopwatch timer = new Stopwatch();
        int cnt = ThreeSum.count(a);
        StdOut.println("elapsed time = " + timer.elapsedTime());
        StdOut.println(cnt);
    } 
}
