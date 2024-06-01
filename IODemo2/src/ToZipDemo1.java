import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ToZipDemo1 {
    public static void main(String[] args) throws IOException {
        File src = new File("E:\\java_code\\IODemo2\\aaa");//需要aaa 之后的路径
        File destParent = new File(src.getParent());
        File dest = new File(destParent, src.getName() + ".zip");
        ZipOutputStream zos = new ZipOutputStream(new FileOutputStream(dest));
        toZip(src, zos, src.getName());
        zos.close();
    }

    public static void toZip(File src, ZipOutputStream zos, String name) throws IOException {
        File[] files = src.listFiles();
        for (File file : files) {
            if (file.isFile()) {
                ZipEntry entry = new ZipEntry(name + "\\" + file.getName());//entry对象的路径针对压缩包而言
                zos.putNextEntry(entry);//zos流（通道）连接了entry

                FileInputStream fis = new FileInputStream(file);
                int b = 0;
                while ((b = fis.read()) != -1) {
                    zos.write(b);//zos连接zipEntry与程序数据传输通道，fis连接文件与程序的数据传输通道
                }

                fis.close();
                zos.closeEntry();
            } else {
                toZip(file, zos, name + "\\" + file.getName());
            }
        }
    }
}
