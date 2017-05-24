package com.cxsw.web.servlets;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.service.StudentsService;
import com.cxsw.web.service.StudentsServiceImpl;

/**
 * @title QueryAllStudentServlet.java
 * @describe ��ѯȫ����Ϣ�Ŀ�����
 *           <p>
 * @author Rubin Zhang
 * @date 2017��5��18������9:50:59
 */
public class QueryAllStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		//1.���ñ���
		
		//2.���� StudentService --> queryAll(); --> List<Map<String,Object>> 
		StudentsService studentsService = new StudentsServiceImpl();
		List<Map<String,Object>>  data = studentsService.queryAll();
		System.out.println("data:QueryAllStudentServlet----:"+data);
		request.setAttribute("data", data);
		request.getRequestDispatcher("/mvc/listStudent.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
