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
 * 数据分析Controller
 * @author Administrator
 *
 */
@Controller
public class AnaController {
	
	@Autowired
	private AnaService service;
	
	/**
	 * 部门员工人数
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/queryDeptEmpCount")
	public @ResponseBody List<DeptEmpCount> queryDeptEmpCount(HttpServletRequest request,HttpServletResponse response) {
		return service.queryEmpCount();
	}
	
	/**
	 * 职务平均工资
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/jobAvgSalary")
	public @ResponseBody List<Map<String, Object>> jobAvgSalary(HttpServletRequest request,HttpServletResponse response) {
		return service.queryJobAvgSal();
	}
	
	/**
	 * 部门最低最高工资
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/ana/queryDeptSal")
	public @ResponseBody List<DeptSal> queryDeptSal(HttpServletRequest request,HttpServletResponse response) {
		return service.queryDeptSal();
	}
}
