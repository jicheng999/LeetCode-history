package pers.liujicheng.leetcode.launch;

import pers.liujicheng.leetcode.easy.hammingdistance.HammingDistance;
import pers.liujicheng.leetcode.easy.niqueorseodeWords.UniqueMorseCodeWords;

public class Launch {
    public static void main(String[] args) {
        HammingDistance entry = new HammingDistance();
        int x=73,y=93;
        int result=entry.hammingDistance(x,y);
        System.out.println("result:"+result);
    }

}
