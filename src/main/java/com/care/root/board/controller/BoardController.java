package com.care.root.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping("board")
@Controller
public class BoardController {

	@RequestMapping("notice")
	public String notice(){
	
	return "board/notice";
	}

	@RequestMapping("freeBoard")
	public String freeBoard(){
	
	return "board/freeBoard";
	}
	@RequestMapping("imageBoard")
	public String imageBoard() {
		
		return "board/imageBoard";
	}

}
