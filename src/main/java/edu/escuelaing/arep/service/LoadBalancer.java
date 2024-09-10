package edu.escuelaing.arep.service;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class LoadBalancer {
    private int currentIndex = 0;
    private final String[] logServiceUrls = {
        "http://logservice1:6000/logservice/log",
        "http://logservice2:6000/logservice/log",
        "http://logservice3:6000/logservice/log"
    };

    public String sendRequest(String message) {
        RestTemplate restTemplate = new RestTemplate();
        String url = logServiceUrls[currentIndex];
        currentIndex = (currentIndex + 1) % logServiceUrls.length; // Round Robin

        return restTemplate.postForObject(url + "?message=" + message, null, String.class);
    }
}