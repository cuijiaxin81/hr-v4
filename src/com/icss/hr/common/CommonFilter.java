package com.icss.hr.common;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * ������
 */
@WebFilter("/*")
public class CommonFilter implements Filter {

	public void destroy() {

	}

	public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain)
			throws IOException, ServletException {

		HttpServletRequest request = (HttpServletRequest) req;
		HttpServletResponse response = (HttpServletResponse) resp;

		// ���ñ���
		request.setCharacterEncoding("utf-8");
		response.setContentType("text/html;charset=utf-8");

		// ������������������
		response.setHeader("Access-Control-Allow-Origin", "*");

		// �ж��û��Ƿ��¼
		String uri = request.getRequestURI();
		System.out.println("����uri��" + uri);

		String baseUrl = request.getContextPath();// ����webӦ������
				
		// �ж�����url��ַ�Ƿ���Ҫ�û��Ѿ���¼
		if (!uri.equals(baseUrl + "/") 
				&& !uri.equals(baseUrl + "/login.html")
				&& !uri.equals(baseUrl + "/logout.jsp")
				&& !uri.equals(baseUrl + "/emp/login")
				&& !uri.startsWith(baseUrl + "/css") 
				&& !uri.startsWith(baseUrl + "/js")
				&& !uri.startsWith(baseUrl + "/images")) {

			// �ж�session�Ƿ����
			HttpSession session = request.getSession();

			String empLoginName = (String) session.getAttribute("empLoginName");

			if (empLoginName == null) {

				// �ж��Ƿ���ajax����
				if (request.getHeader("x-requested-with") != null
						&& request.getHeader("x-requested-with").equalsIgnoreCase("XMLHttpRequest")) {
					// ����һ���Զ��屨ͷ
					response.setHeader("sessionStatus", "timeout");
				} else {
					response.sendRedirect(baseUrl + "/logout.jsp");
				}

				return;
			}

		}
				
		// ��������ִ��
		chain.doFilter(request, response);

	}

	public void init(FilterConfig fConfig) throws ServletException {

	}

}