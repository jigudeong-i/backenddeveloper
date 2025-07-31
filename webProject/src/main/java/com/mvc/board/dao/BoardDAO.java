package com.mvc.board.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.mvc.common.util.DBUtil.getConnection;
import com.mvc.board.vo.BoardVO;

public class BoardDAO {
	private static BoardDAO instance = null;
	
	public static BoardDAO getInstance() { //BoardDAO의 인스턴스는 BoardDAO.getInstance()
		if(instance==null) {
			instance = new BoardDAO();
		}
		return instance;
	}
	
	private BoardDAO() {} // 다른 클래스 new BoardDAO 못하게 
	
	private BoardVO addBoard(ResultSet rs) throws SQLException{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(rs.getInt("num"));
		boardVO.setAuthor(rs.getString("author"));
		boardVO.setTitle(rs.getString("title"));
		boardVO.setWriteday(rs.getString("writeday"));
		boardVO.setReadcnt(rs.getInt("readcnt"));
		return boardVO;
	}
	
	public List<BoardVO> boardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, ");
		query.append("to_char(writeday, 'YYYY/MM/DD') writeday, readcnt ");
		query.append("FROM board ");
		query.append("order by num desc");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());
			ResultSet rs = pstmt.executeQuery()){
			
			while (rs.next()) {
				list.add(addBoard(rs));
			}
		} catch (SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
			//se.printStackTrace(); //오류 발생 시 주석 해제 
		}
		return list;
	}
	
	public int boardInsert(BoardVO boardVO) {
		/*String query = """
		 * INSERT INTO board (num, author, title, content, passwd)
		 * VALUES (board_seq.nextval, ?, ?, ?, ?)
		 * """;
		 */
		
		StringBuilder query = new StringBuilder();
		query.append("INSERT INTO board(num, author, title, content, passwd) ");
		query.append("VALUES(board_seq.nextval, ?, ?, ?, ?)");
		
		int result = 0;
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())){ // 주석 부분을 해제하고 사용한다면 query.toString() -> query로 변경.
			
			pstmt.setString(1, boardVO.getAuthor());
			pstmt.setString(2, boardVO.getTitle());
			pstmt.setString(3, boardVO.getContent());
			pstmt.setString(4, boardVO.getPasswd());
				
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.err.println("[boardInsert] SQL 오류: " + e.getMessage());
			// e.printStackTrace(); //오류 발생 시 주석 해제
		} 
		return result;
	}
	
	public void readCount(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE board SET readcnt = readcnt + 1 ");
		query.append("WHERE num = ?");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());){
			
			pstmt.setInt(1, boardVO.getNum());
			pstmt.executeUpdate( );
		} catch(SQLException e) {
			System.err.println("[readCount] SQL 오류: " + e.getMessage());
			//e.printStackTrace(); // 오류 발생 시 주석 해제 
		}
	}
	
	public BoardVO boardDetail (BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, content, ");
		query.append("TO_CHAR(writeday,'YYYY-MM-DD HH24:MI:SS') writeday, readcnt ");
		query.append("FROM board WHERE num = ?");
		BoardVO resultData = null; 
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString())){
		
			pstmt.setInt(1, boardVO.getNum());
			try (ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					resultData = addBoard(rs);
					resultData.setContent(rs.getString("content"));
					}
				}
		} catch(SQLException e) {
			System.err.println("[boardDetail] SQL 오류: " + e.getMessage());
			// e.printStackTrace(); //오류 발생시 주석 해제
		}
		return resultData;
	}
	
	
	
}












