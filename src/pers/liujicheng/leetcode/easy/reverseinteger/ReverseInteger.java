package pers.liujicheng.leetcode.easy.reverseinteger;

/**
 * @ProjectName: LeetCode-history
 * @Package: pers.liujicheng.leetcode.easy.reverseinteger
 * @ClassName: ReverseInteger
 * @Description: java类作用描述
 * @Author: ljc
 * @CreateDate: 2018/5/22 13:53
 * @UpdateUser: 更新者
 * @UpdateDate: 2018/5/22 13:53
 * @UpdateRemark: 更新说明
 * @Version: 1.0
 *
 * Given a 32-bit signed integer, reverse digits of an integer.

Example 1:

Input: 123
Output: 321
Example 2:

Input: -123
Output: -321
Example 3:

Input: 120
Output: 21
Note:
Assume we are dealing with an environment which could only store integers within the 32-bit signed integer range: [−231,  231 − 1]. For the purpose of this problem, assume that your function returns 0 when the reversed integer overflows.
 */
public class ReverseInteger {

    public int reverse(int x) {
        int result=0;
        boolean isFu=false;
        if (x<0){
            x*=-1;
            isFu=true;
        }

        while (0!=x){
            int yu=x%10;

            if (result>Integer.MAX_VALUE/10){
                return 0;
            }
            result*=10;
            int newresult=result +yu;
            if (newresult<result){
                return 0;
            }
            result=newresult;
            x-=yu;
            x/=10;
        }
        if (isFu){
            result*=-1;
        }
        return result;
    }

    public static void main(String[] args) {
        ReverseInteger rrrr=new ReverseInteger();
        System.out.println(rrrr.reverse(123));
    }

}
