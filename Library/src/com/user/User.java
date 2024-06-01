package com.user;

import com.BookList.Book;
import com.BookList.BookList;
import com.operation.Operation;

public abstract class User {
    private String name;

    protected Operation[] operations;

    public User(String name) {
        this.name = name;
    }

    public abstract void doOperation(BookList bookList, int choice);

    public boolean judeInput(int choice) {
        for (int i = 0; i < operations.length; i++) {
            if (choice == i) {
                return true;
            }
        }
        return false;
    }
}
