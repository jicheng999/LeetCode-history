package pers.liujicheng.leetcode.medium.repeateddnasequences;

import java.util.*;

/**
 * Created by JC on 2018/5/23.
 * <p>
 * All DNA is composed of a series of nucleotides abbreviated as A, C, G, and T, for example: "ACGAATTCCG". When studying DNA, it is sometimes useful to identify repeated sequences within the DNA.
 * <p>
 * Write a function to find all the 10-letter-long sequences (substrings) that occur more than once in a DNA molecule.
 * <p>
 * Example:
 * <p>
 * Input: s = "AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
 * <p>
 * Output: ["AAAAACCCCC", "CCCCCAAAAA"]
 */
public class RepeatedDNASequences {

    public List<String> findRepeatedDnaSequences(String s) {
        int size = s.length();
        List<String> list = new ArrayList<>();
        for (int j = 0; j <=size-10; j++) {
            String str = s.substring(j, j + 10);
            for (int i = j+1; i <=size - 10; i++) {
                String str2 = s.substring(i, i + 10);
                if (str.equals(str2)) {
                    if (!list.contains(str))list.add(str);
                }
            }
        }
        return list;
    }

    public List<String> findRepeatedDnaSequences2(String s) {
        int size = s.length();
        List<String> list = new ArrayList<>();
        Set<String> set=new HashSet<>();
        String thisStr=null;
        for (int i = 0; i <=size-10 ; i++) {
            thisStr=s.substring(i,i+10);
            if (set.contains(thisStr)&&!list.contains(thisStr)){
                list.add(thisStr);
            }else{
                set.add(thisStr);
            }
        }
        return list;
    }


    static String strrrr=null;
    static String strrrr1="";
    static String strrr2="";
    static String strrr3="";
    public static void main(String[] args) {
        //"AAAAACCCCCAAAAACCCCCCAAAAAGGGTTT"
        //["AAAAACCCCC","CCCCCAAAAA"]
        long start=System.currentTimeMillis();
        System.out.println("start......");
        List<String> list=new ArrayList<>();
        //strrrr=strrrr1+strrr2+strrr2;
        strrrr="AAAAAAAAAAA";
        RepeatedDNASequences obj=new RepeatedDNASequences();
        List<String> list1=obj.findRepeatedDnaSequences2(strrrr);
        list.addAll(list1);
        System.out.println("list size:"+list.size());
        System.out.println(System.currentTimeMillis()-start);

    }
}
