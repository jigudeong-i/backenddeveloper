package com.mvc.notice.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.mvc.notice.vo.NoticeVO;
import static com.mvc.common.util.DBUtil.getConnection;


public class NoticeDAO {
	private static NoticeDAO instance = null;
	
	public static NoticeDAO getInstance() {
		if(instance == null) {
			instance = new NoticeDAO();
		}
		return instance;
	}
	
	private NoticeDAO() {}
	
	private NoticeVO addNotice(ResultSet rs) throws SQLException{
		NoticeVO noticeVO = new NoticeVO();
		noticeVO.setNoticeNo(rs.getInt("notice_no"));
		noticeVO.setWriter(rs.getString("writer"));
		noticeVO.setTitle(rs.getString("title"));
		noticeVO.setWriteday(rs.getString("writeday"));
		noticeVO.setViewCount(rs.getInt("view_count"));
		return noticeVO;
	}
	
	public List<NoticeVO> noticeList(){
		List<NoticeVO> list = new ArrayList<NoticeVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT notice_no, writer, title, to_char(writeday, 'YYYY/MM/DD') writeday, view_count ");
		query.append("FROM notice ");
		query.append("order by notice_no desc");
		
		try (Connection conn = getConnection(); 
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			ResultSet rs = pstmt.executeQuery()){
			
			while(rs.next()) {
				list.add(addNotice(rs));
			}
		} catch (SQLException e) {
			System.err.println("[noticeList] SQL 오류: " + e.getMessage());
		}
		return list;
	}
}
