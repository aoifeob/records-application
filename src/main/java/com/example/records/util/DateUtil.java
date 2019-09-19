package com.example.records.util;

import java.time.LocalDate;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;
import java.util.Date;
import org.springframework.stereotype.Component;

@Component
public class DateUtil {

  public String formatDate(Date date){
    return DateTimeFormatter.ofPattern("dd/MM/yyyy").format(convertToLocalDate(date));
  }

  public LocalDate convertToLocalDate(Date date) {
    return date.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
  }

}
