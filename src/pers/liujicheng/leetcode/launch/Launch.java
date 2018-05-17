package pers.liujicheng.leetcode.launch;

import pers.liujicheng.leetcode.easy.missingnumber.MissingNumber;

public class Launch {
	public static void main(String[] args) {
		MissingNumber entry=new MissingNumber();
		int[] arr={3,0,1};
		int result=0;
		long start=System.currentTimeMillis();
		result=entry.missingNumber(arr);
		System.out.println(System.currentTimeMillis()-start);
		System.out.println(entry.missingNumber(arr)); 
	}
}
