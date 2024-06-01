package com.BookList;

public class BookList {
    private Book[] bookList;

    private int existNum;

    public BookList() {
        this.bookList = new Book[15];
        bookList[0] = new Book("java", "J", 10, "计算机");
        bookList[1] = new Book("c++", "C", 12, "计算机");
        bookList[2] = new Book("Python", "P", 8, "计算机");
        this.existNum = 3;
    }

    public Book getBook(int index) {
        return bookList[index];
    }

    public void setBook(Book book, int index) {
        this.bookList[index] = book;
    }

    public int getExistNum() {
        return existNum;
    }

    public void setExistNum(int existNum) {
        this.existNum = existNum;
    }
}
