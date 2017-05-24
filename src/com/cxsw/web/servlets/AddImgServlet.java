package com.cxsw.web.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import com.cxsw.web.po.ImgModel;
import com.cxsw.web.service.ImgService;
import com.cxsw.web.service.ImgServiceImpl;
import com.cxsw.web.utils.HttpUtils;

@WebServlet("/AddImgServlet")
@MultipartConfig
public class AddImgServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println("����·��");
		// 1.���ñ���
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 2.��ȡ����
		String imgDec = request.getParameter("imgDec");
		//�ļ��ϴ������
		Part part = request.getPart("fileName");
		//Ŀ���ļ��洢λ��
		String parent = request.getServletContext().getInitParameter("filePath");
		//�ϴ�����
		String fileNewName = HttpUtils.fileUpload(part, parent);
		// 3.�洢��ģ����
		ImgModel im = new ImgModel(-1,imgDec,fileNewName);
		// 4.����ҵ���� save()
		ImgService ims = new ImgServiceImpl();
		// 5.��Ӧ
		if (ims.save(im)) {
			//
			response.sendRedirect(request.getContextPath() + "/success.jsp");
		} else {
			response.sendRedirect(request.getContextPath() + "/fail.jsp");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}

}
