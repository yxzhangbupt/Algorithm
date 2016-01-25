package com.algorithm.chapter1;

import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;

public class Parentheses {
	public static void main(String[] args) {
		boolean parentheses = true;
		String string = StdIn.readString();
		int lenth = string.length();
        Stack<Character> s = new Stack<Character>();
        for(int i=0;i<lenth;i++){
            char item = string.charAt(i);
            if (item=='('||item=='['||item=='{') s.push(item);
            else	
            	if(item==')'){
            		if(s.pop()!='(')
            			parentheses = false;
            	}
            	else if(item==']'){
            		if(s.pop()!='[')
            			parentheses = false;
            	}
            	else if(item=='}'){
            		if(s.pop()!='{')
            			parentheses = false;
            	}
        }
        if(!s.isEmpty()){
        	parentheses = false;
        }
        StdOut.print(parentheses);
        
    }
}
