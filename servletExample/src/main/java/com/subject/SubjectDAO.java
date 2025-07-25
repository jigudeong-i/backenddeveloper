package com.subject;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import static com.common.DBUtil.getConnection;      // 정적은 클래스명이 오는데 getConnection까지 쓰면 앞으로 클래스명 생략 가능. 그래서 선언된 메서드 처럼 접근 가능 

/**
 * SubjectDAO 클래스 (Data Access Object)
 * 
 * 이 클래스는 데이터베이스의 subject 테이블에 접근하여 학과 정보를 처리하는 모든 기능을 담당한다.
 * 
 * 주된 기능은 다음과 같다: CRUD 프로그램
 * - Create (입력): 새로운 학과 정보 추가
 * - Read   (조회): 학과 목록 조회 및 검색
 * - Update (수정): 학과 정보 변경
 * - Delete (삭제): 학과 정보 삭제
 * 
 * 이 DAO 클래스는 실제 데이터 처리의 최종 단계로서, 비즈니스 로직과 데이터베이스 간의 연결을 책임진다.
 */

public class SubjectDAO {
    private static SubjectDAO instance = null;	// SubjectDAO 객체를 저장할 정적 변수 선언. 처음엔 null로 시작하고, 나중에 한 번만 생성됨 
    											 
    public static SubjectDAO getInstance() {    // 반환타입 SubjectDAO인 외부에서 호출할 수 있는 메소드.(정적 메소드). SubjectDAO 객체가 없으면 새로 만들고, 있으면 그걸 반환함
        if(instance == null) {
            instance = new SubjectDAO();
        }
        return instance;
    }  // 쉽게 말해, SubjectDAO 객체를 만들고 그 다음부턴 그 하나만 계속 써라.(싱글톤 패턴) 
    
    private SubjectDAO(){}	//외부에서 new 연산자로 생성자를 호출할 수 없도록 private 생성자 설정. 이러면 오직 클래스 내부에서만 객체 생성. 
    	
    /* 위 내용을 구현 */
    private SubjectVO addSubject(ResultSet rs) throws SQLException {
        SubjectVO subjectVO = new SubjectVO();		// ResultSet 받아옴
        subjectVO.setNo(rs.getInt("no"));						
        subjectVO.setSubjectNumber(rs.getString("s_num"));			
        subjectVO.setSubjectName(rs.getString("s_name"));			
        return subjectVO;										
    }

    
    
    
    
    public List<SubjectVO> getAllSubjects() {
        List<SubjectVO> list = new ArrayList<>();
        String sql = "SELECT no, s_num, s_name FROM subject ORDER BY no";

        try (Connection conn = getConnection();        // 원래 dbutil.getConection인데.. 맨 위 주석 참고
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                list.add(addSubject(rs));       // 분리하자. 
            }

        } catch (SQLException e) {
            System.err.println("[getAllSubjects] SQL 오류: " + e.getMessage());
            //se.printStackTrace();  //오류 발생 시 주석 해제
        }
        return list;
    }
    
    
    
    
    
    public String getSubjectNumber() {
    	String subjectNumber = "";
    	
    	StringBuilder sql = new StringBuilder();
    	sql.append("SELECT NVL(TO_CHAR(MAX(s_num)+1, 'FM00'), '01') ");
    	sql.append("AS subjectNum FROM subject");
    	
    	try (Connection conn = getConnection();
    			PreparedStatement pstmt = conn.prepareStatement(sql.toString());
    			ResultSet rs = pstmt.executeQuery();){
    		if(rs.next()) {
    			subjectNumber = rs.getString("subjectNum");
    		}
    	} catch (SQLException se) {
    		System.err.println("[getSubjectNumber] SQL 오류: " + se.getMessage());
    		//se.printStackTrace();
    	}
    	return subjectNumber; 	
    }

    
    
    
    
    
    
    
    public boolean subjectInsert(SubjectVO subjectVO) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("INSERT INTO subject(no, s_num, s_name) ");
    	sql.append("VALUES(subject_seq.nextval, ?, ?)");
    	
    	try (Connection conn = getConnection();
    		PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
    		
    		pstmt.setString(1, subjectVO.getSubjectNumber()); // 첫번째 ?(바인딩변수) 설정값 - 학과번호
    		pstmt.setString(2,  subjectVO.getSubjectName());  // 두번째 ?(바인딩변수) 설정값 - 학과명     		
    		
    		return pstmt.executeUpdate() == 1;
    	} catch(SQLException se) {
    		System.out.println("[subjectInsert] SQL 오류: " + se.getMessage());
    		//se.printStackTrace(); // 오류 발생시 주석 해제 
    		return false;
    	}
    }
    
    
    
    
    public boolean subjectUpdate(SubjectVO subjectVO) {
    	StringBuilder sql = new StringBuilder();
    	sql.append("UPDATE subject SET s_name = ? ");
    	sql.append("WHERE s_num = ?");
    
	    try (Connection conn = getConnection();
	    	PreparedStatement pstmt = conn.prepareStatement(sql.toString());){
	    	
	    	pstmt.setString(1, subjectVO.getSubjectName());
	    	pstmt.setString(2, subjectVO.getSubjectNumber());
	    	
	    	return pstmt.executeUpdate() ==1;
	    }catch(SQLException se) {
	    	System.err.println("[subjectUpdate] SQL 오류: " + se.getMessage());
	    	//se.printStackTrace(); //오류 발생 시 주석 해제
	    	return false;
	    }
    }
}








