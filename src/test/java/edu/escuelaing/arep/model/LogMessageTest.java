package edu.escuelaing.arep.model;



import org.junit.jupiter.api.Test;


import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

public class LogMessageTest {

    
    @Test
    public void testLogMessage() {
        LogMessage logMessage = new LogMessage();
        String id = "123";
        String message = "test log message";
        Date date = new Date();

        logMessage.setId(id);
        logMessage.setMessage(message);
        logMessage.setDate(date);

        assertEquals(id, logMessage.getId());
        assertEquals(message, logMessage.getMessage());
        assertEquals(date, logMessage.getDate());
    }
}
