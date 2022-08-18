package com.cross.Danmat.Manager.Controller;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.Manager.Service.ManagerServiceImpl;

@Controller("Manager.Controller.mgLoginController")
@RequestMapping("manager/mglogin")
public class MgLoginController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	ManagerServiceImpl managerService = context.getBean("managerService", ManagerServiceImpl.class);
	
	@GetMapping
	public String loginPage() {
		return "Manager/mglogIn/mglogIn";
	}
	
	@PostMapping
	public String login(@RequestParam("mgid")String mgid, 
			@RequestParam("mgpasswd") String mgpasswd,
			Model model,HttpServletRequest request, HttpServletResponse response) throws IOException {
		
		int result = managerService.mglogin(mgid, mgpasswd);
		model.addAttribute("result", result);
		System.out.println(result);
		
		if(result == 2 ) {
			HttpSession session = request.getSession(true);
			session.setAttribute("mgid", mgid);
			context.close();
			return "Manager/mgMain";
		}else if(result == 1 ) {
			return "Manager/mglogIn/error_mglogIn";
		}else {
			return "Manager/mglogIn/error_mglogIn";
		}
	}
}
