package com.icss.hr.emp.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.icss.hr.common.Pager;
import com.icss.hr.emp.pojo.Emp;

/**
 * 员工Dao接口
 * @author Administrator
 *
 */
public interface EmpMapper {
	
	void insert(Emp emp);
	
	void update(Emp emp);
	
	void delete(Integer empId);
	
	Emp queryById(Integer empId);
	
	List<Emp> queryByPage(Pager pager);
	
	int getCount();
	
	Emp queryByName(String empLoginName);
	
	String queryEmpPic(String empLoginName);
	
	void updateEmpPic(@Param("empLoginName")String empLoginName,@Param("empPic")String empPic);
	
	void updateEmpPwd(@Param("empLoginName")String empLoginName,@Param("empPwd")String empPwd);
}
