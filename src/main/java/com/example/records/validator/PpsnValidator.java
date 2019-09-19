package com.example.records.validator;

import com.example.records.model.annotation.PpsnConstraint;
import com.example.records.repository.RecordRepository;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;

@Component
public class PpsnValidator implements ConstraintValidator<PpsnConstraint, String> {

  private RecordRepository recordRepository;

  @Autowired
  public PpsnValidator(RecordRepository recordRepository) {
    this.recordRepository = recordRepository;
  }

  @Override
  public void initialize(PpsnConstraint ppsn) {
  }

  @Override
  public boolean isValid(String ppsn, ConstraintValidatorContext context) {
    return !StringUtils.isEmpty(ppsn) && recordRepository.findAllByPpsn(ppsn).isEmpty();
  }

}
