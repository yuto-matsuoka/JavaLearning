package co.jp.beforward.ojt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import co.jp.beforward.ojt.domain.MEmp;
import co.jp.beforward.ojt.mapper.MEmpMapper;

/**
 * 社員マスタService
 * @author shuhei sakaguchi
 *
 */
@Service
public class MEmpService {

/**
 * 社員マスタMapper
 */
@Autowired
private MEmpMapper mEmpMapper;
	
	/**
	 * 全件検索
	 * @return　社員マスタEntityList
	 */
	@Transactional
	public List<MEmp> findAll() {
		return mEmpMapper.findAll();
	}

	/**
	 * 検索(PK)
	 * @param appStaDate
	 * @param empNum
	 * @return
	 */
	@Transactional
	public MEmp findOne(String appStaDate, String empNum) {
		return mEmpMapper.findOne(appStaDate, empNum);
	}

	/**
	 * 検索
	 * @param mEmp
	 * 		社員マスタEntity
	 * @return
	 */
	@Transactional
	public MEmp findOne(MEmp mEmp) {
		return mEmpMapper.findOne(mEmp.getAppStaDate(), mEmp.getEmpNum());
	}

	/**
	 * 削除
	 * @param mEmp
	 * 		社員マスタEntity
	 */
	@Transactional
	public void delete(MEmp mEmp) {
		mEmpMapper.delete(mEmp.getAppStaDate(), mEmp.getEmpNum());
	}

	/**
	 * 更新
	 * @param mEmp
	 * 		社員マスタEntity
	 */
	@Transactional
	public void update(MEmp mEmp) {
		mEmpMapper.update(mEmp);
	}

	/**
	 * 登録
	 * @param mEmp
	 * 		社員マスタEntity
	 */
	@Transactional
	public void insert(MEmp mEmp) {
		mEmpMapper.insert(mEmp);
	}

}