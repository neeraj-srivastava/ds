package com.baseds.recursion;

import java.util.HashMap;
import java.util.Map;

/*
 * Implement pow(x, n) for positive 'x' and n>=0.
 */
public class POW {
	
	private static Map<Integer, Integer> map=new HashMap<>();
	
	public static void main(String[] args) {
		System.out.println(pow(2,30));
	}
	
	/**
	 * @param x		input number of which power to calculate
	 * @param n		power value
	 * @return		final product value of x^n
	 */
	public static int pow(int x, int n){
		
		if(n==0)
			return 1;
		
		if(map.containsKey(n))
			return map.get(n);
		
		if(n%2==0)
			map.put(n, pow(x, n/2)*pow(x, n/2));
		else
			map.put(n, pow(x, n/2)*pow(x, n/2)*x);
		
		return map.get(n);
	}
}
