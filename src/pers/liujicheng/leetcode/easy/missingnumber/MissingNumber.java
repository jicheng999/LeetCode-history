package pers.liujicheng.leetcode.easy.missingnumber;



/**
 * Given an array containing n distinct numbers taken from 0, 1, 2, ..., n, find the one that is missing from the array.

Example 1:

Input: [3,0,1]
Output: 2
Example 2:

Input: [9,6,4,2,3,5,7,0,1]
Output: 8
Note:
Your algorithm should run in linear runtime complexity. Could you implement it using only constant extra space complexity?
 *
 */
public class MissingNumber {
	public int missingNumber(int[] nums) {
		int[] arr=new int[nums.length+1];
		boolean hasZero=false;
		for (int i = 0; i < nums.length; i++) {
			arr[nums[i]]=nums[i];
			if (0==nums[i]) {
				hasZero=true;
			}
		}
		
		if (!hasZero&&0==nums[0]) {
			return 0;
		}
		
		for (int i = 0; i < arr.length; i++) {
			if (i!=arr[i]) {
				return i;
			}
		}
		
		return 0;
	}
}
