package co.jp.beforward.ojt.common;

import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;

import co.jp.beforward.ojt.domain.MCode;
import co.jp.beforward.ojt.service.MCodeService;

@Component
public class CodeUtil {
	
	static MCodeService mCodeService;
	
	@Autowired
	private MCodeService wiredMCodeService;



	@PostConstruct
	private void start() {
		CodeUtil.mCodeService = wiredMCodeService;
	}

	
	public static MCode findCodeName(String id, String code) {
		return mCodeService.findCodeName(id, code);
	}
	
	
	public static List<MCode> findCodes(String id) {
		List<MCode> codes =  mCodeService.findCodes(id);
		return codes;
	}
}
