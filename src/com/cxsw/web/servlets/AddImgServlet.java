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
		System.out.println("测试路线");
		// 1.设置编码
		request.setCharacterEncoding("utf-8");
		response.setCharacterEncoding("utf-8");
		// 2.获取参数
		String imgDec = request.getParameter("imgDec");
		//文件上传域对象
		Part part = request.getPart("fileName");
		//目标文件存储位置
		String parent = request.getServletContext().getInitParameter("filePath");
		//上传操作
		String fileNewName = HttpUtils.fileUpload(part, parent);
		// 3.存储到模型中
		ImgModel im = new ImgModel(-1,imgDec,fileNewName);
		// 4.调用业务层的 save()
		ImgService ims = new ImgServiceImpl();
		// 5.响应
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
