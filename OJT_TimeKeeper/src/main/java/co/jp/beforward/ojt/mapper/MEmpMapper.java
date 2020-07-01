package co.jp.beforward.ojt.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import co.jp.beforward.ojt.domain.MEmp;

/**
 * 社員マスタMapper
 * @author shuhei sakaguchi
 *
 */
@Mapper
public interface MEmpMapper {
	
	/**
	 * 全件検索
	 * @return　社員マスタEntityList
	 */
	List<MEmp> findAll();

	/**
	 * 検索
	 * @param appStaDate
	 * 		適用開始日
	 * @param empNum
	 * 		社員番号
	 * @return 社員マスタEntity
	 */
	MEmp findOne(String appStaDate, String empNum);

	/**
	 * 削除
	 * @param appStaDate
	 * 		適用開始日
	 * @param empNum
	 * 		社員番号
	 */
	void delete(String appStaDate, String empNum);

	/**
	 * 更新
	 * @param mEmp
	 * 		社員マスタEntity
	 */
	void update(MEmp mEmp);

	/**
	 * 登録
	 * @param mEmp
	 * 		社員マスタEntity
	 */
	void insert(MEmp mEmp);
}
