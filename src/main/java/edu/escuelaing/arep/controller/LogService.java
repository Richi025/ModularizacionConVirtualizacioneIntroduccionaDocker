package edu.escuelaing.arep.controller;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import edu.escuelaing.arep.model.LogMessage;
import edu.escuelaing.arep.repository.LogMessageRepository;

import java.util.Date;
import java.util.List;

@RestController
@RequestMapping("/logservice")
public class LogService {

    @Autowired
    private LogMessageRepository repository;

    @PostMapping("/log")
    public List<LogMessage> logMessage(@RequestParam("message") String message) {
        LogMessage log = new LogMessage();
        log.setMessage(message);
        log.setDate(new Date());
        repository.save(log);
    
        return repository.findTop10ByOrderByDateDesc();
    }
}
