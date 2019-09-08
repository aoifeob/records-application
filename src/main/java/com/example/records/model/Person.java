package com.example.records.model;

import java.time.LocalDate;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import org.springframework.format.annotation.DateTimeFormat;

@Getter
@Builder
@Entity
@Table(name="person")
@Valid
public class Person {

  @Column(name="name", nullable = false)
  @Size(max = 25)
  private String name;

  @Id
  @Column(name="ppsn",  nullable = false, unique = true)
  private String ppsn;

  @Column(name="date_of_birth", nullable = false)
  @FutureOrPresent
  @DateTimeFormat(pattern = "dd/MM/yyyy")
  private LocalDate dateOfBirth;

  @Column(name="phone")
  @Pattern(regexp = "^08[0-9]*$")
  private int phone;

}
