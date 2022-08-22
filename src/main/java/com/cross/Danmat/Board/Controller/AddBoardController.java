package com.cross.Danmat.Board.Controller;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.cross.Danmat.DataSourceConfig;
import com.cross.Danmat.Board.Domain.Board;
import com.cross.Danmat.Board.Service.BoardServiceImpl;

@Controller("Board.Controller.addBoardController")
@RequestMapping("/Board/BoardCreate")
public class AddBoardController {
	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
	BoardServiceImpl boardService = context.getBean("boardService", BoardServiceImpl.class);

	@GetMapping
	public String AddBoard(Model model) {
		model.addAttribute("board", new Board());
		return "/Board/BoardCreate";
	}
	
	@PostMapping
	public String CreateBoard(@ModelAttribute("board")
	Board board, Model model) {
		boardService.boardCreate(board);
		model.addAttribute("board", board);
		return "/Board/BoardList";
	}	
}
