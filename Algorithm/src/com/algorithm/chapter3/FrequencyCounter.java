package com.algorithm.chapter3;

import edu.princeton.cs.algs4.In;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class FrequencyCounter {
	public static void main(String args[]){
		int minlen = StdIn.readInt();
		
		In input = new In(DataPath.dataPath+"tinyTale.txt");
		
		SequentialSearchST<String,Integer> FrqCount = new SequentialSearchST<String,Integer>();
		while(!input.isEmpty()){
			String key = input.readString();
			if(key.length()<minlen) continue;
			if(!FrqCount.contains(key)){
				FrqCount.put(key, 1);
			}
			else FrqCount.put(key, FrqCount.get(key)+1);
			
		}
		
		String maxFrqStr = "";
		FrqCount.put(maxFrqStr, 0);
//		Integer maxFrq = 0;
		for(String s : FrqCount.keys()){
			if(FrqCount.get(s).compareTo(FrqCount.get(maxFrqStr))>0){
//				maxFrq = FrqCount.get(s);
				maxFrqStr = s;
			}
		}
		StdOut.println("the most frequent word is:"+maxFrqStr );
		StdOut.println("It appear "+FrqCount.get(maxFrqStr)+" Times." );
	}
}
