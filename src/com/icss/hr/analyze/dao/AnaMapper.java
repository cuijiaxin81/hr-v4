package com.icss.hr.analyze.dao;

import java.util.List;
import java.util.Map;

import com.icss.hr.analyze.dto.DeptEmpCount;
import com.icss.hr.analyze.dto.DeptSal;

public interface AnaMapper {
	
	/**
	 * ��������ͳ��
	 * @return
	 */
	List<DeptEmpCount> queryEmpCount();
	
	/**
	 * ְ���ƽ������
	 */
	List<Map<String, Object>> queryJobAvgSal();
	
	/**
	 * ��ѯÿ�����ŵ������͹���
	 */
	List<DeptSal> queryDeptSal();
}
