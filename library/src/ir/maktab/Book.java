package ir.maktab;

import java.util.Arrays;

public class Book {
    private int bookId;
    private String name;


    public Book(int bookId, String name) {
        this.bookId = bookId;
        this.name = name;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        bookId++;
        this.bookId = bookId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    @Override
    public String toString() {
        return "Book[" +
                "bookId=" + bookId +
                ", name='" + name + '\'' +
                ']';
    }
}
