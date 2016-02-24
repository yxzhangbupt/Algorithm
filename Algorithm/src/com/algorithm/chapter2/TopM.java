package com.algorithm.chapter2;

import com.algorithm.chapter1.Stack;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.Transaction;

public class TopM {
	public static void main(String args[]){
		int M = StdIn.readInt();
		MinPQ<Transaction> pq = new MinPQ<Transaction>(M);
		while(StdIn.hasNextLine()){
			pq.insert(new Transaction(StdIn.readLine()));
			if(pq.size() > M){
				pq.delMin();
			}
		}
		
		Stack<Transaction> stack = new Stack<Transaction>();
		while(!pq.isEmpty()) stack.push(pq.delMin());
		for(Transaction t : stack) StdOut.println(t);
	}
}
