//package com.KIAC.DM.board.controller;
//
//import java.util.List; // 이건 html로 보내도 웹에서 이해하지 못함.
//
//import org.springframework.context.annotation.AnnotationConfigApplicationContext;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//
//import com.KIAC.DM.board.domain.Board;
//import com.KIAC.DM.board.service.BoardServiceImpl;
//import com.KIAC.DM.config.DataSourceConfig;
//@Controller("board.controller.BoardController")
//@RequestMapping("/board")
//public class BoardController {
//	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DataSourceConfig.class);
//	BoardServiceImpl boardService = context.getBean("boardService", BoardServiceImpl.class);
//	
//
//	@GetMapping
//	public String CreatBoard(Model model) {
//		model.addAttribute("board", new Board());
//		return "/board/createBoard";
//	}
//	
//	/**
//	 *  데이터를 xml이나 json으로 바꿔서 넘겨줘야 한다.
//	 *  요즘은 json을 많이 쓴다. (데이터 양이 적어서)
//	 *  ※ json = 키와 값을 문자화
//	 * 
//	 * json을 javascript에서 바꿔줘야한다.
//	 *  1) class위에 @controller 대신 @RestController로 바꿔주면 된다.
//	 *  2) @controller 그대로 쓰는 경우
//	 *  	public ResponseEntity<?> doSometing() {
//	 *  		...
//	 *  		return ResponseEntiy.ok(list);  
//	 *  	}
//	 *  
//	 *  한번에 많은 데이터를 한번에 옮기기 보다
//	 *  적절한 양의 데이터를 자주 이동 = ajax
//	 *  
//	 */
//    @RequestMapping(value="/list", method = RequestMethod.GET) //url mapping
//    public String getList(Model model) throws Exception{
//        List<Board> list = service.list();
//        model.addAttribute("list", list);
//        //board/list.jsp로 포워딩
//        return "board/list";
//    }
//    
//    //게시물 작성
////    @RequestMapping(value = "/create", method = RequestMethod.GET)
////    public String getcreate() throws Exception {
////       return "board/create";
////    }
//    
//    // 게시물 작성 post
////    @RequestMapping(value = "/create", method = RequestMethod.POST)
////    public String postcreate(Board board) throws Exception {
////    	service.create(board);
////       return "redirect:list";
////    }
//    
//    // 게시물 상세 페이지로 이동
////    @RequestMapping(value = "/detail", method = RequestMethod.GET)
////    public String getdetail(Model model, int no) {
////    	Board data = service.detail(no);//no값 넘김
////    	model.addAttribute("data",data);
////       return "board/detail";
////    }
//    
//    // 게시물 수정 페이지로 이동
////    @RequestMapping(value = "/update", method = RequestMethod.GET)
////    public String getupdate(int no, Model model) throws Exception {
////    	Board data = service.detail(no);
////    	model.addAttribute("data", data);
////       return "board/update";
////    }
//    
//    // 게시글 수정 post
////    @RequestMapping(value="/update", method=RequestMethod.POST)
////    public String postupdate(Board board) throws Exception {
////        service.update(board);
////        return "redirect:list"; // 리스트로 리다이렉트
////    }
//    
//    // 게시물 삭제
////    @RequestMapping(value = "/delete", method = RequestMethod.GET)
////    public String postdelete(int no) throws Exception {
////    	service.delete(no);
////       return "redirect:list";
////    }
//}