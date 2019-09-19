package com.example.records.service;

import com.example.records.model.Record;
import java.sql.Timestamp;
import java.time.Instant;
import javax.persistence.PrePersist;
import org.springframework.stereotype.Service;

@Service
public class PersistenceService {

  @PrePersist
  void preCreate(Record record) {
    Timestamp now = Timestamp.from(Instant.now());
    record.setCreateDate(now);
  }

}
