package edu.escuelaing.arep.controller;


import edu.escuelaing.arep.model.LogMessage;
import edu.escuelaing.arep.repository.LogMessageRepository;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import java.util.Arrays;
import java.util.Date;
import java.util.List;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

public class LogServiceTest {

    @InjectMocks
    private LogService logService;

    @Mock
    private LogMessageRepository repository;

    public LogServiceTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testLogMessage() {
        String message = "log message test";
        LogMessage logMessage = new LogMessage();
        logMessage.setMessage(message);
        logMessage.setDate(new Date());

        List<LogMessage> mockLogs = Arrays.asList(logMessage);

        when(repository.findTop10ByOrderByDateDesc()).thenReturn(mockLogs);

        List<LogMessage> result = logService.logMessage(message);

        assertNotNull(result);
        assertEquals(1, result.size());
        assertEquals(message, result.get(0).getMessage());

        verify(repository, times(1)).save(any(LogMessage.class));
        verify(repository, times(1)).findTop10ByOrderByDateDesc();
    }
}
