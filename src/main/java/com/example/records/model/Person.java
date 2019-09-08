package com.example.records.model;

import com.example.records.service.PersistenceService;
import java.time.LocalDate;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import javax.validation.constraints.FutureOrPresent;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

@Builder
@NoArgsConstructor
@Entity
@EntityListeners(PersistenceService.class)
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
  @Getter
  private LocalDate dateOfBirth;

  @Column(name="phone")
  @Pattern(regexp = "^08[0-9]*$")
  private int phone;

  @Column (name = "create_date", nullable = false, updatable = false)
  @Setter
  private Date createDate;

}
