package pers.liujicheng.leetcode.launch;

import pers.liujicheng.leetcode.easy.niqueorseodeWords.UniqueMorseCodeWords;

public class Launch {
    public static void main(String[] args) {
        UniqueMorseCodeWords entry = new UniqueMorseCodeWords();
        String[] arr = {"gin", "zen", "gig", "msg"};
        long start = System.currentTimeMillis();
        int result=entry.uniqueMorseRepresentations(arr);
        System.out.println(System.currentTimeMillis() - start);
        System.out.println("result:"+result);
    }

}
