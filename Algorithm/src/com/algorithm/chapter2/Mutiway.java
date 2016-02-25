package com.algorithm.chapter2;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdOut;

public class Mutiway {
	public static void merge(In[] streams){
		int N = streams.length;
		IndexMinPQ<String> pq = new IndexMinPQ<String>(N);
		
		for(int i=0;i<N;i++){
			if(!streams[i].isEmpty())
			pq.insert(i, streams[i].readString());
		}
		
		while (!pq.isEmpty()) {
			StdOut.println(pq.min());
			int i = pq.delMin();
			if(!streams[i].isEmpty())
				pq.insert(i, streams[i].readString());
		}
	}
	public static void main(String args[]){
		In[] streams = new In[3];
		streams[0] = new In("D:/data/algs4-data/m1.txt");
		streams[1] = new In("D:/data/algs4-data/m2.txt");
		streams[2] = new In("D:/data/algs4-data/m3.txt");
		merge(streams);
	}
}
