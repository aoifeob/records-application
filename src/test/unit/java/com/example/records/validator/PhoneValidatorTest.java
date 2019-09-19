package com.example.records.validator;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

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
public class PhoneValidatorTest {

  @Autowired
  private PhoneValidator phoneValidator;

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
    assertTrue(phoneValidator.isValid("081234567", context));
  }

  @Test
  public void isInvalidPhoneDoesntStartWith08() {
    assertFalse(phoneValidator.isValid("0123456789", context));
  }
}
