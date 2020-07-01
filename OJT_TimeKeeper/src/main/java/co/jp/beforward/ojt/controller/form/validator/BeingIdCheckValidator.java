package co.jp.beforward.ojt.controller.form.validator;


import java.util.Objects;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import co.jp.beforward.ojt.controller.form.EmpForm;
import co.jp.beforward.ojt.domain.MEmp;
import co.jp.beforward.ojt.mapper.MEmpMapper;
import co.jp.beforward.ojt.service.formConverter.EmpFormConverter;

@Component
public class BeingIdCheckValidator implements Validator {
	
	@Autowired
	private MEmpMapper mEmpMapper;

    @Override
    public boolean supports(Class<?> clazz) {
        return EmpForm.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
    	EmpForm form = (EmpForm) target;
        String empNum = form.getEmpNum();
        String appStaDate = form.getAppStaDate();

        if (StringUtils.isEmpty(empNum) || StringUtils.isEmpty(appStaDate)) {
            // @NotEmptyで処理を実施
            return;
        }
        
        // 
        MEmp mEmp = EmpFormConverter.form2Entity(form);
        if (Objects.isNull((mEmpMapper.findOne(mEmp.getAppStaDate(), mEmp.getEmpNum())))) {
        	errors.rejectValue("empNum", "BeingIdCheckValidator.EmpForm.empNum", "error");
        }
    }
}
