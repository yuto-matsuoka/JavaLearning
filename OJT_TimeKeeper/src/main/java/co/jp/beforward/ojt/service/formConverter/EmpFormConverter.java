
package co.jp.beforward.ojt.service.formConverter;

import org.apache.commons.lang3.StringUtils;

import co.jp.beforward.ojt.controller.form.EmpForm;
import co.jp.beforward.ojt.domain.MEmp;

public class EmpFormConverter {
	
	private static String separatedStr = "/";
	
	public static EmpForm entity2Form(MEmp mEmp) {
		EmpForm empForm = new EmpForm();
		if(mEmp == null) {
			return empForm;
		}
		
		String appStaDate = null;
		
		
		if(mEmp.getAppStaDate() != null) {
			appStaDate = mEmp.getAppStaDate().substring(0,4)
					.concat(separatedStr)
					.concat(mEmp.getAppStaDate().substring(4,6)
					.concat(separatedStr)
					.concat(mEmp.getAppStaDate().substring(6,8)));
		}
		
		empForm.setAppStaDate(appStaDate);
		
		String appEndDate = null;
		
		if(mEmp.getAppEndDate() != null) {
			appEndDate = mEmp.getAppEndDate().substring(0,4)
					.concat(separatedStr)
					.concat(mEmp.getAppEndDate().substring(4,6)
					.concat(separatedStr)
					.concat(mEmp.getAppEndDate().substring(6,8)));
		}
		
		empForm.setAppEndDate(appEndDate);
		
		empForm.setEmpNum(mEmp.getEmpNum());
		
		empForm.setEmpNm(mEmp.getEmpNm());
		
		empForm.setPassWord(mEmp.getPassWord());
		
		empForm.setEmpDiv(mEmp.getEmpDiv());
		
		return empForm;
	}
	
	public static MEmp form2Entity(EmpForm empForm) {
		MEmp mEmp = new MEmp();
		
		if(empForm == null) {
			return mEmp;
		}
		
		mEmp.setAppStaDate(StringUtils.replace(empForm.getAppStaDate(),separatedStr,""));
		
		mEmp.setAppEndDate(StringUtils.replace(empForm.getAppEndDate(),separatedStr,""));
		
		mEmp.setEmpNum(empForm.getEmpNum());
		
		mEmp.setEmpNm(empForm.getEmpNm());
		
		mEmp.setPassWord(empForm.getPassWord());
		
		mEmp.setEmpDiv(empForm.getEmpDiv());
		
		return mEmp;
		
	}
}
