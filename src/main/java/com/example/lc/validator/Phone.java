package com.example.lc.validator;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Documented
@Retention(RUNTIME)
@Target(FIELD)
@Constraint(validatedBy = { PhoneValidator.class })
public @interface Phone {
	String message() default "Phone number must contain 10 digits";
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}
