package com.algorithm.chapter3;

import javax.swing.text.StyledEditorKit.ItalicAction;

import edu.princeton.cs.algs4.Queue;

public class SequentialSearchST <Key extends Comparable<Key>,Value>{
	private int N;
	private Node first;
	
	private class Node{
		Key key;
		Value val;
		Node next;
		public Node(Key key, Value val, Node next) {
			this.key = key;
			this.val = val;
			this.next = next;
		}
		
	}
	
//	@Override
	public void put(Key k, Value v) {
		// TODO Auto-generated method stub
		for(Node x = first;x != null;x = x.next){
			if(x.key.equals(k)){
				x.val = v;
				return;
			}
		}
		first = new Node(k, v, first); 
		N++;
	}

//	@Override
	public Value get(Key key) {
		// TODO Auto-generated method stub
		for(Node x = first;x != null;x = x.next){
			if(x.key.equals(key)){		
				return x.val ;
			}
		}
		return null;
	}

//	@Override
	public void delete(Key key) {
		// TODO Auto-generated method stub
		//延时性删除
//		for(Node x = first;x != null;x = x.next){
//			if(x.key.equals(key)){		
//				x.val = null ;
//			}
//		}
		//及时性删除
		for(Node x = first;x != null;x = x.next){
			if(x.next.val==null){		
				x.next = x.next.next;
				N--;
			}
		}
	}

//	@Override
	public boolean contains(Key key) {
		// TODO Auto-generated method stub
		
		return get(key) != null ;
	}

//	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub
		return false;
	}

//	@Override
	public int size() {
		// TODO Auto-generated method stub
		int N = 0;
		for(Node x = first;x != null;x = x.next){
			N++;
			}
		return N;
	}

//	@Override
	public Key min() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Key max() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Key floor() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Key ceiling() {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public int rank(Key key) {
		// TODO Auto-generated method stub
		return 0;
	}

//	@Override
	public Key select(int k) {
		// TODO Auto-generated method stub
		return null;
	}

//	@Override
	public Iterable<Key> keys() {
		// TODO Auto-generated method stub
		Queue<Key> queue = new Queue<Key>();
		for(Node x = first;x != null;x = x.next){
			queue.enqueue(x.key);
		}
		return queue;
	}
	
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
	
}
