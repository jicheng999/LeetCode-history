package pers.liujicheng.leetcode.easy.longestpalindrome;

public class LongestPalindrome0 {
	public int longestPalindrome(String s) {
		int len = s.length();
		char[] arr = s.toCharArray();
		int[] countArr = new int[128];

		for (int i = 0; i < len; i++) {
			countArr[arr[i]]++;
		}

		int mulCount = 0;
		for (int i = 0; i < 128; i++) {
			int thisValue=countArr[i];
			if (0==thisValue%2) {
				mulCount += thisValue;
			}else{
				mulCount += thisValue-1;
			}
			
		}
		
		if (mulCount<len) {
			mulCount++;
		}

		return mulCount;
	}
}
