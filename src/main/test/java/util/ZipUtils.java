package util;

import java.io.*;
import java.util.Enumeration;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;
import java.util.zip.ZipOutputStream;

/**
 * Created by longjinwen on 07/08/2017.
 */
public class ZipUtils {
    public static void main(String[] args) throws IOException {
        String filePath = "D://EPPRDY1326022822230723-PTN0-8813022/EPPRDY1326022822230723-PTN0_8813022_PRHDIWH0F2002_PRHDIWH0F2_5_S.pdf";
        //String filePath = "D://a1/b2/m.txt";
  //      zip(filePath,"D://EPPRDY1326022822230723-PTN0-8813022.zip");
      //  compress(filePath);
       // zip(filePath);
        unzip();
    }
    /**
     * 扫描添加文件Entry
     *
     * @param base
     *            基路径
     *
     * @param source
     *            源文件
     * @param zos
     *            Zip文件输出流
     * @throws IOException
     */
    private static void addEntry(String base, File source, ZipOutputStream zos)
            throws IOException {
        // 按目录分级，形如：/aaa/bbb.txt
        String entry = base + source.getName();
        if (source.isDirectory()) {
            for (File file : source.listFiles()) {
                // 递归列出目录下的所有文件，添加文件Entry
                addEntry(entry + "/", file, zos);
            }
        } else {
            FileInputStream fis = null;
            BufferedInputStream bis = null;
            try {
                byte[] buffer = new byte[1024 * 10];
                fis = new FileInputStream(source);
                bis = new BufferedInputStream(fis, buffer.length);
                int read = 0;
                zos.putNextEntry(new ZipEntry(entry));
                while ((read = bis.read(buffer, 0, buffer.length)) != -1) {
                    zos.write(buffer, 0, read);
                }
                zos.closeEntry();
            } finally {
                IOUtil.closeQuietly(bis, fis);
            }
        }
    }
    /**
     * 压缩文件
     *
     * @param filePath
     *            待压缩的文件路径
     * @return 压缩后的文件
     */
    public static File zip(String filePath) {
        File target = null;
        File source = new File(filePath);
        if (source.exists()) {
            // 压缩文件名=源文件名.zip
           // String zipName = source.getName() + ".zip";
            String zipName = source.getParent()+".zip";
          //  zipFilePath = source.getPath()+".zip";
            //target = new File(source.getParent(), zipName);
            System.out.println(source.getParent());
            target = new File(zipName);
            if (target.exists()) {
                target.delete(); // 删除旧的文件
            }
            FileOutputStream fos = null;
            ZipOutputStream zos = null;
            try {
                fos = new FileOutputStream(target);
                zos = new ZipOutputStream(new BufferedOutputStream(fos));
                // 添加对应的文件Entry
                addEntry("", source, zos);
            } catch (IOException e) {
                throw new RuntimeException(e);
            } finally {
                IOUtil.closeQuietly(zos, fos);
            }
        }
        return target;
    }

    public static void unzip() throws IOException {
        String fileFullPath = "D://EPPRDY1326022822230723-PTN0-8813022.zip";
        ZipFile zipFile = new ZipFile(fileFullPath);
        ZipEntry entry = null;
        Enumeration entries  = zipFile.entries();
        while(entries.hasMoreElements()){
            entry = (ZipEntry) entries.nextElement();
            System.out.println(entry.getName());
        }
    }
}
