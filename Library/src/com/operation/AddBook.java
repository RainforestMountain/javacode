package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

import java.util.Scanner;

public class AddBook implements Operation {

    @Override
    public void work(BookList bookList) {
        System.out.println("增加图书");
        System.out.println("输入图书信息：");
        Scanner scanner = new Scanner(System.in);
        System.out.println("书名：");
        String name = scanner.nextLine();
        System.out.println("作者：");
        String author = scanner.nextLine();
        System.out.println("价格：");
        int price = scanner.nextInt();
        System.out.println("图书类型：");
        scanner.nextLine();
        String type = scanner.nextLine();
        bookList.setBook(new Book(name, author, price, type), bookList.getExistNum());
        bookList.setExistNum(bookList.getExistNum() + 1);
        System.out.println("增加成功");
    }
}
