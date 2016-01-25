package com.algorithm.chapter1;

import java.util.Iterator;

public class RisizingArrayQueueOfStrings implements Iterable<String>{
	private String[] a = new String[1];
	int head,tail;
	
	public boolean isEmpty(){
		return head==tail;
	}
	
	public int size(){
		if(head<=tail)
			return  tail-head;
		else return a.length-(tail-head);
	}
	
	private void resize(int max) {
		String[] temp = new String[max];
		if(head<=tail){
			for(int i=0;i<size();i++){
				temp[i] = a[tail++];
			}
		}
		else {
			for(int i=0;i<size();i++){
				temp[i] = a[tail++];
				if(tail>a.length)
					tail=0;
			}
		}
		
		a = temp;
	}
	
	public void enqueue(String s){
		if(size()==a.length-1)
			resize(2*a.length);
		a[head++] = s;
		if(head==a.length)
			head=0;
	}
	
	public String dequeue(){
		String s = a[tail];
		a[tail] = null;
		tail++;
		if(size()>0&&size()==a.length/4)
			resize(a.length/2);
		if(tail==a.length)
			tail = 0;
		return s;
	}
	
	public Iterator<String> iterator(){
		return new QueueIterator();
	}
	
	private class QueueIterator implements Iterator<String>{
		private int i = head;
		private int j = tail;
		private int size = size();
		public boolean hasNext(){ return size>0;}
		public String next(){
			
			String s = a[j];
			j++;
			size--;
			if(j>a.length)
				j=0;
			return s;
		}
		public void remove(){};
	
	}
	
}
