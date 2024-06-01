package com.user;

import com.BookList.Book;
import com.BookList.BookList;
import com.operation.*;

public class AdminUser extends User {
    public AdminUser(String name) {
        super(name);
        super.operations = new Operation[]{
                new ExitSystem(),
                new FindBook(),
                new AddBook(),
                new DelBook(),
                new ShowBook()
        };
    }

    @Override
    public void doOperation(BookList bookList, int choice) {
        this.operations[choice].work(bookList);
    }

    @Override
    public String toString() {
        return "1.查找图书\n" +
                "2.增加图书\n" +
                "3.删除图书\n" +
                "4.展示图书\n" +
                "0.退出系统";
    }
}
