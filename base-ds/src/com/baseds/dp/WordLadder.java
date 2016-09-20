package com.baseds.dp;

import java.util.Set;


public class WordLadder {

	public static void main(String[] args) {

	}
	
	/*
	 * Recursive approach
	 */
	public static int wordLadder(String input, String end, Set<String> dict, int level){
		int len=input.length();
		if(len != end.length())
			return -1;
		
		if(input.equalsIgnoreCase(end))
			return level;
		
		for(int i=0; i<len; i++){
			
			for(char ch='a'; ch<='z'; ch++){
				String temp=input.substring(0,i) + ch + input.substring(i+1);
				if(dict.contains(temp))
					return wordLadder(temp, end, dict, level+1);
			}
		}
		
		return -1;
	}
}
