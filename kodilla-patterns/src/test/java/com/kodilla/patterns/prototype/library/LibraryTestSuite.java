package com.kodilla.patterns.prototype.library;

import org.junit.jupiter.api.Test;
import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotSame;

public class LibraryTestSuite {

    @Test
    public void testGetBooks() {
        // Given
        Library library = new Library("Library");
        library.loadData();

        // When
        Library shallowCloneLibrary = null;
        Library deepCloneLibrary = null;

                /* Deep Clone Method */
        try {
            deepCloneLibrary = library.deepClone();
            deepCloneLibrary.books.add(new Book("TestBook", "TestAuthor", LocalDate.now()));
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // Then
        System.out.println("\n" + "Deep Clone Method" + "\n" + library.books);
        System.out.println(deepCloneLibrary.getBooks());
        assertEquals(4, deepCloneLibrary.getBooks().size());
        assertNotSame(library.getBooks(), deepCloneLibrary.getBooks());

                /* Shallow Clone Method */
        // When
        try {
            shallowCloneLibrary = library.shallowClone();
            shallowCloneLibrary.getBooks().add(new Book("TestBook1", "TestAuthor1", LocalDate.now()));
        } catch (CloneNotSupportedException e) {
            System.out.println(e);
        }

        // Then
        System.out.println("\n" + "Shallow Clone Method" + "\n" + library.books);
        System.out.println(shallowCloneLibrary.books);
        assertEquals(4, shallowCloneLibrary.getBooks().size());
        assertEquals(library.getBooks().size(), shallowCloneLibrary.getBooks().size());

    }
}