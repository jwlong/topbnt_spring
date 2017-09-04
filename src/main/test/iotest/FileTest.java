package com.dxfjyygy.test.iotest;

import org.junit.Test;

import java.io.*;

/**
 * Created by longjinwen on 2017/3/22.
 * 关于文件的读取之类的
 */
public class FileTest {
    @Test
    public void test1() throws IOException {
        File  dir = new File("abc");
        //System.out.println(dir.getCanonicalPath()); /// 获得当前路径
        if(!dir.isDirectory()){
            dir.mkdir();
        }
        if(dir.isDirectory()){
            System.out.println("true");
        }
    }
    @Test
    public void test2() throws IOException {
        File file = new File("D:\\test\\test2.txt");
        FileInputStream fis = null;
        if(!file.exists()){
            file.createNewFile();
        }
        if(file.length() == 0){
            System.out.println("文件内容为空");
        }else {
            System.out.println("文件长度："+file.length());
        }
        fis = new FileInputStream(file);
        byte[] b = new byte[1024];
        while(fis.read(b) != -1){ //读到结尾
            //Byte.toString(b)
            System.out.println(new String(b));
        }
        // write data to file
        FileOutputStream fos = new FileOutputStream(file);
        String abc = "string test";
        String str_zh = "我是你大爷";
        // b为1024个字节，全部写进了，但是很多是空白的
        fos.write(abc.getBytes());
        fos.write(str_zh.getBytes("UTF-8"));
        fos.close();
        fis.close();

    }
    //test 追加文件
    @Test
    public void testAppendFile1(){
        BufferedOutputStream bos  ;
    }
    public void writeFileContent(){
    }
}

