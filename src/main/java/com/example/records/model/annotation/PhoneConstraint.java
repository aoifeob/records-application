package com.example.records.model.annotation;

import com.example.records.validator.PhoneValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = PhoneValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface PhoneConstraint {

  String message() default "Phone must begin with \"08\"";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
