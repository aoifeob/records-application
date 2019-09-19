package com.example.records.validator;

import com.example.records.model.annotation.DateOfBirthConstraint;
import com.example.records.util.DateUtil;
import java.time.LocalDate;
import java.time.Period;
import java.util.Date;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class DateOfBirthValidator implements ConstraintValidator<DateOfBirthConstraint, Date> {

  public static final Integer MINIMUM_AGE = 16;

  private DateUtil dateUtil;

  @Autowired
  public DateOfBirthValidator(DateUtil dateUtil) {
    this.dateUtil = dateUtil;
  }

  @Override
  public void initialize(DateOfBirthConstraint date) {
  }

  @Override
  public boolean isValid(Date dateOfBirth, ConstraintValidatorContext context) {
    return dateOfBirth != null
        && Period.between(dateUtil.convertToLocalDate(dateOfBirth), LocalDate.now()).getYears()
        >= MINIMUM_AGE;
  }

}
