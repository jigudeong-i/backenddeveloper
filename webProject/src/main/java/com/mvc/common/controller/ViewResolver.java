package com.mvc.common.controller;

public class ViewResolver {
	public String prefix; // 공통 경로(폴더)를 명시
	public String suffix; // 확장자 명시
	
	public void setPrefix(String prefix) {
		this.prefix = prefix;
	}
	
	public void setSuffix(String suffix) {
		this.suffix = suffix;
	}

	// viewName = /board/getBoardList이면 prefix = /WEB-INF , suffix = .jsp
	public String getView(String viewName) {
		return prefix + viewName + suffix; // /WEB-INF/board/getBoardList.jsp를 반환.
	
											//dispatcher의 
											//viewResolver.setPrefix("/WEB-INF");
											//viewResolver.setSuffix(".jsp");
											// 위 두 매서드로 인해 뒤에 WEB-INF.jsp 를 붙여줌 
	}
	
}
