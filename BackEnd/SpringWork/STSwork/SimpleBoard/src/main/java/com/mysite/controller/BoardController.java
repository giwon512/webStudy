package com.mysite.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.mysite.domain.Board;
import com.mysite.service.BoardService;

@Controller
@RequestMapping("/board")
public class BoardController {
	@Autowired
	private BoardService boardService;
	
	@RequestMapping("/list")
	public ModelAndView listPage() throws Exception {
		List<Board> list = boardService.getList();
		return new ModelAndView("board/list").addObject("list", list);
	}
	
	
	@GetMapping("/write")
	public ModelAndView writePage() {
		
		return new ModelAndView("board/write");
	}
	
	@PostMapping("/write")
	public String writeOk(@ModelAttribute Board board) throws Exception {
		boardService.write(board);
		System.out.println(board.getbTitle() + ", " + board.getbWriter() + ", " + board.getbContent());
		return "redirect:/board/list";
	}
	
	@GetMapping("/read")
	public ModelAndView readPage(Integer bNo) throws Exception {
		Board board = boardService.read(bNo);
		return new ModelAndView("board/read").addObject("board", board);
	}
}
