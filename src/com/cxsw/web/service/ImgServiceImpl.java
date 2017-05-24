package com.cxsw.web.service;

import com.cxsw.web.po.ImgModel;
import com.cxsw.web.utils.DbUtil;

/**
 * @title    ImgServiceImpl.java
 * @describe �ӿ�ʵ����
 * <p>
 * @author   Rubin Zhang
 * @date	 2017��5��21������10:49:23
 */
public class ImgServiceImpl implements ImgService {
	private DbUtil db = null;
	private String sql ="";
	private int result = 0 ;

	@Override
	public boolean save(ImgModel im) {
		db = new DbUtil();
		sql = "INSERT INTO img_info (img_dec,img_name)VALUES(?,?)" ;
		//System.out.println("����ģ�ͣ�"+im);
		result = db.update(sql, im.getImgDec(),im.getImgName());
		//System.out.println("���Խ����"+result);
		if(result > 0){
			return true;
		}
		return false;
	}

}
