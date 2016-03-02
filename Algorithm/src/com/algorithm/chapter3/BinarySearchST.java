package com.algorithm.chapter3;


import edu.princeton.cs.algs4.Queue;

public class BinarySearchST<Key extends Comparable<Key>,Value>{
	
	private Key[] keys;
	private Value[] values;
	private int N;
	
	public BinarySearchST(int capacity){
		keys = (Key[])new Comparable[capacity];
		values = (Value[])new Object[capacity];
	}
	
	public Value get(Key key){
		if(isEmpty()) return null;
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0){
			return values[i];
		}
		else return null;
	}
	
	public int rank(Key key){
		int lo = 0, hi = N-1;
		while(lo <= hi){
			int mid = lo + (lo + hi)/2;
			int cmp = key.compareTo(keys[mid]);
			if(cmp < 0) hi = mid - 1;
			else if(cmp > 0) lo = mid + 1;
			else return mid;
		}
		
		return lo;
	}
	
	public void put(Key key,Value val){
		int i = rank(key);
		if(i<N&&keys[i].compareTo(key)==0){
			values[i] = val;
			return;
		}
		for(int j=N++;j>i;j--){
				keys[j] = keys[j-1];
				values[j] = values[j-1];
		}
		keys[i] = key;
		values[i] = val;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public  int size(){
		return N;
	}
	
//	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return keys[0];
	}
	
	public Key max() {
		// TODO Auto-generated method stub
		return keys[N-1];
	}

//	@Override
	public Key floor(Key key) {
		// TODO Auto-generated method stub
		return keys[rank(key)-1];
	}

//	@Override
	public Key ceiling(Key key) {
		// TODO Auto-generated method stub
		return keys[rank(key)];
	}

//	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return keys[k];
	}

//	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		Queue<Key> queue = new Queue<Key>();
		for(int i = 0;i<N;i++){
			queue.enqueue(keys[i]);
		}
		return queue;
	}
	
	public void delete(Key key){
		int i = rank(key);
		if(keys[i] != key) return;
		for(int j=i;j<N-1;j++ ){
			keys[i] = keys[i+1];
		}
		N--;
	}
	public void deleteMin(){
		delete(min());
	}
	
	public void deleteMax(){
		delete(max());
	}
	
	public boolean contains(Key key){
		return key == keys[rank(key)];
	}
	public int size(Key lo,Key hi){
		if(hi.compareTo(lo)<0) return 0;
		else if(contains(hi))
		return rank(hi)-rank(lo)+1;
		else return rank(hi)-rank(lo);
	}

}
