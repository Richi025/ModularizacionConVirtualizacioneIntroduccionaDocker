package edu.escuelaing.arep.controller;


import edu.escuelaing.arep.service.LoadBalancer;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;


public class AppControllerTest {

    @InjectMocks
    private AppController appController;

    @Mock
    private LoadBalancer loadBalancer;

    public AppControllerTest() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testSubmitMessage() {
        String message = "test message";
        when(loadBalancer.sendRequest(message)).thenReturn("success");

        String result = appController.submitMessage(message);

        assertEquals("success", result);
        verify(loadBalancer, times(1)).sendRequest(message);
    }
}
