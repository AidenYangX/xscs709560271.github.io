package com.cxsw.web.service;

import java.util.List;
import java.util.Map;

import com.cxsw.web.po.Student;

/**
 * @title StudentsService.java
 * @describe ҵ��ӿ���
 *           <p>
 *           ���ã����巽����ȷ����������
 * @author Rubin Zhang
 * @date 2017��5��18������8:02:04
 */
public interface StudentsService {

	/**
	 * ��¼����
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	boolean login(String userName, String userPass);

	/**
	 * �������
	 * 
	 * @return
	 */
	boolean save(Student student);

	/**
	 * �޸Ĳ���
	 * 
	 * @param id
	 *            Ψһ��ʶ
	 * @return
	 */
	boolean update(int id);

	/**
	 * ɾ��һ����¼
	 * 
	 * @param id
	 *            Ψһ��ʶ
	 * @return
	 */
	boolean deleteOneById(int id);

	/**
	 * ����id ��ȡһ����¼
	 * 
	 * @param id
	 *            Ψһ��ʶ
	 * @return
	 */
	List<Map<String, Object>> getStudentById(int id);

	/**
	 * ����id ��ȡһ������
	 * 
	 * @param id
	 * @return
	 */
	Student getStudenOnetById(int id);

	/**
	 * ��ѯȫ��
	 * 
	 * @return
	 */
	List<Map<String, Object>> queryAll();

	/**
	 * ģ����ѯ
	 * 
	 * @param scanParam
	 * @return
	 */
	List<Map<String, Object>> queryScanParam(String scanParam);

	/**
	 * ��ҳ��ѯ
	 * 
	 * @param page
	 * @return
	 */
	List<Map<String, Object>> pageQuery(int page);

	// ����������������
}
