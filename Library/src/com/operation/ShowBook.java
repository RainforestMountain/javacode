package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

public class ShowBook implements Operation{

    @Override
    public void work(BookList bookList) {
        System.out.println("展示所有图书");
        for (int i = 0; i < bookList.getExistNum(); i++) {
            System.out.println(bookList.getBook(i));
        }
        System.out.println("展示完成");
    }
}
