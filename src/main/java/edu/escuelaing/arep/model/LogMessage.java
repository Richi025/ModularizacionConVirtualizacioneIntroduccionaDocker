package edu.escuelaing.arep.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.Date;

@Document(collection = "logs")
public class LogMessage {
    @Id
    private String id;

    public LogMessage(String id, String message, Date date) {
        this.id = id;
        this.message = message;
        this.date = date;
    }
    public LogMessage() {
        //TODO Auto-generated constructor stub
    }
    private String message;
    private Date date;
    
    public void setId(String id) {
        this.id = id;
    }
    public void setMessage(String message) {
        this.message = message;
    }
    public void setDate(Date date) {
        this.date = date;
    }
    public String getId() {
        return id;
    }
    public String getMessage() {
        return message;
    }
    public Date getDate() {
        return date;
    }
}