package com.kodilla.exception.io;

import com.kodilla.exception.test.ExceptionHandling;
import com.kodilla.exception.test.SecondChallenge;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class FileReaderTestSuite {

    @Test
    void testReadFile() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertDoesNotThrow(() -> fileReader.readFile());
    }

    @Test
    void whenFileDoesNotExistsReadFileShouldThrowException() {
        //giver
        FileReader fileReader = new FileReader();
        String fileName = "doc.txt does not exists";

        //when & then
        assertThrows(FileReaderException.class, () -> fileReader.readFile(fileName));
    }

    @Test
    void testReadFileWithName() {
        //given
        FileReader fileReader = new FileReader();

        //when & then
        assertAll(
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile("doc.txt does not exists")),
                () -> assertThrows(FileReaderException.class, () -> fileReader.readFile(null)),
                () -> assertDoesNotThrow(() -> fileReader.readFile("names.txt"))
        );
    }
}
