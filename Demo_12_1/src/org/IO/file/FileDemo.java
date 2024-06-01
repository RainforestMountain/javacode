package org.IO.file;

import sun.util.resources.LocaleData;

import javax.xml.crypto.Data;
import java.io.File;
import java.io.IOException;
import java.util.Date;

public class FileDemo {

    public static void main(String[] args) {
        File file = new File("E:\\java_code\\Demo_12_1\\bbb\\b.txt");
        System.out.println(file.exists());
        System.out.println(file.isFile());
        System.out.println(file.isDirectory());
        System.out.println(file.getAbsolutePath());
        System.out.println(file.getPath());
        System.out.println(file.getName());
        System.out.println(file.length() / 1024);
        //System.out.println(file.delete());
        System.out.println(file.getParent());
        System.out.println(file.canWrite());

        System.out.println("--------------------------");

        File file1 = new File("a.txt");
        System.out.println(file1.exists());
        if (!file1.exists()) {
            try {
                System.out.println(file1.createNewFile());
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }
        System.out.println(file1.exists());
        Date date = new Date();

        System.out.println(new Date(file1.lastModified()).toString());
        System.out.println(file1.getAbsolutePath());
        System.out.println(file1.getParent());
//        System.out.println(file1.delete());
//        System.out.println(file1.exists());
    }
}
