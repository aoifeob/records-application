package com.example.records.model;

import com.example.records.model.annotation.DateOfBirthConstraint;
import com.example.records.model.annotation.NameConstraint;
import com.example.records.model.annotation.PhoneConstraint;
import com.example.records.model.annotation.PpsnConstraint;
import java.io.Serializable;
import java.util.Date;
import javax.validation.Valid;
import javax.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Setter
@Valid
public class RecordDTO implements Serializable {

  @NameConstraint
  private String name;

  @PpsnConstraint
  private String ppsn;

  @DateOfBirthConstraint
  @DateTimeFormat(pattern = "yyyy-MM-dd")
  @Past(message = "Date of Birth must be in the past")
  private Date dateOfBirth;

  @PhoneConstraint
  private String phone;

}
