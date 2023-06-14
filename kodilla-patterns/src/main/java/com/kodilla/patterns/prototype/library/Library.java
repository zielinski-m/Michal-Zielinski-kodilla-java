package com.kodilla.patterns.prototype.library;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public final class Library extends Prototype<Library> {

    String name;
    Set<Book> books = new HashSet<>();

    public Library(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void loadData() {
        books.add(new Book("Book 1", "Author 1", LocalDate.now()));
        books.add(new Book("Book 2", "Author 2", LocalDate.now()));
        books.add(new Book("Book 3", "Author 3", LocalDate.now()));
    }

    public Library shallowClone() throws CloneNotSupportedException {
        return super.clone();
    }

    public Library deepClone() throws CloneNotSupportedException {
        Library clonedLibrary = super.clone();
        clonedLibrary.books = new HashSet<>();
        for (Book theBook : books) {
            Book clonedBooks = new Book(theBook.title, theBook.author, theBook.publicationDate);
            clonedLibrary.books.add(clonedBooks);
        }
        return clonedLibrary;
    }

    public Set<Book> getBooks() {
        return books;
    }
}