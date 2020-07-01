package co.jp.beforward.ojt.controller.form;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import co.jp.beforward.ojt.controller.form.annotation.YmdFormatString;

@Component
public class EmpForm {
	/*
	 * ========================================================================== 
	 * 
	 * インスタンス変数
	 * 
	 * ==========================================================================
	 */
	/**
	 * 適用開始日
	 */
	@NotBlank
	@Size(max = 10)
	@YmdFormatString(patterns = {"uuuu/MM/dd"}, message = "aaaaaaaaaaa")
	private String appStaDate;
	
	/**
	 * 適用終了日
	 */
	@NotBlank
	@YmdFormatString(patterns = {"uuuu/MM/dd"})
	@Size(max = 10)
	private String appEndDate;
	
	/**
	 * 社員番号
	 */
	@NotBlank
	@Size(max = 5)
	private String empNum;
	
	/**
	 * 社員名
	 */
	@NotBlank
	@Size(max = 40)
	private String empNm;
	
	/**
	 * パスワード
	 */
	@NotBlank
	@Size(min = 8, max = 20)
	private String passWord;
	
	/**
	 * 社員区分
	 */
	@NotBlank
	@Size(max = 3)
	private String empDiv;

	/*
	 * ========================================================================== 
	 * 
	 * setter/getter
	 * 
	 * ==========================================================================
	 */
	
	/**
	 * appStaDateのgetter
	 * @return appStaDate
	 */
	public String getAppStaDate() {
		return appStaDate;
	}

	/**
	 * appStaDateのsetter
	 * @param appStaDate
	 */
	public void setAppStaDate(String appStaDate) {
		this.appStaDate = appStaDate;
	}

	/**
	 * appEndDateのgetter
	 * @return appEndDate
	 */
	public String getAppEndDate() {
		return appEndDate;
	}

	/**
	 * appEndDateのsetter
	 * @param appEndDate
	 */
	public void setAppEndDate(String appEndDate) {
		this.appEndDate = appEndDate;
	}

	/**
	 * empNumのgetter
	 * @return empNum
	 */
	public String getEmpNum() {
		return empNum;
	}

	/**
	 * empNumのsetter
	 * @param empNum
	 */
	public void setEmpNum(String empNum) {
		this.empNum = empNum;
	}

	/**
	 * empNmのgetter
	 * @return empNm
	 */
	public String getEmpNm() {
		return empNm;
	}

	/**
	 * empNmのsetter
	 * @param empNm
	 */
	public void setEmpNm(String empNm) {
		this.empNm = empNm;
	}

	/**
	 * passWordのgetter
	 * @return passWord
	 */
	public String getPassWord() {
		return passWord;
	}

	/**
	 * passWordのsetter
	 * @param passWord
	 */
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * empDivのgetter
	 * @return empDiv
	 */
	public String getEmpDiv() {
		return empDiv;
	}

	/**
	 * empDivのsetter
	 * @param empDiv
	 */
	public void setEmpDiv(String empDiv) {
		this.empDiv = empDiv;
	}
}
