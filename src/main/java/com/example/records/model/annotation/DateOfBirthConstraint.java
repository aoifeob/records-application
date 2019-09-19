package com.example.records.model.annotation;

import com.example.records.validator.DateOfBirthValidator;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Constraint(validatedBy = DateOfBirthValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface DateOfBirthConstraint {

  String message() default "You must be over 16 years old";

  Class<?>[] groups() default {};

  Class<? extends Payload>[] payload() default {};
}
