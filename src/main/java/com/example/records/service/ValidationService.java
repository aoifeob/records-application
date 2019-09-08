package com.example.records.service;

import com.example.records.model.Person;
import java.time.LocalDate;
import java.time.Period;
import org.springframework.stereotype.Service;

@Service
public class ValidationService {

  public static final Integer MINIMUM_AGE = 17;


  boolean isValid(Person person){
    return isValidDateOfBirth(person.getDateOfBirth());
  }

  private boolean isValidDateOfBirth(LocalDate dateOfBirth){
    return Period.between(dateOfBirth, LocalDate.now()).getYears() >= MINIMUM_AGE;
  }

}
