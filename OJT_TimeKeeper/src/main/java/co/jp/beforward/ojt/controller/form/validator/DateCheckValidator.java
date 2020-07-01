package co.jp.beforward.ojt.controller.form.validator;


import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.jp.beforward.ojt.common.DateTimeUtil;
import co.jp.beforward.ojt.controller.form.EmpForm;
import co.jp.beforward.ojt.domain.MEmp;


@Component
public class DateCheckValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return EmpForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        EmpForm form = (EmpForm) target;
        String appStaDate = form.getAppStaDate();
        String appEndDate = form.getAppEndDate();

        if (!DateTimeUtil.isParsable(appStaDate, "uuuu/MM/dd") || !DateTimeUtil.isParsable(appEndDate, "uuuu/MM/dd")) {
            return;
        }
        if (DateTimeUtil.anyParse(appStaDate, "uuuu/MM/dd").compareTo(DateTimeUtil.anyParse(appEndDate, "uuuu/MM/dd")) > 0) {
            errors.rejectValue("appEndDate", "DateCheckValidator.EmpForm.appEndDate", "error");
        }
    }
}
