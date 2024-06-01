package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

import java.util.Scanner;

public class DelBook implements Operation {

    @Override
    public void work(BookList bookList) {
        System.out.println("删除书籍");
        System.out.println("输入需要删除的书名");
        String name = new Scanner(System.in).nextLine();
        int index = FindBook.search(bookList, name);
        if (index == -1) {
            System.out.println("没有删除的图书,删除失败");
        } else {
            for (int i = index; i < bookList.getExistNum() - 1; i++) {
                bookList.setBook(bookList.getBook(i + 1), i);
            }
            bookList.setBook(null, bookList.getExistNum() - 1);
            System.gc();
            bookList.setExistNum(bookList.getExistNum() - 1);
            System.out.println("删除成功");
        }
    }
}
