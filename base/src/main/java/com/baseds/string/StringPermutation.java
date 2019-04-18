package com.baseds.string;

import java.util.ArrayList;
import java.util.List;

/*
 * Find all permutation of string
 */
public class StringPermutation {

	public static void main(String[] args) {
		System.out.println(recursive("abc"));
	}
	
	/**
	 * This is a simple normal recursion method for string permutation 
	 * @param str	input string
	 * @return		list containing all possible strings
	 */
	public static List<String> recursive(String str){
		if(str==null)
			return null;
		
		List<String> permutation=new ArrayList<String>();
		if(str.length()==0){
			permutation.add("");
			return permutation;
		}

		char ch=str.charAt(0);

		List<String> tempList=recursive(str.substring(1));

		for(String temp:tempList){
			for(int j=0; j<=temp.length(); j++){
				permutation.add(insertChar(temp, ch, j));
			}
		}
		return permutation;
	}
	
	/**
	 * Method to insert a char at any index in a supplied string
	 * @param s1		input string
	 * @param ch		character to be added
	 * @param index		index at which char to be added
	 * @return			resultant string
	 */
	private static String insertChar(String s1, char ch, int index){
		int n=s1.length();
		char[] charArray=new char[n+1];
		
		
		for(int i=0; i<index; i++)
			charArray[i]=s1.charAt(i);

		charArray[index]=ch;
		
		for(int j=index+1; j<=n; j++)
			charArray[j]=s1.charAt(j-1);
			
		return new String(charArray);
	}
}
