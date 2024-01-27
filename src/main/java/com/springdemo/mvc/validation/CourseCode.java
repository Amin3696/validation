package com.springdemo.mvc.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = CourseCodeConstrainValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
public @interface CourseCode {

    // define default course code
    public String value() default "LUV";

    //define default error message
    public String message() default "must start with LUV";

    //define default group
    public Class<?>[] groups() default {};

    //define default payload
    public Class<? extends Payload>[] payload() default {};
}
