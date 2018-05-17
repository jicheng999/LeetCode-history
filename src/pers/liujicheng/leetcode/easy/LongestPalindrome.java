package pers.liujicheng.leetcode.easy;

import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

/**
Given a string which consists of lowercase or uppercase letters, find the length of the longest palindromes that can be built with those letters.

This is case sensitive, for example "Aa" is not considered a palindrome here.

Note:
Assume the length of given string will not exceed 1,010.

Example:

Input:
"abccccdd"

Output:
7

Explanation:
One longest palindrome that can be built is "dccaccd", whose length is 7.

 */
public class LongestPalindrome {
	public int longestPalindrome(String s) {
		Map<Character,Integer> map=new HashMap<>();
		int len=s.length();
		char[] arr=s.toCharArray();
		
		for (int i = 0; i < arr.length; i++) {
			if (map.containsKey(arr[i])) {
				Integer num=map.get(arr[i]);
				map.put(arr[i], ++num);
			}else{
				map.put(arr[i], 1);
			}
		}
		
		int mulCount=0;
		
		for (Entry<Character, Integer> entry : map.entrySet()) {
			int value=entry.getValue();
			if (0==value%2) {
				mulCount+=value;
			}else{
				mulCount+=value-1;
			}
		}
		
		if (mulCount<len) {
			mulCount++;
		}
		
			return mulCount;
	    }
	
	
}
