package com.baseds.string;

/*
 * Given a string, find out the lexicographically smallest and largest substring of length .
 * Note: Lexicographic order is also known as alphabetic order dictionary order. 
 * So "ball" is smaller than "cat", "dog" is smaller than "dorm". 
 * Capital letter always comes before smaller letter, so "Happy" is smaller than "happy" and "Zoo" is smaller than "ball".
 */

public class CompareString {

	public static void main(String[] args) {
		findMinMaxSubstring("welcometojava", 3);
	}
	
	public static void findMinMaxSubstring(String str, int k){
        int n=str.length();
        
        String minStr=str.substring(0,k);
        String maxStr=minStr;
        
        for(int i=1; i<= n-k; i++){
        	
        	String temp=str.substring(i, i+k);
        	
            int cmp=minStr.compareTo(temp);
            if(cmp>0)
                minStr=temp;
            else{
                cmp=maxStr.compareTo(temp);
                if(cmp<0)
                    maxStr=temp;
             }
        }
        
        System.out.println("min string:"+minStr);
        System.out.println("max string:"+maxStr);
    }
}
