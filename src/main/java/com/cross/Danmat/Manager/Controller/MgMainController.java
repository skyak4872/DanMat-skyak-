package com.cross.Danmat.Manager.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller("Manager.Controller.mgMainController")
@RequestMapping("manager/mgMain")
public class MgMainController {  //관리자 메인 창
	
	@GetMapping
	public String MgMainPage() {
		return "Manager/mgMain";
	}
	
}
