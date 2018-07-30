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
 * 员工业务
 * @author Administrator
 *
 */
@Service
@Transactional(rollbackFor=Exception.class)
public class EmpService {
	
	@Autowired
	private EmpMapper dao;
	
	/**
	 * 登陆验证
	 * @param empLoginName 用户名
	 * @param empPwd 密码
	 * @return 登陆验证结果：1 用户名不存在   2 密码错误  3 登陆成功
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
	 * 检查登陆名是否存在 
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
	 * 增加新员工
	 * @param emp
	 * @throws SQLException 
	 */
	public void addEmp(Emp emp){
		dao.insert(emp);
	}
	
	/**
	 * 通过id查询单个员工数据
	 * @param empId
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public Emp queryEmpById(Integer empId) {
		
		return dao.queryById(empId);
	}
	
	/**
	 * 返回员工总记录数
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public int getEmpCount() {
		
		return dao.getCount();
	}
	
	/**
	 * 分页查询员工数据
	 * @param pager
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public List<Emp> queryEmpByPage(Pager pager) {
		
		return dao.queryByPage(pager);
	}

	/**
	 * 修改员工
	 * @param emp
	 * @throws SQLException 
	 */
	public void updateEmp(Emp emp) {
		
		dao.update(emp);
	}
	
	/**
	 * 删除员工
	 * @param empId
	 * @throws SQLException
	 */
	public void deleteEmp(Integer empId)  {
		
		dao.delete(empId);
	}
	
	/**
	 * 查询返回员工头像数据
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public String queryEmpPic(String empLoginName){
		
		return dao.queryEmpPic(empLoginName);
	}
	
	/**
	 * 更新员工头像
	 * @param empLoginName
	 * @param empPic
	 * @throws SQLException
	 */
	public void updateEmpPic(String empLoginName,String empPic){
		
		dao.updateEmpPic(empLoginName, empPic);
	}
	
	/**
	 * 修改员工密码
	 * @param empLoginName
	 * @param empPwd
	 * @throws SQLException
	 */
	public void updateEmpPwd(String empLoginName,String empPwd) {
		
		dao.updateEmpPwd(empLoginName, empPwd);
	}
	
	/**
	 * 查询当前密码
	 * @param empLoginName
	 * @return
	 * @throws SQLException
	 */
	@Transactional(readOnly=true)
	public String queryEmpPwd(String empLoginName) {
		
		return dao.queryByName(empLoginName).getEmpPwd();
	}
	
}