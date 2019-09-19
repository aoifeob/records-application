package com.example.records.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import com.example.records.model.Record;
import com.example.records.repository.RecordRepository;
import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@ActiveProfiles("test")
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
public class PpsnValidatorTest {

  @Autowired
  private PpsnValidator ppsnValidator;
  @Autowired
  private RecordRepository recordRepository;

  private ConstraintValidatorContext context = new ConstraintValidatorContext() {
    @Override
    public void disableDefaultConstraintViolation() {

    }

    @Override
    public String getDefaultConstraintMessageTemplate() {
      return null;
    }

    @Override
    public ClockProvider getClockProvider() {
      return null;
    }

    @Override
    public ConstraintViolationBuilder buildConstraintViolationWithTemplate(String messageTemplate) {
      return null;
    }

    @Override
    public <T> T unwrap(Class<T> type) {
      return null;
    }
  };

  @Test
  public void isValid() {
    assertTrue(ppsnValidator.isValid("123456789T", context));
  }

  @Test
  public void isInvalidWhenPpsnDuplicate() {
    Record record = Record.builder().name("Bob Test").ppsn("123456789T").dateOfBirth("01/01/1990")
        .build();
    recordRepository.save(record);
    assertFalse(ppsnValidator.isValid("123456789T", context));
  }

  @Test
  public void isInvalidWhenPpsnNull() {
    assertFalse(ppsnValidator.isValid("", context));
  }
}
