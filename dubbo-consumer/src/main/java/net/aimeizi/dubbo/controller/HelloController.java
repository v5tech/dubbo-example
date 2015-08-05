package net.aimeizi.dubbo.controller;

import net.aimeizi.dubbo.entity.User;
import net.aimeizi.dubbo.service.DemoService;
import net.aimeizi.dubbo.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import javax.annotation.Resource;

@Controller
public class HelloController {

	@Resource
	private DemoService demoService;

	@Resource
	private UserService userService;

	@RequestMapping(value = "/test", method = RequestMethod.GET)
	public String printWelcome(ModelMap model) {
		model.addAttribute("message", "Hello world!");
		return "hello";
	}

	@RequestMapping(value = "/testDemo", method = RequestMethod.POST)
	public String getEnteredWordLength(ModelMap model, @RequestParam("username") String enteredWord) {
		int length = this.demoService.getLength(enteredWord);
		model.addAttribute("length", length);
		return "helloRes";
	}

	@RequestMapping(value = "/userAddView", method = RequestMethod.GET)
	public String userAddView (){
		return "userAdd";
	}
	
	@RequestMapping(value = "/userAdd", method = RequestMethod.POST)
	public String userAdd(Model model, String userName,String userEnName, String country, String company) {
		User user = new User();
		user.setUserName(userName);
		user.setUserEnName(userEnName);
		user.setCompany(company);
		User saveUser = this.userService.save(user);
		model.addAttribute("saveUser", saveUser);
		return "userAddRes";
	}
}