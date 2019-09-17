package com.example.records.factory;

import com.example.records.model.Record;
import com.example.records.model.RecordDTO;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import org.springframework.util.StringUtils;

public class TransformRecordDTO {

  public Record transformRecordDTO(RecordDTO recordDTO){
    String dateOfBirth = DateTimeFormatter
        .ofPattern("dd/MM/yyyy").format(recordDTO.getDateOfBirth().toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
    Record record = Record.builder().name(recordDTO.getName()).ppsn(recordDTO.getPpsn())
        .dateOfBirth(dateOfBirth).build();
    if (!StringUtils.isEmpty(recordDTO.getPhone())) {
      record.setPhone(recordDTO.getPhone());
    }
  }

}
