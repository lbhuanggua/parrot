package com.lb.parrot.support;

import java.io.File;


/**
 * 微信HTTP上传通用构造接口
 *
 */
public interface WeChatHttpUpload {

	
	/**
	 * 获取构造文件名(不一定与上传文件名一致)
	 * @return
	 */
	String getFileName();
	
	/**
	 * 获得表单名
	 * @return
	 */
	String getFormName();
	
	/**
	 * 获得表单内容
	 * @return
	 */
	String getContent();
	
	File getFile();
}
