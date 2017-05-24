package com.cxsw.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.cxsw.web.po.Student;
import com.cxsw.web.service.StudentsService;
import com.cxsw.web.service.StudentsServiceImpl;
import com.sun.corba.se.impl.javax.rmi.CORBA.StubDelegateImpl;

/**
 * @title AddStudentServlet.java
 * @describe ������ӵ�����
 *           <p>
 * @author Rubin Zhang
 * @date 2017��5��18������8:29:42
 */
public class AddStudentServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		// 1.���ñ���
		request.setCharacterEncoding("UTF-8");
		response.setCharacterEncoding("UTF-8");

		// 2.��ȡ����
		String stuName = request.getParameter("stuName");
		String stuAge = request.getParameter("stuAge");
		String stuSex = request.getParameter("stuSex");
		String stuHobby = "";
		// ��ȡ��ֵ����getParameterValues(attrbute);
		String[] hobbys = request.getParameterValues("stuHobby");
		for (String str : hobbys) {
			// System.out.println("����ֵ��"+str);
			stuHobby += str + ",";
		}
		if (stuHobby != null) {
			stuHobby = stuHobby.substring(0, stuHobby.length() - 1);
		}
		String stuPhone = request.getParameter("stuPhone");
		String stuSchool = request.getParameter("stuSchool");
		String stuAddress = request.getParameter("stuAddress");
		String stuInfo = request.getParameter("stuInfo");
		System.out.println(
				"stuName:" + stuName + " , stuHobby:" + stuHobby + " ,stuSchool:" + stuSchool + " ,stuInfo:" + stuInfo);

		// 2-1 ��װ���ݵ�ģ����Student
		Student student = new Student(-1, stuName, stuSex, stuAge, stuSchool, stuAddress, stuInfo, stuPhone, stuHobby);

		// 3.����StudentService.java ��ķ��� save() ;
		StudentsService studentsService = new StudentsServiceImpl();
		// 4.���ؽ�� BOOLEAN TRUE ��ӳɹ�
		if (studentsService.save(student)) {
			// ��ӳɹ�
			// 5.TRUE ��Ӧҳ�� ��listStudent.jsp��
			response.sendRedirect(request.getContextPath() + "/mvc/listStudent.jsp");
			// request.getRequestDispatcher("/mvc/listStudent.jsp").forward(request,
			// response);
		} else {
			request.getRequestDispatcher("/mvc/addStudent.jsp").forward(request, response);
		}

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
