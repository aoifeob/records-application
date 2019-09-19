package com.example.records.validator;

import com.example.records.model.annotation.NameConstraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class NameValidator implements ConstraintValidator<NameConstraint, String> {

  public static final Integer MAX_NAME_LENGTH = 25;

  @Override
  public void initialize(NameConstraint name) {
  }

  @Override
  public boolean isValid(String name, ConstraintValidatorContext context) {
    return !StringUtils.isEmpty(name) && name.length() <= MAX_NAME_LENGTH;
  }

}
