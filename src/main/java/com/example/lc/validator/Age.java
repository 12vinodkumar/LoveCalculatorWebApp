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
@Constraint(validatedBy = AgeValidator.class)
public @interface Age {
	
	int lower() default 18;
	int upper() default 80;
	String message() default "the age should between {lower} - {upper}";
	
	Class<?>[] groups() default { };

	Class<? extends Payload>[] payload() default { };

}

