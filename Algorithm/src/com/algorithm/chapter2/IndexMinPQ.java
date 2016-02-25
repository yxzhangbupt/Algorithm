package com.algorithm.chapter2;

public class IndexMinPQ<Item extends Comparable<Item>> {
	int N = 0;
	private Item[] keys;
	private int[] pq;
	private int[] qp;
	
	public IndexMinPQ(int M){
		keys = (Item[])new Comparable[M+1] ;
		pq = new int[M+1];
		qp = new int[M+1]; 
		for(int i=0;i<qp.length;i++) qp[i] = -1;
	}
	
	
	public void insert(int k,Item item){
		if(N == keys.length-1){
			 resize(2*keys.length);
		}
		N++;
		pq[N] = k;
		qp[k] = N;
		keys[N] = item;
		swim(N);
//		N++;
	}
	
	public void change(int k,Item item){
		keys[qp[k]] = item;
		swim(qp[k]);
		sink(qp[k]);
	}
	
	public void delelte(int k){
		each(qp[k], N);
		keys[N] = null;
		qp[pq[N]] = -1;
		N--;
		sink(qp[k]);
		swim(qp[k]);
	}
	
	public Item min(){
		return keys[1];
	}
	
	public int minIndex(){
		return pq[1];
	}
	
	
	
	public int delMin(){
		int k = pq[1];
		delelte(1);
		if(N <= keys.length/4){
			resize(keys.length/2);
		}
		return k;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public boolean contains(int k){
		return qp[k] != -1;
	}
	
	public int size(){
		return N;
	}
	private void resize(int M) {
		Item[] temp = (Item[])new Comparable[M];
		int[] tempPQ = new int[M];
		int[] tempQP = new int[M];
		for(int i=0;i<keys.length;i++){
			temp[i] = keys[i];
		}
		for(int i=0;i<pq.length;i++){
			tempPQ[i] = pq[i];
		}
		for(int i=0;i<qp.length;i++){
			tempQP[i] = qp[i];
		}
		keys = temp;
		pq = tempPQ;
		qp = tempQP;
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
		return keys[i].compareTo(keys[j])<0;
	}
	
	private void each(int i,int j) {
		Item u;
		int pqIndex,qpIndex;
		u= keys[i];
		keys[i] = keys[j];
		keys[j] = u;
		
		pqIndex = pq[i];
		pq[i] = pq[j];
		pq[j] = pqIndex;
		
		qpIndex = qp[i];
		qp[i] = qp[j];
		qp[j] = qpIndex;
		
		
	}

}
