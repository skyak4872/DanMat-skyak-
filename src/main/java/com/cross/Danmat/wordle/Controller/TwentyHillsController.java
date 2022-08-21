package com.cross.Danmat.wordle.Controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.cross.Danmat.DataSourceConfig;

@Controller("wordle.Controller.TwentyHillsController")
@RequestMapping("/Game/TwentyHills")
public class TwentyHillsController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	
	
	@GetMapping
	public String TH_Games(Model model) {
//		TwentyHills twentyHills = 
		String input = "";
		List<String> hint = new ArrayList<String>();
		hint.add("힌트입니다.");
		hint.add("계속해서 나옵니다.");
		for(int i = 0; i< 5; i++) {
			input += "<input type='text' class='input' maxlength='1'>";
		}
		model.addAttribute("input", input);
		model.addAttribute("hint", hint);
		return "TwentyHills/Wordle";
	}
	
	@PostMapping
	public String check_word(@RequestParam("hint") List<String> hint) {
		hint.add("힌트1");
		return "";
	}
}
