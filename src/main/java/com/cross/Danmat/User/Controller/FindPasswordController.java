package com.cross.Danmat.User.Controller;

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
@RequestMapping("findPassword")
public class FindPasswordController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	UserService userService = context.getBean("userService", UserService.class);
	//============================================ 비밀번호 찾기 form ================================================
		@GetMapping
		public String FindIdForm(Model model) {
			return "User/findPassword/findPassword";
		}
		
	//============================================ 비밀번호 찾기 ================================================
		@PostMapping
		public String findId(@ModelAttribute("user") UserCommand user, Model model) {
			List<UserCommand> findPassword = userService.findPassword(user.getUserid(),user.getEmail());
			model.addAttribute("findPassword",findPassword);
			findPassword.forEach(c -> user.setPasswd(c.getPasswd()));
			System.out.println(findPassword);
			if(user.getPasswd() == null) {
				return "User/findPassword/error_findPassword";
			}
			
			return "User/findPassword/success_findPassword";
		}		
		
}
