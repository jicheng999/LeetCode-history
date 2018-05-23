package pers.liujicheng.leetcode.medium.longestsubstringwithoutrepeatingcharacters;

import java.io.File;

/**
 * Created by JC on 2018/5/21.
 *
 * Given a string, find the length of the longest substring without repeating characters.

 Examples:

 Given "abcabcbb", the answer is "abc", which the length is 3.

 Given "bbbbb", the answer is "b", with the length of 1.

 Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharaters {

    public int lengthOfLongestSubstring(String s) {
        if (null==s||"".equals(s)){
            return 0;
        }

        new File("","");

        char[] arr=s.toCharArray();
        boolean[] hasArr=new boolean[128];

        return 0;
    }

    public static void main(String[] args) {
        long a=1;
        a=a<<30;
        System.out.println(a);
    }

}
