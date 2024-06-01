package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

import java.util.Scanner;

public class ReturnBook implements Operation {

    @Override
    public void work(BookList bookList) {
        System.out.println("归还图书");
        Scanner scanner = new Scanner(System.in);
        System.out.println("输入归还图书书名：");
        String name = scanner.nextLine();
        int index = FindBook.search(bookList, name);
        if (index == -1) {
            System.out.println("归还失败,不是图书馆的图书");
        } else if (index != 1 && !bookList.getBook(index).isBorrowed()) {
            System.out.println("归还图书未被借阅,归还错误");
        } else {
            bookList.getBook(index).setBorrowed(false);
            System.out.println("归还成功");
        }
    }
}
