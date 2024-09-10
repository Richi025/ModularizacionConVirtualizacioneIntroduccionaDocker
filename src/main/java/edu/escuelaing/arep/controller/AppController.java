package edu.escuelaing.arep.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.arep.service.LoadBalancer;

@RestController
@RequestMapping("/app")
public class AppController {

    @Autowired
    private LoadBalancer loadBalancer;

    @PostMapping("/submit")
    public String submitMessage(@RequestParam("message") String message) {
        return loadBalancer.sendRequest(message);
    }
    
}
