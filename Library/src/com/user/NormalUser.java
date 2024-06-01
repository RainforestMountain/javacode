package com.user;

import com.BookList.BookList;
import com.operation.*;

public class NormalUser extends User {

    public NormalUser(String name) {
        super(name);
        super.operations = new Operation[]{
                new ExitSystem(),
                new FindBook(),
                new BorrowBook(),
                new ReturnBook(),
                new ShowBook(),
        };
    }


    @Override
    public void doOperation(BookList bookList, int choice) {
        this.operations[choice].work(bookList);
    }

    @Override
    public String toString() {
        return "1.查找图书\n" +
                "2.借阅图书\n" +
                "3.归还图书\n" +
                "4.展示图书\n" +
                "0.退出系统";
    }
}
