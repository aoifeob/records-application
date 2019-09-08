package com.example.records.model;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CustomError implements Comparable<CustomError>{

  private String field;
  private String message;

  @Override
  public int compareTo(CustomError other) {
    return this.field.compareTo(other.field);
  }

}
