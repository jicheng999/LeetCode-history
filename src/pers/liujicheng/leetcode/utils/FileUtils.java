package pers.liujicheng.leetcode.utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

/**
 * Created by JC on 2018/5/27.
 */
public class FileUtils {

    public static  String readFileAsString(String path){
        File file=new File(path);
        if (!file.exists()) {
            System.out.println("file not exits!");
            return "";
        }
        String content="";
        FileInputStream fin=null;
        try {
            fin = new FileInputStream(file);
            byte[] buff = new byte[fin.available()];
            fin.read(buff);
            content = new String(buff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null!=fin) {
                try {
                    fin.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }

        return content;
    }
}
