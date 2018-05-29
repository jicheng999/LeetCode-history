package pers.liujicheng.leetcode.utils;

import java.io.*;

/**
 * Created by JC on 2018/5/27.
 */
public class FileUtils {

    public static String getFileContentAsString(String path){
        String content=null;
        System.out.println("read file : "+path+"......start");
        File file=new File(path);
        if (!file.exists()){
            System.out.println("file is not exists!");
            return null;
        }
        FileInputStream fileInput=null;
        try {
            fileInput=new FileInputStream(file);
            byte[] buff=new byte[fileInput.available()];
            fileInput.read(buff);
            content=new String(buff);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileInput != null) {
                try {
                    fileInput.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("close inputstream error!");
                }
            }
        }
        return content;
    }


    public static void addStringToFile(String content,String path){
        System.out.println("read file : "+path+"......start");
        File file=new File(path);
        if (!file.exists()){
            System.out.println("file is not exists!");
            return;
        }
        FileOutputStream fileOut=null;
        try {
            fileOut=new FileOutputStream(file,true);
            fileOut.write(content.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (fileOut != null) {
                try {
                    fileOut.close();
                } catch (IOException e) {
                    e.printStackTrace();
                    System.out.println("close inputstream error!");
                }
            }
        }
    }

    public static void reCreateFile(String path){
        File file=new File(path);
        if (file != null&&file.exists()) {
            try {
                file.delete();

            } catch (Exception e) {
                e.printStackTrace();
                System.out.println("delete file error");
                return ;
            }
        }

        try {
            file.createNewFile();
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("create file error");
        }

    }

    public static void main(String[] args) {
// String path="E://MyFiles//test.txt";
// FileUtils.addStringToFile("5555555555",path);
// System.out.println(FileUtils.getFileContentAsString(path));

        String str="aaadddfffd";
        System.out.println(str.hashCode());
    }
}
