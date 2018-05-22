package pers.liujicheng.leetcode.easy.hammingdistance;

/**
 * Created by JC on 2018/5/19.
 *
 *
 *
 * The Hamming distance between two integers is the number of positions at which the corresponding bits are different.

 Given two integers x and y, calculate the Hamming distance.

 Note:
 0 ≤ x, y < 231.

 Example:

 Input: x = 1, y = 4

 Output: 2

 Explanation:
 1   (0 0 0 1)
 4   (0 1 0 0)
 ↑   ↑

 The above arrows point to positions where the corresponding bits are different.

 */
public class HammingDistance {
    public int hammingDistance(int x, int y) {
        if (x>y){
            return check(x,y);
        }else{
            return check(y,x);
        }
    }

    public int check(int big,int small){
        int dis=big^small;
        int temp=dis;
        int hammin=0;

        while(dis!=0){
            dis=dis>>1;
            if (dis != (double)temp/2) {
                hammin++;
            }
            temp=dis;
        }
        return hammin;
    }
}
