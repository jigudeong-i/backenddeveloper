package com.mvc.notice.service;

import java.util.List;

import com.mvc.notice.dao.NoticeDAO;
import com.mvc.notice.vo.NoticeVO;

public class NoticeServiceImpl implements NoticeService {
	private static NoticeServiceImpl service = null;
	private NoticeDAO dao;
	
	private NoticeServiceImpl() {
		dao = NoticeDAO.getInstance();
	}
	
	public static NoticeServiceImpl getInstance() {
		if(service == null) {
			service = new NoticeServiceImpl();
		}
		return service;
	}
	
	@Override
	public List<NoticeVO> noticeList() {
		List<NoticeVO> list = dao.noticeList();
		return list;
	}
}
