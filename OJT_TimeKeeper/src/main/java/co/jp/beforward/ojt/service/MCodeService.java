package co.jp.beforward.ojt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.beforward.ojt.domain.MCode;
import co.jp.beforward.ojt.mapper.MCodeMapper;

@Service
public class MCodeService {

	@Autowired
	private MCodeMapper mCodeMapper;
	
	@Transactional
	@Cacheable("findCodeName")
	public MCode findCodeName(String id, String code) {
		return mCodeMapper.findCodeName(id, code);
	}
	
	@Transactional
	@Cacheable("findCodes")
	public List<MCode> findCodes(String id) {
		
		List<MCode> codes =  mCodeMapper.findCodes(id);
		return codes;
	}
	
}
