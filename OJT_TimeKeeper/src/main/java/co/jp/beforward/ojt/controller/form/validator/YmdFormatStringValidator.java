package co.jp.beforward.ojt.controller.form.validator;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.commons.lang3.StringUtils;

import co.jp.beforward.ojt.common.DateTimeUtil;
import co.jp.beforward.ojt.controller.form.annotation.YmdFormatString;

public class YmdFormatStringValidator implements ConstraintValidator<YmdFormatString, String> {
	private String[] patterns;
	
	@Override
	public void initialize(final YmdFormatString constraintAnnotaion) {
		patterns = constraintAnnotaion.patterns();
	}
	
	@Override
	public boolean isValid(final String value, final ConstraintValidatorContext context) {
		return StringUtils.isEmpty(value) || DateTimeUtil.isParsable(value, patterns);
		
	}
}
