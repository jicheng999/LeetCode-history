package pers.liujicheng.leetcode.launch;


import pers.liujicheng.leetcode.easy.FlippingAnImage.FlippingAnImage;

public class Launch {
    public static void main(String[] args) {
        FlippingAnImage entry = new FlippingAnImage();
        int[][] arr = {{1, 1, 0}, {1, 0, 1}, {0, 0, 0}};
        int[][] result;
        long start = System.currentTimeMillis();
        result = entry.flipAndInvertImage(arr);
        System.out.println(System.currentTimeMillis() - start);

        for (int i = 0; i < result.length; i++) {
            System.out.println("");
            for (int j = 0; j < result[i].length; j++) {
                System.out.print(result[i][j]);
            }
        }
    }

}
