package co.jp.beforward.ojt.controller.employee;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import co.jp.beforward.ojt.common.CodeConst;
import co.jp.beforward.ojt.common.CodeUtil;
import co.jp.beforward.ojt.controller.form.EmpForm;
import co.jp.beforward.ojt.controller.form.validator.BeingIdCheckValidator;
import co.jp.beforward.ojt.controller.form.validator.DateCheckValidator;
import co.jp.beforward.ojt.domain.MCode;
import co.jp.beforward.ojt.domain.MEmp;
import co.jp.beforward.ojt.service.MEmpService;
import co.jp.beforward.ojt.service.formConverter.EmpFormConverter;

/**
 * 社員マスタ変更画面Controller
 * @author shuhei sakaguchi
 *
 */
@Controller
public class EmpEditorController {
	
	/**
	 * 社員マスタService
	 */
	@Autowired
	private MEmpService mEmpService;
	
	/**
	 * 日付妥当性バリデーション
	 */
	@Autowired
	DateCheckValidator dateCheckValidator;
	
	/**
	 * 社員IDバリデーション
	 */
	@Autowired
	BeingIdCheckValidator beingIdCheckValidator;
	
	@InitBinder
    public void initBinder(WebDataBinder binder) {
        binder.addValidators(dateCheckValidator);
        binder.addValidators(beingIdCheckValidator);
    }
	
	/**
	 * 社員情報_変更ボタン押下イベント
	 * 
	 * @param mEmp
	 * 		リクエストパラメータ
	 * @param result
	 *		バインド結果
	 * @param model
	 * 		データ受け渡し用モデル
	 * @return　遷移先画面
	 */
	@PostMapping(value = "/employees", params = "empEdit")
	public String edit(@ModelAttribute("empForm") @Validated EmpForm empForm, BindingResult result, Model model) {
		//バインド結果
		if (result.hasErrors()) {
			//エラーが存在する場合
			//再度、更新画面を表示
			
			model.addAttribute("empForm", empForm);
			
			//セレクトボックスのアイテムを作成
			Map<String, String> empDivItems = new LinkedHashMap<String, String>();
			
			List<MCode> empDivCodes = CodeUtil.findCodes(CodeConst.EMP_DIV);
			for(MCode mCode: empDivCodes) {
				empDivItems.put(mCode.getCode(), mCode.getCodeName());
			}
			
			model.addAttribute("empDivItems", empDivItems);
			
			return "empEditor";
		} else {
			//エラーが存在しない場合
			//更新処理を実施して、一覧へ遷移
			
			mEmpService.update(EmpFormConverter.form2Entity(empForm));
			return "redirect:/employees";
		}
	}
}
