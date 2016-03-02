package com.algorithm.chapter3;

import java.util.Iterator;

public abstract class ST<Key extends Comparable<Key>,Value> {
	public ST(){
		
	}
	
	public abstract void put(Key k,Value v);
	
	public abstract Value get(Key key);
	
	public abstract void delete(Key key);
	
	public abstract boolean contains(Key key);
	
	public abstract boolean isEmpty();
	
	public abstract int size();
	
	public abstract Key min();
	
	public abstract Key max();
	
	public abstract Key floor();
	
	public abstract Key ceiling();
	
	public abstract int rank(Key key);
	
	public abstract Key select(int k);
	
	public void deleteMin(){
		delete(min());
	}
	
	public void deleteMax(){
		delete(max());
	}
	
	public int size(Key lo,Key hi){
		if(hi.compareTo(lo)<0) return 0;
		else if(contains(hi))
		return rank(hi)-rank(lo)+1;
		else return rank(hi)-rank(lo);
	}
	
	public abstract Iterable<Key> keys (Key lo,Key hi);
	
	public Iterable<Key> keys (){
		return keys(min(), max());
		
	}
	
	
	
	
}
