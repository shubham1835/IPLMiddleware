package com.ipl.middleware.validation;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.regex.Pattern;


public class DbLookupValidateTypeFieldsValidator implements ConstraintValidator<DbLookupValidateTypeFields, Object> {

    private String regexpVarName;

    @Override
    public void initialize(DbLookupValidateTypeFields constraintAnnotation) {
        this.regexpVarName = constraintAnnotation.regexp();
    }

    @Override
    public boolean isValid(Object o, ConstraintValidatorContext constraintValidatorContext) {
        return Pattern.matches(this.regexpVarName, String.valueOf(o));
    }
}
