package edu.escuelaing.arep.service;

import edu.escuelaing.arep.model.LogMessage;
import edu.escuelaing.arep.repository.LogMessageRepository;

import org.junit.jupiter.api.Test;

import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogMessageRepositoryTest {

    @Mock
    private LogMessageRepository logMessageRepository;

    public LogMessageRepositoryTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testFindTop10ByOrderByDateDesc() {
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage("Test log message");
        logMessage.setDate(new Date());

        List<LogMessage> mockLogs = Arrays.asList(logMessage);

        when(logMessageRepository.findTop10ByOrderByDateDesc()).thenReturn(mockLogs);

        List<LogMessage> result = logMessageRepository.findTop10ByOrderByDateDesc();

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals("Test log message", result.get(0).getMessage());
    }
}

