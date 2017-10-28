package com.ofo.modules.sys.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.apache.jasper.tagplugins.jstl.core.Redirect;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.ofo.modules.sys.entity.Menu;
import com.ofo.modules.sys.entity.User;
import com.ofo.modules.sys.service.MenuService;
import com.ofo.modules.sys.service.UserService;


/**
 * LoginController
 * @author lord.y
 *
 */
@Controller
public class LoginController {
	
	@Autowired
	private UserService userService;
	
	@Resource
	HttpServletRequest request;
	
	@Autowired
	private MenuService menuService;
	
	
	/**
	 * 初始页面
	 * @return
	 */
	@RequestMapping(value="")
	public String get(){
//		ModelAndView view = new ModelAndView("modules/sys/login");
//		User user = userService.selectByName("admin");
//		view.addObject("user", user);
		
		return "modules/sys/login";
	}
	
	/**
	 * login
	 * @param user
	 * @param mode
	 * @return
	 */
	@RequestMapping(value="login", method = RequestMethod.POST)
	public String login(User loginUser, Model model,HttpSession httpSession){
				String userName = loginUser.getUserName();
				User user = userService.selectByName(userName);
				
				//若没有查到数据则提示用户不存在
				//若密码不匹配则提示用户名密码错误
				//正确则登录
				if(user == null){
					model.addAttribute("error", "用户不存在");
					return "modules/sys/login";
				}else if(!user.getPassword().equals(loginUser.getPassword())){
					model.addAttribute("error", "用户名／密码错误");
					return "modules/sys/login";
				}
				httpSession.setAttribute("user", user);
	            return "redirect:/index" ;
		
	}
	
	@RequestMapping(value="index")
	public String index(HttpSession httpSession, Model model){
		String roleId = ((User)httpSession.getAttribute("user")).getRoleId();
		/**
		 * 查询所有菜单
		 */
		List<Menu> menuList = menuService.getMenuByRole(roleId);
		
		model.addAttribute("menu", menuList);
		
		return "modules/sys/index";
		
	}
	
	
	/**
	 * 用户注销
	 * @param httpSession
	 * @return
	 */
	@RequestMapping(value="logout")
	public String logout(HttpSession httpSession){
		
		if(httpSession == null){
			return "redirect:/";
		}
		
		httpSession.removeAttribute("user");
		httpSession.invalidate();
		return "redirect:/";
		
	}
	
	
	

}
