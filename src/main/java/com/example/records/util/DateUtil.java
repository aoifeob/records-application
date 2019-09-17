package com.example.records.util;

import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateFormatterUtil {

  public String formatDate(Date date){
    return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate());
  }

}
