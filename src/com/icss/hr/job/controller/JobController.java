package com.icss.hr.job.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.icss.hr.job.pojo.Job;
import com.icss.hr.job.service.JobService;
/**
 * ְ��Controller
 * @author Administrator
 *
 */
@Controller
public class JobController {

	
	@Autowired
	private JobService service;
	
	@RequestMapping("/job/add")
	public void addJob(Job job,HttpServletRequest request,HttpServletResponse response) {
		service.addJob(job);
	}
	
	/**
	 * ��ѯְ��
	 * @param request
	 * @param response
	 * @return
	 */
	@RequestMapping("/job/query")
	public @ResponseBody List<Job> queryJob(HttpServletRequest request,HttpServletResponse response) {
		return service.queryJob();
	}
	
	/**
	 * ɾ��ְ��
	 */
	@RequestMapping("/job/delete")
	public void deleteJob(Integer jobId,HttpServletRequest request,HttpServletResponse response) {
		service.deleteJob(jobId);
	}
	
	/**
	 * ͨ��ID��ѯְ��
	 */
	@RequestMapping("/job/get")
	public @ResponseBody Job getJob(Integer jobId,HttpServletRequest request,HttpServletResponse response) {
		return service.queryJobById(jobId);
	}
	
	/**
	 * �޸�ְ��
	 */
	@RequestMapping("job/update")
	public void updateJob(Job job,HttpServletRequest request,HttpServletResponse response) {
		service.updateJob(job);
	}
}
