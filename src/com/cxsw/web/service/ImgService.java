package com.cxsw.web.service;

import com.cxsw.web.po.ImgModel;

/**
 * @title ImgService.java
 * @describe ����ӿڷ�����ȷ���������ͼ�����
 *           <p>
 * @author Rubin Zhang
 * @date 2017��5��21������10:48:23
 */
public interface ImgService {
	/**
	 * ͼƬ���淽��
	 * 
	 * @param im
	 *            ��Ҫ����ģ�Ͷ��� ImgModel
	 * @return ����Boolean ,��ΪTrue ,����ɹ�����False ,����ʧ��
	 */
	boolean save(ImgModel im);
	// ......
}
