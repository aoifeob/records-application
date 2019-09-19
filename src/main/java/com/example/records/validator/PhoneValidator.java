package com.example.records.validator;

import com.example.records.model.annotation.PhoneConstraint;
import java.util.regex.Pattern;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PhoneValidator implements ConstraintValidator<PhoneConstraint, String> {

  private final Pattern phonePattern = Pattern.compile("^(\\s*|08[0-9]*)$");

  @Override
  public void initialize(PhoneConstraint phone) {
  }

  @Override
  public boolean isValid(String phone, ConstraintValidatorContext context) {
    return StringUtils.isEmpty(phone) || phonePattern.matcher(phone).matches();
  }

}
