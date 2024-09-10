package edu.escuelaing.arep.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import edu.escuelaing.arep.model.LogMessage;

import java.util.List;

public interface LogMessageRepository extends MongoRepository<LogMessage, String> {
    List<LogMessage> findTop10ByOrderByDateDesc();
}
