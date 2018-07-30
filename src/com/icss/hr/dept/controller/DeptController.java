package com.icss.hr.dept.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.junit.runners.Parameterized.Parameters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
/**
 * ���ſ�����
 * @author Administrator
 *
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.dept.pojo.Dept;
import com.icss.hr.dept.service.DeptService;
@Controller

public class DeptController {
	
	@Autowired
	private DeptService service;
	
	@RequestMapping("/dept/add")
	public void addDept(Dept dept,HttpServletRequest request,HttpServletResponse response) {
		service.addDept(dept);
	}
	
	/**
	 * ��ѯ����
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/dept/query")
	public @ResponseBody List<Dept> queryDept(HttpServletRequest request,HttpServletResponse response) {
		return service.queryDept();
	}
	
	/**
	 * ɾ������
	 * @param deptId
	 * @param request
	 * @param response
	 */
	@RequestMapping("/dept/delete")
	public void deleteDept(Integer deptId,HttpServletRequest request,HttpServletResponse response) {
		service.deleteDept(deptId);
	}
	
	/**
	 * ͨ��ID��ѯ����
	 */
	@RequestMapping("/dept/get")
	public @ResponseBody Dept getDept(Integer deptId,HttpServletRequest request,HttpServletResponse response) {
		return service.queryDeptById(deptId);
	}
	
	/**
	 * �޸Ĳ���
	 */
	@RequestMapping("dept/update")
	public void updateDept(Dept dept,HttpServletRequest request,HttpServletResponse response) {
		service.updateDept(dept);
	}
}
