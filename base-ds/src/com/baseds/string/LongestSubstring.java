package com.baseds.string;

import java.util.Arrays;

/*
 * Longest substring in a string without repeating character i.e. 
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * Given "bbbbb", the answer is "b", with the length of 1.
 * 
 * Question source: https://leetcode.com/problems/longest-substring-without-repeating-characters/
 */

public class LongestSubstring {

	public static void main(String[] args) {
		System.out.println(lengthOfLongestSubstring("abcabcbb"));
	}
	
	/**
	 * Time complexity of this method is O(n)
	 * @param s			input string
	 * @return max_len	maximum length of string without repeating char
	 */
	public static int lengthOfLongestSubstring(String str) {
        int n=str.length();
		int max_len=0;
        
        if(n==0)
			return 0;
		
        int[] charMap=new int[256];
		Arrays.fill(charMap, -1);
		int start=0;
		
		for(int i=0; i<n; i++){
			
			if(charMap[str.charAt(i)] >= start){
				start=charMap[str.charAt(i)]+1;
			}
			
			charMap[str.charAt(i)]=i;
			max_len=Math.max(i-start+1, max_len);
		}
		
		return max_len;
    }
}
