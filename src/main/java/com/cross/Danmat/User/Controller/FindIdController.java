package com.cross.Danmat.User.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.User.Command.UserCommand;
import com.cross.Danmat.User.Service.UserService;

@Controller
@RequestMapping("findId")
public class FindIdController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	UserService userService = context.getBean("userService", UserService.class);
	//============================================ 아이디 찾기 form ================================================
	@GetMapping
	public String FindIdForm(Model model) {
		return "User/findId/findId";
	}
	
	//============================================ 아이디 찾기 ================================================
	@PostMapping
	public String findId(@ModelAttribute("user") UserCommand user, Model model) {
		List<UserCommand> findId = userService.findId(user.getEmail());
		model.addAttribute("findId",findId);
		findId.forEach(c -> user.setUserid(c.getUserid()));
		System.out.println(user.getEmail());
		if(user.getUserid() == null) {
			return "User/findId/error_findId";
		}
		
		return "User/findId/success_findId";
	}
}
