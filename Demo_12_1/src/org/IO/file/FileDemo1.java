package org.IO.file;

import java.io.File;

public class FileDemo1 {
    public static void main(String[] args) {
        File file = new File("E:\\java_code\\Demo_12_1\\.idea");
        if (file.isDirectory()) {
            String[] names = file.list();
            for (String name : names) {
                System.out.println(name);
            }
        }

        File[] files = file.listFiles();
        String[] list = file.list();
        Integer i = Integer.valueOf(18);



    }
}
