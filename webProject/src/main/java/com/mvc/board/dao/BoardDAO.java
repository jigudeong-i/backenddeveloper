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
	
	//vo 사용을 메서드에 담음. 아래 메서드들에서 어떻게 사용되는지 보기. 메서드마다 일일히 다 쓰는게 귀찮아서 메서드로 만들어버림.    
	private BoardVO addBoard(ResultSet rs) throws SQLException{
		BoardVO boardVO = new BoardVO();
		boardVO.setNum(rs.getInt("num"));
		boardVO.setAuthor(rs.getString("author"));
		boardVO.setTitle(rs.getString("title"));
		boardVO.setWriteday(rs.getString("writeday"));
		boardVO.setReadcnt(rs.getInt("readcnt"));
		return boardVO;
	}
	
	
	//게시판 불러오기, 조회
	public List<BoardVO> boardList(){
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, to_char(writeday, 'YYYY/MM/DD') writeday, readcnt ");
		query.append("FROM board ");
		query.append("order by num desc");
		
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());  //toString:SQL문자열 꺼내기 prepareStatement:준비된 문장 만들기 
			ResultSet rs = pstmt.executeQuery()){	///1.ResultSet은 무슨 클래스인지 설명하시오. 
			
			while (rs.next()) {						///2.next()는 무엇인가? 
				list.add(addBoard(rs));
			}
		} catch (SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
			//se.printStackTrace(); //오류 발생 시 주석 해제 
		}
		return list;
	}
	
	
	/*
	 * public List<BoardVO> boardList(){ List<BoardVO> list = new
	 * ArrayList<BoardVO>();
	 * 
	 * StringBuilder query = new StringBuilder(); query.
	 * append("SELECT num, author, title, to_char(writeday, 'YYYY/MM/DD' writeday, readcnt "
	 * ); query.append("from board") }
	 */
	
	
	//글입력
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
	
	
	//조회수
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
	
	
	//상세보기
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

	
	//글수정
	public int boardUpdate(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("UPDATE board SET title = ?, content = ? "); //제목과 내용은 변경된 내용이, 기존값 그대로
		if(boardVO.getPasswd()!="") query.append(", passwd = ? "); //비밀번호는 변경할 수도 하지 않을 수도 있음.
		query.append("WHERE num = ?");
		
		int result = 0;
		try (Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());){
			
			pstmt.setString(1, boardVO.getTitle());
			pstmt.setString(2, boardVO.getContent());
			
			if(boardVO.getPasswd() != "") {
				pstmt.setString(3, boardVO.getPasswd());
				pstmt.setInt(4, boardVO.getNum());
			} else {
				pstmt.setInt(3, boardVO.getNum());
			}
			
			result = pstmt.executeUpdate();
		} catch(SQLException e) {
			System.err.print("[boardUpdate] SQL 오류: " + e.getMessage());
			// e.printStackTrace(); //오류 발생 시 주석 해제 
		}
		return result;
	}

	
	//글삭제
	public int boardDelete(BoardVO boardVO) {
		StringBuilder query = new StringBuilder();
		query.append("DELETE FROM board WHERE num = ?");
		
		int result = 0;
		try(Connection conn = getConnection();
			PreparedStatement pstmt = conn.prepareStatement(query.toString());){
			
			pstmt.setInt(1, boardVO.getNum());
			result = pstmt.executeUpdate();
		}catch(SQLException e) {
			System.err.println("[boardDelete] SQL 오류: " + e.getMessage());
			//e.printStackTrace(); //오류 발생 시 주석 해제
		}
		return result;
	}

	//비밀번호 체크
	public int boardPasswdCheck(BoardVO boardVO) {
		String query = """
			SELECT CASE
					WHEN EXISTS (SELECT 1 FROM board WHERE num = ? AND passwd = ?)
					THEN 1
					ELSE 0
				END AS result
			FROM dual
		""";
		
		int result = 0;
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query);){
			
			pstmt.setInt(1, boardVO.getNum());
			pstmt.setString(2, boardVO.getPasswd());
			
			try(ResultSet rs = pstmt.executeQuery()){
				if(rs.next()) {
					result = rs.getInt("result"); // 비밀번호 일치:1 / 불일치: 0 반환 
					
				}
			}
		} catch(SQLException e) {
			System.err.println("[boardPassCheck] SQL 오류: " + e.getMessage());
			//e.printStackTrace(); //오류 발생 시 주석 해제
		}
		return result;
	}
	
	
	public List<BoardVO> boardList(BoardVO boardVO){
		List<BoardVO> list = new ArrayList<BoardVO>();
		String search = boardVO.getSearch();
		String keyword = boardVO.getKeyword();
		
		StringBuilder query = new StringBuilder();
		query.append("SELECT num, author, title, ");
		query.append("to_char(writeday, 'YYYY/MM/DD') writeday, readcnt ");
		query.append("FROM board");
		switch(search) {
			case "title":
				query.append(" WHERE title LIKE ? "); //검색대상이 제목일 경우
				break;
			case "author":
				query.append(" WHERE author LIKE ? "); //검색대상이 작성자일 경우
				break;
		}
		query.append(" order by num desc");
		
		try (Connection conn = getConnection();
				PreparedStatement pstmt = conn.prepareStatement(query.toString());){
			if(!search.equals("all")) {
				pstmt.setString(1, "%" + keyword + "%" );
			}
			
			try (ResultSet rs = pstmt.executeQuery()){
				while (rs.next()) {
					list.add(addBoard(rs));
				}
			}
		} catch (SQLException e) {
			System.err.println("[boardList] SQL 오류: " + e.getMessage());
			//e.printStackTrace(); //오류 발생 시 주석 해제 
		}
		return list;
	} 

}


/*
 * 1.정확히는 java.sql.ResultSet이라는 인터페이스이며, JDBC 드라이버에서 이를 구현한 객체를 반환해줍니다. 이처럼
 * SELECT 쿼리를 실행할 때 사용되며, 결과 테이블의 행(row)들을 rs 객체에서 하나씩 꺼내 읽습니다.
 * 
 * 2.다음 행(row)으로 이동.다음 행이 있으면 true, 없으면 false. 처음 호출 시 1번째 행으로 이동
 */







