package com.algorithm.chapter2;

public class MinPQ<key extends Comparable<key>> {
	int N = 0;
	private key[] pq;
	
	public MinPQ(int M){
		pq = (key[])new Comparable[M+1] ;
	}
	
	public MinPQ(key[] a){
		pq = (key[])new Comparable[a.length+1] ;
		for(int i=0;i<a.length;i++){
			insert(a[i]);
		}
	}
	
	public void insert(key v){
		if(N == pq.length-1){
			 resize(2*pq.length);
		}
		pq[++N] = v;
		swim(N);
//		N++;
	}
	
	public key delMin(){
		key k = pq[1];
		each(1, N);
		pq[N--] = null;
		sink(1);
		if(N <= pq.length/4){
			resize(pq.length/2);
		}
		return k;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){
		return N;
	}
	private void resize(int M) {
		key[] temp = (key[])new Comparable[M];
		for(int i=0;i<pq.length;i++){
			temp[i] = pq[i];
		}
		pq = temp;
	}
	
	private void swim(int k) {
		while(k>1&&less(k, k/2)){
			each(k/2, k);
			k /= 2;
		}
	}
	
	private void sink(int k) {
		while(2*k <= N){
			int j = 2*k;
			if(j<N&&less(j+1, j))
				j++;
			if(!less(j, k)) break;
			each(k, j);
			k=j;
		}
	}
	
	private boolean less(int i,int j) {
		return pq[i].compareTo(pq[j])<0;
	}
	
	private void each(int i,int j) {
		key u;
		u= pq[i];
		pq[i] = pq[j];
		pq[j] = u;
	}

}
