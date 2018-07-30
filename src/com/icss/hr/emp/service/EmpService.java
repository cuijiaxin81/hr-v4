package com.icss.hr.emp.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.dao.EmpMapper;
import com.icss.hr.emp.pojo.Emp;

/**
 * Ա��ҵ��
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmpService {
	
	@Autowired
	private EmpMapper dao;
	
	/**
	 * ��½��֤
	 * @param empLoginName �û���
	 * @param empPwd ����
	 * @return ��½��֤�����1 �û���������   2 �������  3 ��½�ɹ�
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public int checkLogin(String empLoginName,String empPwd) throws SQLException{
		
		Emp emp = dao.queryByName(empLoginName);
		
		if (emp == null) {
			return 1;
		} else if ( !empPwd.equals(emp.getEmpPwd()) ) {
			return 2;
		}
				
		return 3;
	}
	
	/**
	 * ����½���Ƿ���� 
	 * @param empLoginName
	 * @return
	 * @throws SQLException 
	 */
	@Transactional(readOnly=true)
	public boolean checkLoginName(String empLoginName) {
		
		Emp emp = dao.queryByName(empLoginName);
		
		if (emp == null)
			return false;
		
		return true;
	}
	
	/**
	 * ������Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp){
		dao.insert(emp);
	}
	
	/**
	 * ͨ��id��ѯ����Ա������
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpById(Integer empId) {
		
		return dao.queryById(empId);
	}
	
	/**
	 * ����Ա���ܼ�¼��
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public int getEmpCount() {
		
		return dao.getCount();
	}
	
	/**
	 * ��ҳ��ѯԱ������
	 * @param pager
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public List<Emp> queryEmpByPage(Pager pager) {
		
		return dao.queryByPage(pager);
	}

	/**
	 * �޸�Ա��
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) {
		
		dao.update(emp);
	}
	
	/**
	 * ɾ��Ա��
	 * @param empId
	 * @throws SQLException
	 */
	public void deleteEmp(Integer empId)  {
		
		dao.delete(empId);
	}
	
	/**
	 * ��ѯ����Ա��ͷ������
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public String queryEmpPic(String empLoginName){
		
		return dao.queryEmpPic(empLoginName);
	}
	
	/**
	 * ����Ա��ͷ��
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException
	 */
	public void updateEmpPic(String empLoginName,String empPic){
		
		dao.updateEmpPic(empLoginName, empPic);
	}
	
	/**
	 * �޸�Ա������
	 * @param empLoginName
	 * @param empPwd
	 * @throws SQLException
	 */
	public void updateEmpPwd(String empLoginName,String empPwd) {
		
		dao.updateEmpPwd(empLoginName, empPwd);
	}
	
	/**
	 * ��ѯ��ǰ����
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public String queryEmpPwd(String empLoginName) {
		
		return dao.queryByName(empLoginName).getEmpPwd();
	}
	
}