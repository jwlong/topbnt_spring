package iotest;

import org.junit.Test;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.RandomAccessFile;

/**
 * Created by longjinwen on 22/07/2017.
 */
public class TestInputStream {
     public static final String DIR_PATH = "F://springBootRes";
     public static final String  FILE_NAME = "testTxt";
     public static final String FILE_NAME_PATH = DIR_PATH+"/"+FILE_NAME ;
     //这样直接创建 文件没有写权限 ，使用RandomAccessFile
    @Test
    public  void test1() throws IOException {
        System.out.println("hello");
        File file = new File(DIR_PATH);

        if(file.isDirectory()){
                // 再创建一个txt文件 并往里面随便写几个字符
            String fileName = "testTxt"; //如果 这样就直接 写到class path下了，不太好
            String fileNamePath = DIR_PATH+"/"+fileName+".txt";
            File txtFile = new File(fileNamePath);
           // FileOutputStream outputStream = null;
            //IO   Notice: do not forget close the io stream
            if(!txtFile.exists()){
                //创建了txt 文件 成功
                if(txtFile.createNewFile()){
                    //再往里面去写内容
                    //FileOutputStream outputStream = new FileOutputStream(txtFile); 这个随系统权限
                    FileWriter fileWriter = new FileWriter(txtFile);
                    String needWriteStr = "testsetsetset";
                    String chineseStr = "添加中文试试";
                    String str = needWriteStr+chineseStr;
                    fileWriter.write(str); // FileWrite can write a streams of characters.
                }
            }{
                //已经存在的情况
                //追加内容
               // outputStream = new FileOutputStream(txtFile);
                //就是在定位到已经有文件内容的结尾再加
//                while(file.re)
//                outputStream.write();
                //替换内容

            }
        }else{
            file.mkdir();
        }
      //  FileInputStream fileInputStream = new FileInputStream()
    }
    @Test
    public void test2() throws IOException {
        //File file = new File(FILE_NAME_PATH);
        //创建一个 FileDescriptor 对象 连接到指定的文件的路径上。mode 参数 rw 可读可写
        RandomAccessFile rwFile = new RandomAccessFile(FILE_NAME_PATH,"rw");
        //FileWriter fileWriter = new FileWriter(rwFile);
        rwFile.writeBytes("sdfsdf");
        if(rwFile !=null ){
            rwFile.close();
        }
        // test2
    }

}
