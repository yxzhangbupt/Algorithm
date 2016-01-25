package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Ex_1_1_24 {
	


    public static int Euclid(int p,int q)
    {
        if(p%q==0)
        	return q;
        StdOut.print(p+"  ");
        StdOut.println(q);
        return Euclid(q, p%q);
    }
    
    public static void main(String[] args)
    {
        int p,q;
        p = StdIn.readInt();
        q = StdIn.readInt();
        StdOut.print(Euclid(p, q));
    }
}
