package com.cxsw.web.service;

import java.util.List;
import java.util.Map;

import com.cxsw.web.po.Student;
import com.cxsw.web.utils.DbUtil;

/**
 * @title StudentService.java
 * @describe �������ݿ⣬���ؽ��
 *           <p> ҵ���
 *           <p>
 *           1����Ҫ����Ŀ�귽��--ʲôҵ��
 * @author Rubin Zhang
 * @date 2017��5��18������7:52:42
 */
public class StudentsServiceImpl implements StudentsService {
	private DbUtil db = new DbUtil();
	private String sql = "";
	private int result = 0;
	private List<Map<String, Object>> data = null;

	/**
	 * ��¼ҵ��
	 * 
	 * @param userName
	 * @param userPass
	 * @return
	 */
	public boolean login(String userName, String userPass) {
		sql = "SELECT * FROM user_info WHERE user_name =? AND user_pas = ? AND state = '1'";
		result = db.query(sql, userName, userPass).size();
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * ���ҵ��
	 */
	@Override
	public boolean save(Student stu) {
		sql = "INSERT INTO student_info (stu_name,stu_sex,stu_age,stu_school"
				+ ",stu_address,stu_info,stu_phone,stu_hobby,stu_img,stater)"
				+ " VALUES(?,?,?,?,?,?,?,?,'defult.png','1')";
		result = db.update(sql, stu.getStuName(),stu.getStuSex(),
				stu.getStuAge(),stu.getStuSchool(),
				stu.getstuAddress(),stu.getStuInfo(),
				stu.getStuPhone(),stu.getStuHobby());
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public boolean update(int id) {
		sql = "UPDATE ���� SET �ֶ��� = ռλ�� WHERE id = ? ";
		result = db.update(sql, "����", id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	/**
	 * ɾ��
	 */
	@Override
	public boolean deleteOneById(int id) {
		sql = "DELETE FROM ����  WHERE id = ? ";
		result = db.update(sql, id);
		if (result > 0) {
			return true;
		}
		return false;
	}

	@Override
	public List<Map<String, Object>> getStudentById(int id) {
		sql = "SELECT * FROM ���� WHERE id = ?";
		data = db.query(sql, id);
		return data;
	}

	@Override
	public Student getStudenOnetById(int id) {
		Student student = new Student();
		sql = "SELECT * FROM ���� WHERE id = ?";
		//data = db.query(sql, id).get(0);
		return student;
	}

	@Override
	public List<Map<String, Object>> queryAll() {
		sql = "SELECT * FROM student_info GROUP BY stu_id DESC";
		data = db.query(sql);
		return data;
	}

	/**
	 * ģ����ѯ -- �ؼ��� �� LIKE '%scanParam%' 
	 */
	@Override
	public List<Map<String, Object>> queryScanParam(String scanParam) {
		sql = "SELECT * FROM ���� WHERE �ֶ�  LIKE '%scanParam%'";
		data = db.query(sql);
		return data;
	}

	@Override
	public List<Map<String, Object>> pageQuery(int page) {
		// TODO Auto-generated method stub
		return null;
	}
}
