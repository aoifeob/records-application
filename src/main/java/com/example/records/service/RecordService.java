package com.example.records.service;

import com.example.records.factory.RecordFactory;
import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import com.example.records.repository.RecordRepository;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RecordService {

  private RecordRepository recordRepository;
  private RecordFactory recordFactory;

  @Autowired
  public RecordService(RecordRepository recordRepository,
      RecordFactory recordFactory) {
    this.recordRepository = recordRepository;
    this.recordFactory = recordFactory;
  }

  public void addRecord(RecordDTO recordDTO) {
    recordRepository.save(recordFactory.transformRecordDTO(recordDTO));
  }

  public List<Record> listRecords() {
    return recordRepository.findAll().stream().sorted(Comparator.comparing(Record::getCreateDate))
        .collect(
            Collectors.toList());
  }

}
