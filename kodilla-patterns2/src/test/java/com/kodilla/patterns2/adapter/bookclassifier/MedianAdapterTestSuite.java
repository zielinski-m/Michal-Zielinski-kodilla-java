package com.kodilla.patterns2.adapter.bookclassifier;


import com.kodilla.patterns2.adapter.bookclassifier.librarya.Book;
import org.junit.jupiter.api.Test;

import java.util.Set;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class MedianAdapterTestSuite {

    @Test
    public void publicationYearMedianTest() {
        //given
        Set<Book> bookSet = Set.of(
                new Book("Author1", "Title1", 2000, "Signature1"),
                new Book("Author2", "Title2", 2001, "Signature2"),
                new Book("Author3", "Title3", 2002, "Signature3"),
                new Book("Author4", "Title4", 2005, "Signature4")
        );

        //when
        MedianAdapter medianAdapter = new MedianAdapter();
        int medianPublicationYear = medianAdapter.publicationYearMedian(bookSet);

        //then
        assertEquals(2002, medianPublicationYear);
    }
}
