package com.IO;

import java.io.*;

public class ReaderDemo {
//    public static void main(String[] args) throws IOException {
//        FileReader fr = new FileReader("E:\\java_code\\Demo_12_7\\a.txt");
//        int b;
//        while ((b = fr.read()) != -1) {
//            System.out.print((char) b);
//        }
//        System.out.println();
//        fr.close();
//    }

//    public static void main(String[] args) throws UnsupportedEncodingException {
//        String str1 = "ai你哟";
//        byte[] bytes1 = str1.getBytes();
//        byte[] bytes2 = str1.getBytes("GBK");
//        System.out.println(Arrays.toString(bytes1));
//        System.out.println(Arrays.toString(bytes2));
//
//        String str3 = new String(bytes1, StandardCharsets.UTF_8);
//        String str4 = new String(bytes1,"GBK");
//        String str5 = new String(bytes2,"GBK");
//        String str6 = new String(bytes2, StandardCharsets.UTF_8);
//        System.out.println(str3);
//        System.out.println(str4);
//        System.out.println(str5);
//        System.out.println(str6);
//    }

//    public static void main(String[] args) throws IOException {
////        FileReader reader = new FileReader("E:\\java_code\\Demo_12_7\\a.txt");
////
//////        char[] buff = new char[1024];
//////        reader.read(buff);
//////        System.out.println(new String(buff));
//////        reader.close();
////
////        int b = 0;
////        while ((b = reader.read()) != -1) {
////            System.out.print((char) b);
////        }
////
////        reader.close();
//
////        FileWriter writer = new FileWriter("E:\\java_code\\Demo_12_7\\a.txt",false);
////
////        String message = "hello,world";
////        writer.write(message);
////
////        writer.flush();
////
////        message = "\nhello,java";
////        writer.write(message);
////
////        writer.close();
//    }

    public static void main(String[] args) throws IOException {
        BufferedInputStream bis = new BufferedInputStream(new FileInputStream("E:\\java_code\\Demo_12_7\\a.txt"));
        BufferedOutputStream bos = new BufferedOutputStream(new FileOutputStream("E:\\java_code\\Demo_12_7\\b.txt"));
        byte[] bytes = new byte[1024];
        int len = 0;
        while ((len = bis.read(bytes)) != -1) {
            bos.write(bytes, 0, len);
        }
        bis.close();
        bos.close();
    }
}
