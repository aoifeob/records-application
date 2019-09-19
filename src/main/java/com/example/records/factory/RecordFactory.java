package com.example.records.factory;

import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import com.example.records.util.DateUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class RecordFactory {

  private DateUtil dateUtil;

  @Autowired
  public RecordFactory(DateUtil dateUtil) {
    this.dateUtil = dateUtil;
  }

  public Record transformRecordDTO(RecordDTO recordDTO) {
    Record record = Record.builder().name(recordDTO.getName()).ppsn(recordDTO.getPpsn())
        .dateOfBirth(dateUtil.formatDate(recordDTO.getDateOfBirth())).build();
    if (!StringUtils.isEmpty(recordDTO.getPhone())) {
      record.setPhone(recordDTO.getPhone());
    }
    return record;
  }

}
