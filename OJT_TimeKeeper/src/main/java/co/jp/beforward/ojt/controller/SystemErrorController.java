package co.jp.beforward.ojt.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 
 * @author shuhei sakaguchi
 *
 */
@Controller
@RequestMapping("/error") // エラーページへのマッピング
public class SystemErrorController implements ErrorController {

	@Override
	public String getErrorPath() {
		return "/error";
	}
	
	@RequestMapping
	public ModelAndView error(HttpServletRequest req, ModelAndView mav) {
		mav.setStatus(HttpStatus.NOT_FOUND);
		mav.setViewName("error");
	    return mav;
	  }
	
}
