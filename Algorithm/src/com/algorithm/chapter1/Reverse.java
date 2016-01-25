package com.algorithm.chapter1;

public class Reverse {
	private static class Node<Item>{
		Item item;
		Node next;
	}
	public static Node reverse(Node first1){
		Node first2 = new Node();
		first2.item = first1.item;
		Node current2 = first2;
		while(first1!=null){
			Node temp = new Node();
			temp.item = first1.item;
			temp.next = current2;
			current2 = temp;
			first1 = first1.next;
		}
		return first2;
		
		
	}
}
