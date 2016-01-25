package com.algorithm.chapter1;

import java.awt.SecondaryLoop;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class DoubleNode {
	String item;
	DoubleNode next;
	DoubleNode last;

	public static DoubleNode insertFromHead(DoubleNode oldFirst,String newItem){
		DoubleNode first = new DoubleNode();
		first.next = oldFirst;
		first.last = null;
		first.item=newItem;
		oldFirst.last = first;
		return first;
	}
	
	public static DoubleNode insertFromTail(DoubleNode oldTail,String newItem){
		DoubleNode tail = new DoubleNode();
		tail.next = null;
		tail.last = oldTail;
		tail.item=newItem;
		oldTail.next = tail;;
		return tail;
	}
	
	public static DoubleNode deletFromHead(DoubleNode oldFirst){
		oldFirst.next.last=null;
		return oldFirst.next;
	}
	
	public static DoubleNode deletFromTail(DoubleNode oldTail){
		oldTail.last.next=null;
		return oldTail.last;
	}
	
	public static void insertBeforNode(DoubleNode theNode,DoubleNode newNode){
		if(theNode.last==null){
			theNode.last=newNode;
			newNode.last=null;
		}
		else{
			theNode.last.next=newNode;
			newNode.last=theNode.last;
			theNode.last=newNode;		
		}
		newNode.next=theNode;		
	}
	
	public static void insertAfterNode(DoubleNode theNode,DoubleNode newNode){
		if(theNode.next==null){
			theNode.next=newNode;
			newNode.next=null;
		}
		else{
			theNode.next.last=newNode;
			newNode.next=theNode.next;
			theNode.next=newNode;
		}
		newNode.last=theNode;		
	}
	
	public static void deletTheNode(DoubleNode theNode){
		theNode.next.last = theNode.last;
		theNode.last.next = theNode.next;
	}
	
	public static void main(String args[]){
		DoubleNode first = new DoubleNode();
		DoubleNode second = new DoubleNode();
		DoubleNode third = new DoubleNode();
		DoubleNode newNode = new DoubleNode();
		DoubleNode tail=third;
		
		first.item="to";
		second.item="be";
		third.item="or";
		newNode.item="not";
		
		first.next=second;
		first.last=null;
		second.next=third;
		second.last=first;
		third.next=null;
		third.last=second;
		int i = StdIn.readInt();
		switch (i) {
		case 1:
			first = insertFromHead(first,"not");
			break;
		case 2:
			tail = insertFromTail(third, "not");
			break;
		case 3:
			first = deletFromHead(first);
			break;
		case 4:
			tail = deletFromTail(tail);
			break;
		case 5:
			insertBeforNode(first,newNode);
			first=first.last;
			break;
		case 6:
			insertAfterNode(tail,newNode);
			tail=tail.next;
			break;
		case 7:
			deletTheNode(second);
			break;

		default:
			break;
		}
		for(DoubleNode x=first;x!=null;x=x.next){
			StdOut.println(x.item);
		}
	}
	
}
