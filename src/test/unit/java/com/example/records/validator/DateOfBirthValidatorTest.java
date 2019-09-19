package com.example.records.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Arrays;
import java.util.Date;
import java.util.stream.Stream;
import javax.validation.ClockProvider;
import javax.validation.ConstraintValidatorContext;
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
public class DateOfBirthValidatorTest {

  @Autowired
  private DateOfBirthValidator dateOfBirthValidator;

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

  private static Stream<Object> flatten(Object[] array) {
    return Arrays.stream(array)
        .flatMap(o -> o instanceof Object[] ? flatten((Object[]) o) : Stream.of(o));
  }

  @Test
  public void isValid() throws Exception {
    Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/1999");
    assertTrue(dateOfBirthValidator.isValid(dateOfBirth, context));
  }

  @Test
  public void isInvalidForNullDateOfBirth() {
    assertFalse(dateOfBirthValidator.isValid(null, context));
  }

  @Test
  public void isInvalidForFutureDateOfBirth() throws Exception {
    Date dateOfBirth = new SimpleDateFormat("dd/MM/yyyy").parse("01/01/2999");
    assertFalse(dateOfBirthValidator.isValid(dateOfBirth, context));
  }

  @Test
  public void isInvalidForDateOfBirthUnder16() throws Exception {
    Date dateOfBirth = new SimpleDateFormat("yyyy-MM-dd").parse(LocalDate.now().toString());
    assertFalse(dateOfBirthValidator.isValid(dateOfBirth, context));
  }

}
