package com.elira.taskManager.validation;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = IsExistsDBValidation.class)
@Target(value = ElementType.FIELD)
@Retention(value = RetentionPolicy.RUNTIME)
public @interface IsExistsDB {
    String message() default "Already exist in the BD";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
