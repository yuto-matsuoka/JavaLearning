package co.jp.beforward.ojt.controller.employee;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import co.jp.beforward.ojt.common.CodeConst;
import co.jp.beforward.ojt.common.CodeUtil;
import co.jp.beforward.ojt.common.DateTimeUtil;
import co.jp.beforward.ojt.controller.form.EmpForm;
import co.jp.beforward.ojt.domain.MCode;
import co.jp.beforward.ojt.domain.MEmp;
import co.jp.beforward.ojt.service.MEmpService;
import co.jp.beforward.ojt.service.formConverter.EmpFormConverter;

/**
 * 社員一覧画面Controller
 * @author shuhei sakaguchi
 *
 */
@Controller
public class EmpListViewerController {

	/**
	 * 社員マスタService
	 */
	@Autowired
	private MEmpService mEmpService;

	/**
	 * 一覧画面へ遷移
	 * @param model
	 * 		データ受け渡し用モデル
	 * @return 遷移先画面
	 */
	@GetMapping("/employees")
	public String empListViewer(Model model) {
		List<MEmp> employees = mEmpService.findAll();
		
		List<EmpForm> empForms = new ArrayList<>();
		
		for(MEmp mEmp: employees) {
			empForms.add(EmpFormConverter.entity2Form(mEmp));
		}
		
		model.addAttribute("empForms", empForms);
		
		return "empListViewer";
	}

	
	/**
	 * 削除ボタン押下
	 * @param mEmp
	 * 		社員マスタEntity
	 * @return　遷移先画面
	 */
	@PostMapping(value = "/employees/edit", params = "empDelete")
	public String delete(@ModelAttribute("empForm") EmpForm empForm) {
		
		MEmp mEmp = EmpFormConverter.form2Entity(empForm);
		
		mEmpService.delete(mEmp);
		
		return "redirect:/employees"; 
	}
	
	/**
	 * 詳細画面遷移
	 * @param appStaDate
	 * 		適用開始日
	 * @param empNum
	 * 		社員番号
	 * @param model
	 * 		データ受け渡し用モデル
	 * @return　遷移先画面
	 */
	@PostMapping(value = "/employees/edit", params = "empDetail")
	public String empDetail(@ModelAttribute("empForm") EmpForm empForm, Model model) {
		
		MEmp mEmp = EmpFormConverter.form2Entity(empForm);
		
		empForm = EmpFormConverter.entity2Form(mEmpService.findOne(mEmp.getAppStaDate(), mEmp.getEmpNum()));
		
		model.addAttribute("empForm", empForm);
		
		//セレクトボックスのアイテムを作成
		Map<String, String> empDivItems = new LinkedHashMap<String, String>();
		
		List<MCode> empDivCodes = CodeUtil.findCodes(CodeConst.EMP_DIV);
		for(MCode mCode: empDivCodes) {
			empDivItems.put(mCode.getCode(), mCode.getCodeName());
		}
		
		model.addAttribute("empDivItems", empDivItems);
		
		return "empDetail";
	}
	
	/**
	 * 変更画面遷移
	 * @param appStaDate
	 * 		適用開始日
	 * @param empNum
	 * 		社員番号
	 * @param model
	 * 		データ受け渡し用モデル
	 * @return　遷移先画面
	 */
	@PostMapping(value = "/employees/edit", params = "empEdit")
	public String empEditor(@ModelAttribute("empForm") EmpForm empForm, Model model) {
		
		MEmp mEmp = EmpFormConverter.form2Entity(empForm);
		
		empForm = EmpFormConverter.entity2Form(mEmpService.findOne(mEmp.getAppStaDate(), mEmp.getEmpNum()));
		
		model.addAttribute("empForm", empForm);
		
		//セレクトボックスのアイテムを作成
		Map<String, String> empDivItems = new LinkedHashMap<String, String>();
		
		List<MCode> empDivCodes = CodeUtil.findCodes(CodeConst.EMP_DIV);
		for(MCode mCode: empDivCodes) {
			empDivItems.put(mCode.getCode(), mCode.getCodeName());
		}
		
		model.addAttribute("empDivItems", empDivItems);
		
		return "empEditor";
	}
	
	/**
	 * 新規画面遷移
	 * @param mEmp
	 * 		社員マスタEntity
	 * @param model
	 * 		データ受け渡し用モデル
	 * @return 遷移先画面
	 */
	@GetMapping("/employees/register")
	public String empRegister(@ModelAttribute("empForm") EmpForm empForm, Model model) {
		
		//セレクトボックスのアイテムを作成
		Map<String, String> empDivItems = new LinkedHashMap<String, String>();
		
		List<MCode> empDivCodes = CodeUtil.findCodes(CodeConst.EMP_DIV);
		for(MCode mCode: empDivCodes) {
			empDivItems.put(mCode.getCode(), mCode.getCodeName());
		}
		
		model.addAttribute("empDivItems", empDivItems);
		
		empForm.setAppStaDate(DateTimeUtil.getYmdSlashString());
		empForm.setAppEndDate(LocalDateTime.of(9999, 12, 31, 0, 0).format(DateTimeUtil.FORMATTER_YMD_SLASH));
		
		return "empRegister";
	}
	
}