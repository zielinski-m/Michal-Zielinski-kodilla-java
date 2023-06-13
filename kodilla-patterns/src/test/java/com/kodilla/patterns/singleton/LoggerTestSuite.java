package com.kodilla.patterns.singleton;

import org.apache.commons.logging.Log;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

public class LoggerTestSuite {

    @Test
    public void testGetLastLog() {

        // Given
        Logger logger = Logger.INSTANCE;
        String loggerMessage = "Test log message";

        // When
        logger.log(loggerMessage);
        String lastLog = logger.getLastLog();

        // Then
        Assertions.assertEquals(loggerMessage, lastLog);
    }
}