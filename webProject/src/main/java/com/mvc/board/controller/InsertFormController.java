package com.mvc.board.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.mvc.common.controller.Controller;

public class InsertFormController implements Controller {

	@Override
	public String execute(HttpServletRequest request, HttpServletResponse response) {
		return "/board/insertForm";   // 확장자가 없는데? = ViewResolver에서 설정함
		
	}
}
