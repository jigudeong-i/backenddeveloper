package com.mvc.common.controller;

import java.util.HashMap;
import java.util.Map;

import com.mvc.notice.controller.GetNoticeListController;

public class HandlerMapping {
	private Map<String, Controller> mappings;
 
	public HandlerMapping() {
		mappings = new HashMap<String, Controller>();
		mappings.put("/notice/getNoticeList.do", new GetNoticeListController());
		
	}
	
	public Controller getController(String path) {
		return mappings.get(path);
	}
}
