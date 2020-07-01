package co.jp.beforward.ojt.controller.form.annotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

import org.apache.commons.lang3.StringUtils;

import co.jp.beforward.ojt.controller.form.validator.YmdFormatStringValidator;


@Constraint(validatedBy = YmdFormatStringValidator.class)
@Target({ ElementType.FIELD })
@Retention(RetentionPolicy.RUNTIME)
public @interface YmdFormatString {

	String message() default StringUtils.EMPTY;
	
	Class<?>[] groups() default {};
	
	Class<? extends Payload>[] payload() default {};
	
	String[] patterns();
	
}
