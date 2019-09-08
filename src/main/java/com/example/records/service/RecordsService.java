package com.example.records.service;

import com.example.records.model.Person;
import com.example.records.repository.PersonRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class RecordsService {

  private ValidationService validationService;
  private PersonRepository personRepository;

  @Autowired
  public RecordsService(ValidationService validationService, PersonRepository personRepository){
    this.validationService = validationService;
    this.personRepository = personRepository;
  }

  public void addRecord(Person person){
    if (validationService.isValid(person)){
      personRepository.save(person);
    }
  }

  public ResponseEntity listRecords(){
    List<Person> recordsList = personRepository.findAll();
    if (!recordsList.isEmpty()) {
      return ResponseEntity.ok().body(recordsList);
    }
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body("No records have been created");
  }

}
