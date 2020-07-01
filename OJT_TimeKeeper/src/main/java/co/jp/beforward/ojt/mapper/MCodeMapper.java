package co.jp.beforward.ojt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.cache.annotation.Cacheable;

import co.jp.beforward.ojt.domain.MCode;

@Mapper
public interface MCodeMapper {
	MCode findCodeName(String id, String code);
	
	List<MCode> findCodes(String id);
}
