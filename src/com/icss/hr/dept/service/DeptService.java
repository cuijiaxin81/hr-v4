package com.icss.hr.dept.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.dept.dao.DeptMapper;
import com.icss.hr.dept.pojo.Dept;

/**
 * ����ҵ��
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class DeptService {
	
	@Autowired
	private DeptMapper dao;
	
	/**
	 * ���Ӳ���
	 * @throws SQLException 
	 */
	public void addDept(Dept dept) {		
		dao.insert(dept);
	}
	
	/**
	 * �޸Ĳ���
	 * @param dept
	 * @throws SQLException
	 */
	public void updateDept(Dept dept) {
		dao.update(dept);
	}
	
	/**
	 * ɾ������
	 * @param deptId
	 * @throws SQLException
	 */
	public void deleteDept(Integer deptId) {
		dao.delete(deptId);
	}
	
	/**
	 * ���ص�����������
	 * @param deptId
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Dept queryDeptById(Integer deptId) {
		
		return dao.queryById(deptId);
	}
	
	/**
	 * ���ز�����������
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public List<Dept> queryDept() {
		
		return dao.query();
	}

}