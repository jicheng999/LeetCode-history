package pers.liujicheng.leetcode.medium.longestsubstringwithoutrepeatingcharacters;

import pers.liujicheng.leetcode.utils.FileUtils;

import java.util.*;

/**
 * Created by JC on 2018/5/21.
 * <p>
 * Given a string, find the length of the longest substring without repeating characters.
 * <p>
 * Examples:
 * <p>
 * Given "abcabcbb", the answer is "abc", which the length is 3.
 * <p>
 * Given "bbbbb", the answer is "b", with the length of 1.
 * <p>
 * Given "pwwkew", the answer is "wke", with the length of 3. Note that the answer must be a substring, "pwke" is a subsequence and not a substring.
 */
public class LongestSubstringWithoutRepeatingCharaters {
    public int maxCount=0;
    public int maxDeep=0;
    public int lengthOfLongestSubstring(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        if (1 == s.length()) {
            return 1;
        }

        int maxLength = 1;
        int maxLen = (s.length() > 128 ? 128 : s.length());
        System.out.println(maxLen);
        for (int i = maxLen; i > 0; i--) {
            for (int i1 = 0; i1 <= s.length() - i; i1++) {
                if (maxLength < i && !hasRepeatCharaters(s.substring(i1, i1 + i))) {
                    maxLength = i;
                }
            }
        }
        return maxLength;
    }

    public int lengthOfLongestSubstring2(String s) {
        if (null == s || "".equals(s)) {
            return 0;
        }

        if (1 == s.length()) {
            return 1;
        }

        int maxLength = s.length();

        //获得各个字符重复数的统计
        byte chIndex = getSubChIndex(s);
        if (-1 != chIndex) {
            maxLength = getMaxLen(s, chIndex);
        }

        System.out.println("maxDeep:"+maxDeep);
        System.out.println("maxCount:"+maxCount);
        return maxLength;
    }

    public int getMaxLen(String s, byte chIndex) {
        String[] arr = getArrByCh(s, chIndex);
        int maxLen = 0;
        for (int i = 0; i < arr.length; i++) {
            String thisStr = arr[i];
            byte chIndex2 = getSubChIndex(thisStr);
            if (-1 != chIndex2) {
                int maxL = getMaxLen(thisStr, chIndex2);
                if (maxL > maxLen) {
                    maxLen = maxL;
                }
            } else if (maxLen < thisStr.length()) {
                maxLen = thisStr.length();
            }
        }

        return maxLen;
    }

    public String[] getArrByCh(String s, byte chIndex) {
        char ch = (char) chIndex;
        int lastIndex = -1;
        int startIndex=0;
        char[][] charArr = new char[2000][];
        int subCount = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == ch) {
                if (i != startIndex&&lastIndex!=-1) {
                    char[] ch1 = new char[i - startIndex];
                    for (int j = startIndex, chIdx=0; j < i; j++,chIdx++) {
                        ch1[chIdx] = s.charAt(j);
                    }
                    charArr[subCount] = ch1;
                    startIndex=lastIndex+1;
                    subCount++;
                }
                lastIndex = i;
            }
        }

        if (s.length()>lastIndex) {
            char[] ch1 = new char[s.length() - startIndex];
            for (int j = startIndex, chIdx=0; j < s.length(); j++,chIdx++) {
                ch1[chIdx] = s.charAt(j);
            }
            charArr[subCount] = ch1;
            subCount++;
        }

        String[] arr = new String[subCount];
        for (int i = 0; i < subCount; i++) {
            arr[i] = new String(charArr[i]);
        }

        if (subCount> maxCount) {
            maxCount=subCount;
        }

        return arr;
    }

    public byte getSubChIndex(String s) {
        int[] chMulCountArr = new int[128];
        for (int i = 0; i < s.length(); i++) {
            byte chIndex = (byte) s.charAt(i);
            if (chMulCountArr[chIndex] > 0) {
                return chIndex;
            }
            chMulCountArr[chIndex]++;
        }
        return -1;
    }


    public boolean hasRepeatCharaters(String s) {
        byte[] buffs = new byte[128];
        for (int i = 0; i < s.length(); i++) {
            int charIndex = s.charAt(i);
            if (0 == buffs[charIndex]) {
                buffs[charIndex] = 1;
            } else {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        LongestSubstringWithoutRepeatingCharaters obj = new LongestSubstringWithoutRepeatingCharaters();
        String content= FileUtils.readFileAsString("E:/testcontent.txt");
        //String content = "aab";
        long start = System.currentTimeMillis();
        int maxLength = obj.lengthOfLongestSubstring2(content);
        System.out.println(maxLength);
        long end = System.currentTimeMillis() - start;
        System.out.println("spend time:" + end);

    }

}
