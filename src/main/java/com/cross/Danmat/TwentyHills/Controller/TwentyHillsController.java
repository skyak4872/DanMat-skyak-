package com.cross.Danmat.TwentyHills.Controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.TwentyHills.Domain.TwentyHills;
import com.cross.Danmat.TwentyHills.Service.TwentyHillsServiceImpl;

@Controller
@RequestMapping("/Game/TwentyHills")
public class TwentyHillsController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	TwentyHillsServiceImpl twentyHillsService = context.getBean("twentyHillsService", TwentyHillsServiceImpl.class);
	Random rd = new Random();
	
	@GetMapping
	public String TH_Games(Model model, TwentyHills twentyHills) {
		twentyHills = twentyHillsService.load_word();
		String input = "<div>";
		String word = twentyHills.getWord();
		List<String> hint = new ArrayList<String>();
		String[] hint_list = twentyHills.getDiscription().split("/");
		String[] Example_list = twentyHills.getExample().replaceAll(word, "○○").split("/");
		int life = 20;
		hint.add(hint_list[rd.nextInt(hint_list.length)]);
		hint.add(Example_list[rd.nextInt(Example_list.length)]);
		for(int i = 0; i< hint_list.length; i++) {
			System.out.println(hint_list[i]);
		}
		for(int i = 0; i< word.length(); i++) {
			input += "<input type='text' class='input' maxlength='1'>";
		}
		input += "</div>";
		System.out.println(twentyHills.getWord());
		System.out.println(twentyHills.getDiscription());
		model.addAttribute("input", input);
		model.addAttribute("hint", hint);
		model.addAttribute("word", word);
		model.addAttribute("life", life);
		return "TwentyHills/Wordle";
	}
	
	@PostMapping
	@ResponseBody
	public String check_word(@RequestParam("hint") List<String> hint, @RequestParam("life")int life) {
		life--;
		hint.add("힌트1");
		return "TwentyHills/hint";
	}
}
