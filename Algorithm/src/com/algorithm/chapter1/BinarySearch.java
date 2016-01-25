package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdOut;

public class BinarySearch {
	public static <AnyType extends Comparable<? super AnyType>>
	int binarySearch(AnyType[] a,AnyType x){
		int low = 0;
		int high = a.length-1;
		while(low<=high){
			int mid = (low+high)/2;
			if(x.compareTo(a[mid])>0){
				low=mid+1;
			}
			else if(x.compareTo(a[mid])<0){
				high=mid-1;
			}
			else  
				return mid;
		}
		return -1;
	}
	
	public static void main(String args[]){
		Integer [] a={1,2,4,5,6};
		Integer x = 3;
		System.out.println(binarySearch(a, x));
	}

}


