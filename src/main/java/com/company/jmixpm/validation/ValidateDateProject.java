package com.company.jmixpm.validation;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Target(ElementType.TYPE)
@Retention(RUNTIME)
@Documented
@Constraint( validatedBy = ValidateDateProjectValidator.class)
public @interface ValidateDateProject {
    String message() default "Start date can not be later enddate";

    Class<?>[] groups() default { };

    Class<? extends Payload>[] payload() default { };
}
