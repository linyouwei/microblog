package org.uclbrt.web;

import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.uclbrt.entity.UserLogin;
import org.uclbrt.service.LoginService;
import org.uclbrt.util.SystemConstant;

/**
 * 用户登录,注册等功能
 *
 * @author YouWei Lin
 * @since 1.0.0
 */
@Controller
@RequestMapping("/webUser")
public class LoginController implements SystemConstant {
	@Resource
	private LoginService loginService;

	@RequestMapping(value ="/register.form", method = RequestMethod.GET)
	public String register() {
		return "../jsp/user/register";
	}
	@RequestMapping(value ="/register.form", method = RequestMethod.POST)
	@ResponseBody
	public Result toRegister(String username,String password ) {
		if (username == null || password == null) {
			throw new RuntimeException("参数为空");
		}
		System.out.println(username+password);
		UserLogin user = new UserLogin();
		user.setUserName(username);
		user.setPassword(password);
		Map<String, Object> map = loginService.addUser(user);
		return new Result(map);
	}
	//跳转到登录页面
	@RequestMapping(value ="/login.form", method = RequestMethod.GET)
	public String login() {
		return "../jsp/user/login";
	}
	
	@RequestMapping("/checklogin.form")
	public String toLogin(String userName, String password, HttpSession session) {
		Map<String, Object> map = loginService.checkLogin(userName, password);
		Object status = map.get("status");
		if (status.equals(SUCCESS)) {
			session.setAttribute("user", map.get("user"));
			return "redirect:/homePage/index.form";
		}else{
			session.setAttribute("error", 301);
			return "../jsp/user/login";
		}
	}
	@RequestMapping("/sign_out.form")
	public String signOut(String password, HttpSession session) {
			session.removeAttribute("user");
			return "../jsp/user/login";
		}

}
