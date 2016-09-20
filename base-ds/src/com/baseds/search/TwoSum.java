package com.baseds.search;
/*
 * Original question source https://leetcode.com/problems/two-sum/
 */
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class TwoSum {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int[] inputArray={3,2,4};
		int targetSum=6;

		int[] result=twoSum(inputArray, targetSum);

		System.out.println(Arrays.toString(result));
	}

	
	/*
	 * Below method takes O(n) to solve this problem
	 */
	/**
	 * @param nums		input integer array
	 * @param target	target sum
	 * @return output	array containing resultant indices
	 */
	static public int[] twoSum(int[] nums, int target) {

		int[] output=new int[2];
		Arrays.fill(output, -1);

		if(nums.length<=1)
			return output;

		int n=nums.length;
		Map<Integer, Integer> map=new HashMap<>();


		for(int i=0; i<n; i++)
			map.put(nums[i], i);

		for(int j=0; j<n; j++){
			int a=nums[j];
			if(map.containsKey(target-a)){
				if(j != map.get(target-a)){
					output[0]=j;
					output[1]=map.get(target-a);
					break;
				}
			}
		}

		return output;
	}
}
