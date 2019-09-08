package com.example.records.service;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.records.model.Person;
import java.time.LocalDate;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
public class ValidationServiceTest {

  @Autowired
  private ValidationService validationService;

  @Test
  public void isValidDateOfBirth() {
    Person person = Person.builder()
        .name("Harry Samples")
        .ppsn("1234ABCD")
        .dateOfBirth(LocalDate.of(1990, 1, 1))
        .build();
    assertTrue(validationService.isValid(person));
  }

  @Test
  public void isInvalidDateOfBirth() {
    Person person = Person.builder()
        .name("Harry Samples")
        .ppsn("1234ABCD")
        .dateOfBirth(LocalDate.of(LocalDate.now().getYear()-16, 1, 1))
        .build();
    assertFalse(validationService.isValid(person));
  }

}
