package com.baseds.dp;

import java.util.Arrays;
import java.util.Set;

/*
 * Given a string s and a dictionary of words dict, determine if s can be segmented into a space-separated 
 * sequence of one or more dictionary words.
 */

public class WordBreak {

	public static void main(String[] args) {

	}
	
	/*
	 * Normal recursive approach.
	 */
	public static boolean wordBreak(String str, Set<String> dict, int start){
		
		if(start==str.length())
			return true;
		
		int n=str.length() -start;
		
		
		
		for(String runner:dict){
			int p=runner.length();
			
			if(p>n)
				continue;
			
			
			String s1=str.substring(start,p);
			
			if(s1.equalsIgnoreCase(runner))
				return wordBreak(str, dict, p);
		}
		
		
		
		return false;
	}
	
	
	/*
	 * Dynamic approach with memoization 
	 */
	/**
	 * @param str		input string to check whether it can be broken into multiple words or not
	 * @param dict		existing dictionary
	 * @return			true if input string can be broken into strings provided via dictionary
	 */
	public static boolean wordBreakDP(String str, Set<String> dict){
		boolean[] result=new boolean[str.length()+1];
		Arrays.fill(result, false);
		result[0]=true;
		
		int len=str.length();
		
		for(int i=0; i<len; i++){
			
			if(!result[i])
				continue;
			
			for(String runner:dict){
				int rl=runner.length();
				
				if(rl>(len-i))
					continue;
				
				if(result[i])
					continue;
				
				if(str.substring(i,i+rl).equalsIgnoreCase(runner))
					result[i]=true;
			}
			
		}
		
		return result[len];
	}

}
