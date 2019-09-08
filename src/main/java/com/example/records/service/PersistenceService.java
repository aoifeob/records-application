package com.example.records.service;

import com.example.records.model.Person;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.PrePersist;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService {

  @PrePersist
  void preCreate (Person person) {
    Timestamp now = Timestamp.from(Instant.now());
    person.setCreateDate(now);
  }

}
