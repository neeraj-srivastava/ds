package com.baseds.arrays;

import java.util.Arrays;

/*
 * Rotate array by k left shifts
 */
public class RotateArray {

	public static void main(String[] args) {
		int[] arr={1,2,3,4,5,6,7,8,9};
		roate(arr, 4);
		System.out.println(Arrays.toString(arr));
	}
	
	/*
	 * Idea behind below implementation
	 * Let's say input array is {1,2,3,4,5,6,7,8,9}
	 * Left rotation shift is 4
	 * 
	 * First reverse this full array i.e. {9,8,7,6,5,4,3,2,1}
	 * Now reverse first (n-r)i.e 9-4 elements of array {5,6,7,8,9,4,3,2,1}
	 * Last reverse last r i.e. 4 elements of array {5,6,7,8,9,1,2,3,4}  
	 */
	/**
	 * This method takes O(n)
	 * @param arr		input array
	 * @param r			left shifts
	 */
	public static void roate(int[] arr, int r){
		int n=arr.length;
		r=r%n;

		if(n==0 || n==1 || r==0)
			return;

		for(int i=0; i<n/2; i++){
			int temp=arr[i];
			arr[i]=arr[n-i-1];
			arr[n-i-1]=temp;
		}

		int p=n-r;
		for(int j=0; j<p/2; j++){
			int temp=arr[j];
			arr[j]=arr[p-j-1];
			arr[p-j-1]=temp;
		}


		for(int k=0; k<r/2; k++){
			int temp=arr[k+p];
			arr[k+p]=arr[n-k-1];
			arr[n-k-1]=temp;
		}
	}
}
