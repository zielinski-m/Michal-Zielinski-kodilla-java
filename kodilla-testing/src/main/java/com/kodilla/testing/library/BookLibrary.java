package com.kodilla.testing.library;

import java.util.ArrayList;
import java.util.List;

public class BookLibrary {
    LibraryDatabase libraryDatabase;

    public BookLibrary(LibraryDatabase libraryDatabase) {
        this.libraryDatabase = libraryDatabase;
    }

    public List<Book> listBooksWithCondition(String titleFragment) {
        List<Book> bookList = new ArrayList<>();
        if (titleFragment.length() < 3) return bookList;
        List<Book> resultList = libraryDatabase
                .listBooksWithCondition(titleFragment);
        if (resultList.size() > 20) return bookList;
        bookList = resultList;
        return bookList;
    }

    public List<Book> listBooksInHandsOf(LibraryUser libraryUser) {

        List<Book> listOfUserBooks;
        listOfUserBooks = libraryDatabase.listBooksInHandsOf(libraryUser);

        if(libraryDatabase.listBooksInHandsOf(libraryUser).isEmpty()) {
            System.out.println("Access granted. There are:  "  + listOfUserBooks.size() + " book/s left to return");
            return listOfUserBooks;
        } else {System.out.println("Sorry you've got " + listOfUserBooks.size() + " books not returned to the library. Your access is suspended");}
            return listOfUserBooks;
    }
}

