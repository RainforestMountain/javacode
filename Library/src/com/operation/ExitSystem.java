package com.operation;

import com.BookList.Book;
import com.BookList.BookList;

public class ExitSystem implements Operation{
    @Override
    public void work(BookList bookList) {
        System.out.println("退出系统");
        System.exit(0);
    }
}
