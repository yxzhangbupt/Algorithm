package com.algorithm.chapter1;

public class Queue<T> {
	private Node first;
	private Node last;
	
	private int N;
	private class Node<T>{
		T t;
		Node next;
	}
	
	public boolean isEmpty(){
		return N==0;
	}
	
	public int size(){return N;}
	
	public void enQueue(T t){
		Node oldLast = last;
		last = new Node<T>();
		last.t = t;
		if(isEmpty())	first = last;
		else	oldLast.next = last;
		N++;
	}

	public T deQueue(){
		T t = (T)first.t;
		first = first.next;
		if(isEmpty()) last = null;
		N--;
		return t;
	}
	
}
