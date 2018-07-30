package com.icss.hr.analyze.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.analyze.dto.DeptEmpCount;
import com.icss.hr.analyze.dto.DeptSal;
import com.icss.hr.analyze.service.AnaService;

/**
 * ���ݷ���Controller
 * @author Administrator
 *
 */
@Controller
public class AnaController {
	
	@Autowired
	private AnaService service;
	
	/**
	 * ����Ա������
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/queryDeptEmpCount")
	public @ResponseBody List<DeptEmpCount> queryDeptEmpCount(HttpServletRequest request,HttpServletResponse response) {
		return service.queryEmpCount();
	}
	
	/**
	 * ְ��ƽ������
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/jobAvgSalary")
	public @ResponseBody List<Map<String, Object>> jobAvgSalary(HttpServletRequest request,HttpServletResponse response) {
		return service.queryJobAvgSal();
	}
	
	/**
	 * ���������߹���
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/queryDeptSal")
	public @ResponseBody List<DeptSal> queryDeptSal(HttpServletRequest request,HttpServletResponse response) {
		return service.queryDeptSal();
	}
}
