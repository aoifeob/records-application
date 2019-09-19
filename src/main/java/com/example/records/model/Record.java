package com.example.records.model;

import com.example.records.service.PersistenceService;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EntityListeners;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.Valid;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@EntityListeners(PersistenceService.class)
@Table(name="person")
@Valid
@Getter
public class Record implements Serializable {

  @Column(name="name", nullable = false)
  private String name;

  @Id
  @Column(name="ppsn",  nullable = false, unique = true)
  private String ppsn;

  @Column(name="date_of_birth", nullable = false)
  private String dateOfBirth;

  @Column(name="phone")
  @Setter
  private String phone;

  @Column (name = "create_date", nullable = false, updatable = false)
  @Setter
  private Date createDate;

}
