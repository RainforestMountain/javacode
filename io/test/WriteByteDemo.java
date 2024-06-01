package com.io.test;

import java.io.*;

public class WriteByteDemo {
    public static void main(String[] args) {
        File outputFile = new File("output.txt");
        System.out.println(outputFile.exists());

        try (FileOutputStream out = new FileOutputStream(outputFile)) {
            for (int i = 0; i < 10; i++) {
                int x = (int) (Math.random() * 90) + 10;
                out.write(x);
            }
            out.flush();
            System.out.println("已经向文件写入10个两位数");
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }
        System.out.println();

        try (InputStream inputFile = new FileInputStream(outputFile);) {
            int c = inputFile.read();
            while (c != -1) {
                System.out.print(c + " ");
                c = inputFile.read();
            }
        } catch (IOException e) {
            e.printStackTrace(System.out);
        }


    }
}
