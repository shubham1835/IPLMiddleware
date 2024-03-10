package com.ipl.middleware.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = DbLookupValidateTypeFieldsValidator.class)
public @interface DbLookupValidateTypeFields {

    String regexp();

    String message() default "Invalid field type or values";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default{};
}