package com.example.records.model.annotation;

import com.example.records.validator.NameValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = NameValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface NameConstraint {

  String message() default "Name must be between 0 and 25 characters";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
