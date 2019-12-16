package com.auth.controller;

import java.util.List;
import java.util.Scanner;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import net.sf.json.JSONObject;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.auth.entity.AuthInfo;
import com.auth.entity.User;
import com.auth.service.RoleService;
import com.auth.service.UserService;
import com.auth.util.MD5;
import com.auth.util.PageBean;
/**
 * 用户管理控制类
 * @author lg
 * @date 2017-09-16
 */
@Controller
@RequestMapping("/user")
public class UserController {
	@Autowired
	private UserService userService;
	@Autowired
	private RoleService roleService;
    /**
     * 登录跳转
     * @author lg
     * @param request 请求参数
     * @return  ModelAndView
     * @date 2018-05-18
     */
	@RequestMapping("/tologin")
	public String tologin(HttpServletRequest request){
		ModelAndView mod =new ModelAndView("login");
		System.out.println(request.getRequestURL());
		System.out.println(request.getRequestURI());
		System.out.println(request.getContextPath());
		//return mod;
		return "/login";
	}
	
	
	/**
	 * 登录跳转方法
	 * @param req
	 * @return
	 * 
	 */
	@RequestMapping("/login")
	@ResponseBody
	public JSONObject login(HttpServletRequest request,User user){
		String vCode=request.getParameter("vCode");
		String rand = (String) request.getSession().getAttribute("rand01");
		JSONObject json=new JSONObject();
		//1、验证验证码是否正确
		if(vCode!=null && vCode.equals(rand)){
			//验证通过
		//2、登录逻辑处理
		 User userinfo=userService.getUserInfo(user);
			if(userinfo!=null){
				request.getSession().setAttribute("userinfo", userinfo);
				//登录成功
				json.put("res", "1");
				return json;
			}else{
				//登录失败
				json.put("res", "-1");
				return json;
			}
		}else{
			//验证码不正确，返回到登录页面
			json.put("res", "0");
			return json;
		}

	}
	
	
	/**
	 * ajax验证码的验证方法
	 * @param req
	 * @return
	 */
	@RequestMapping("/validCode") // @RequestMapping(value="/validCode.action", method=RequestMethod.POST,produces="application/json;charset=UTF-8")  
	@ResponseBody
	public JSONObject  validCode(HttpServletRequest request,User user){
		//获取session中存储的验证码
		System.out.println(user.getUserName()+"............");
		String rand = (String) request.getSession().getAttribute("rand01");
		String vCode=request.getParameter("vCode");
		//String userName=request.getParameter("userName");
		//User user=userService.getUserByUserName(userName);
		//定义json对象
		JSONObject json=new JSONObject();
		if(vCode!=null && vCode.equals(rand)){
			json.put("msg", "1");
		}else{
			json.put("msg", "0");
		}
		return json;
	}
	
	
	@RequestMapping("/list")
	public ModelAndView showUserList(){
		List list=userService.getAllUsers();
		ModelAndView mav=new ModelAndView("user-list");
		mav.addObject("users", list);
		return mav;
	}
	

	@RequestMapping("/add")
	@ResponseBody
	public User addUser(User user,Long...roleIds){
		userService.addUser(user, roleIds);
		return user;
	}
	
	@RequestMapping("/showroles")
	@ResponseBody
	public List shwoRoles(String userName){
		return roleService.getRolesByUserName(userName);
	}

	@RequestMapping("/listRoles")
	@ResponseBody
	public List getRoles(){
		return roleService.getAllRoles();
	}

	@RequestMapping("/delete")
	@ResponseBody
	public void deleteUser(Long userId){
		userService.deleteUser(userId);
	}
	
	@RequestMapping("/deletemore")
	@ResponseBody
	public void deleteMoreUsers(Long...userIds){
		userService.deleteMoreUsers(userIds);
	}

	@RequestMapping("/corelationRole")
	@ResponseBody
	public void corelationRole(Long userId,Long...roleIds){
		userService.updateUserRoles(userId, roleIds);
	}
	
	public static void main(String[] args) {
		Scanner sn=new Scanner(System.in);
		System.out.println(sn.next());
	}
}
