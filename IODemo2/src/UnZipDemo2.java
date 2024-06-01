import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipInputStream;

public class UnZipDemo2 {
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\java_code\\IODemo2\\aab.zip");
        File dest = new File("E:\\java_code\\IODemo2\\");

        unZip(src, dest);
    }

    public static void unZip(File src, File dest) throws IOException {
        ZipInputStream zis = new ZipInputStream(new FileInputStream(src));
        ZipEntry entry = null;

        //从压缩包把zipEntry读取出来,然后zis流连接这个zipEntry对象
        while ((entry = zis.getNextEntry()) != null) {
            System.out.println(entry.toString());
            if (entry.isDirectory()) {
                File file = new File(dest, entry.toString());
                file.mkdirs();//创建文件夹/目录
            } else {
                //是文件，就把zipEntry数据拷贝到目标文件
                //防止当entry是文件时，父级路径还没创建，就创建文件，产生异常
                File file1 = new File(entry.toString());
                File file2 = new File(dest, file1.getParent());
                file2.mkdirs();
                FileOutputStream fos = new FileOutputStream(new File(dest, entry.toString()));
                int b;
                while ((b = zis.read()) != -1) {
                    fos.write(b);
                }
                fos.close();
                zis.closeEntry();//关闭与这个zipEntry对象的连接
            }
        }
        zis.close();
    }
}
