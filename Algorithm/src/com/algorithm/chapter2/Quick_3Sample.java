package com.algorithm.chapter2;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class Quick_3Sample {
	public static void sort(Comparable[] a){
		StdRandom.shuffle(a);
		
		//�������Ҳ��ڱ�,��β��3sampleȡ��
		int max = 0;
		for(int i=1;i<a.length;i++){
			if(less(a[max],a[i]))
				max = i;
		}
		each(a, max, a.length-1);
		
		sort(a,0,a.length-1);
	}
	
	public static void sort(Comparable[] a,int lo,int hi){
		if(hi <= lo + 28) {
			Insertion.sort(a, lo, hi);
			return;
		};
		int j = partition(a,lo,hi);
		sort(a, lo, j);
		sort(a, j+1, hi);
	}
	

	
	public static int partition(Comparable[] a,int lo,int hi){
		
		//�з�ʱȡͷ�������򣬽���1,2Ԫ��
//		Insertion.sort(a, lo, lo+2);
//		each(a, lo, lo+1);
		
		//β��3ȡ�������Դ����Ҳ��ڱ�
//		Insertion.sort(a, hi-2, hi);
//		each(a, lo, hi-1);
		
		int i = lo,j = hi + 1;
		Comparable u = a[lo];
		while(true){
			while(less(a[++i],u)){
				//����һ����a[hi+1]>u,�������߽��ж�
//				if(i == hi)
//					break;
			}
			while(less(u,a[--j])){
				//����һ����a[lo]=u,�������߽��ж�
//				if(j == lo)
//					break;
			}
			if(i >= j){
				break;
			}
			each(a, i, j);
		}
		each(a, lo, j);
		return j;
	}
	public static boolean less(Comparable v,Comparable w){
		return v.compareTo(w)<0;
	}
	
	public static void each(Comparable[] a,int i,int j){ 		
		Comparable temp = a[i];
		a[i] = a[j];
		a[j] = temp;
	}
	
	public static void show(Comparable[] a){
		for(Comparable i:a){
			StdOut.print(i+" ");
		}
		StdOut.println();
	}
	
	public static boolean isSorted(Comparable[] a){
		for(int i=0;i<a.length-1;i++){
			if(a[i].compareTo(a[i+1])>0)
				return false;
		}
		return true;
	}
	
	public static void main(String args[]){
		int N = StdIn.readInt();
		Double[] a = new Double[N];
		for(int i = 0;i < N;i++){
			a[i] = StdRandom.uniform();
		}
		sort(a);
		assert isSorted(a);
		show(a);		
		}
}
