package com.algorithm.chapter1;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class UF {
	private int[] id;
	private int count;
	//weighted quick-union
	private int[] sz;
	
	public UF(int N){
		count = N;
		id = new int[N];
//		int i = 0;
		//此处不能使用for each
		for(int i =0;i<N;i++){
			id[i] = i;
		}
		
		//weighted quick-union
		sz = new int[N];
		for(int i=0;i<N;i++){
			sz[i] = 1;
		}
	}
	
	public int count(){
		return count;
	}
	
	public boolean connected(int p,int q){
		return find(p)==find(q);
	}
	
	public int find(int p){
		//quick-find
//		return id[p];
		
		//quick-union
		int rootPoint = p;
		while(rootPoint!=id[rootPoint]){
			rootPoint = id[rootPoint];
		}
		return rootPoint;
	}
	
	public void union(int p,int q){
		//quick-find
//		int stayCom = find(p);
//		int changeCom = find(q);
//		if (stayCom == changeCom)
//			return;
//		for(int i=0;i<id.length;i++){
//			if(id[i]==changeCom)
//				id[i] = stayCom;
//		}
		
		//quick-union
//		int rootP = find(p);
//		int rootQ = find(q);
//		if(rootP == rootQ)
//			return;
//		id[rootP] = rootQ;
		
		//weighted quick-union
		int rootP = find(p);
		int rootQ = find(q);
		if(rootP == rootQ)
			return;
		if(sz[rootP]<sz[rootQ]) {id[rootP]=rootQ; sz[rootQ] += sz[rootP];}
		else {id[rootQ]=rootP; sz[rootP] += sz[rootQ];}
		
		
		count--;
		
	}
	
	public static void main(String args[]){
		In input = new In("D:/data/algs4-data/largeUF.txt");
		int N = input.readInt();
		UF uf = new UF(N);
		while(!input.isEmpty())
		{
			int p = input.readInt();
			int q = input.readInt();
			if(uf.connected(p, q))
				continue;
			uf.union(p, q);
			StdOut.println(p+" "+q);
		}
		
		StdOut.print(uf.count+" "+"component");
	}
}


