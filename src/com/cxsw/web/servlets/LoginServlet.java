package com.cxsw.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.cxsw.web.service.StudentsServiceImpl;

/**
 * @title LoginServlet.java
 * @describe ��¼ҵ��
 *           <p>
 *           �����û�������request ������󣩣�������Ӧ��response ��Ӧ����
 * @author Rubin Zhang
 * @date 2017��5��7������1:46:37
 */
public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// 1.���ñ��� -- set
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		HttpSession session = request.getSession();
		// 2.��ȡ�û���������� -- get
		String userName = request.getParameter("userName");
		String passWord = request.getParameter("userPass");
		System.out.println("�����û������ֵ��name> " + userName + " , pas > " + passWord);

		// ��ʹ��DbUtil ��
		/*
		 * �� ���� jar (mysql ������) �� �����ļ��� ��com.cxsw.web.utils�� �� ���� DbUtil.java
		 */
		// ��ȷ��ѯһ����¼��userName,UserPass��

		// �� ��ʹ��ģ����
		StudentsServiceImpl studentService = new StudentsServiceImpl();

		// 3.�жϵõ����(��ʵ�������ݿ�)
		if (studentService.login(userName, passWord)) {
			// 4.�洢�û�����Ϣ(Session )
			session.setAttribute("user", userName);
			// 5.������Ӧ(����ת��/�ض���)
			request.getRequestDispatcher("/index.jsp").forward(request, response);
		} else {
			response.sendRedirect(request.getContextPath() + "/fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
