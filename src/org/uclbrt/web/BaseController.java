package org.uclbrt.web;

import java.sql.Timestamp;

import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.support.WebBindingInitializer;
import org.springframework.web.context.request.WebRequest;

import org.uclbrt.util.TimestampEditor;

/**
 * Controller的父类，用来封装Controller的
 * 	公共代码。
 *
 */
public class BaseController 
	implements WebBindingInitializer {
	//在请求开始阶段，注册类型转换器
	@InitBinder
	public void initBinder(
			WebDataBinder binder, WebRequest request) {
		//注册一个自定义的类型转换器；
		//给java.sql.Timestamp指定转换器为TimestampEditor;
		binder.registerCustomEditor(Timestamp.class, new TimestampEditor());
	}

}
