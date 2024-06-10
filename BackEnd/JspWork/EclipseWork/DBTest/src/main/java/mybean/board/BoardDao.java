package mybean.board;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import mybean.DBConnectionMgr;

public class BoardDao {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	private DataSource ds;
	private DBConnectionMgr pool;
	
	public BoardDao() {
		try {
//			ds = (DataSource)new InitialContext().lookup("java:comp/env/jdbc/EmployeeDB");
//			conn = ds.getConnection();
			pool = DBConnectionMgr.getInstance();
			conn = pool.getConnection(); 
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void freeConn() {
		if(conn != null) try { conn.close(); }catch(Exception err) {}
		if(stmt != null) try { stmt.close(); }catch(Exception err) {}
		if(rs != null) try { rs.close(); }catch(Exception err) {}
	}
	
	//List.jsp
	public List<BoardDto> getBoardList(String keyword, String searchText){
		String sql = null; 
		
		if(searchText==null || searchText.isEmpty()) {
			sql = "select * from tblboard order by pos";
		}
		else {
			sql = "select * from tblboard where " + keyword + 
					" like '%" + searchText +
					"%' order by pos";
		}
		System.out.println(sql);
	
		ArrayList<BoardDto> list = new ArrayList<>();
		
		try {
//			conn = ds.getConnection(); 
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()){
				BoardDto board = new BoardDto();
				board.setB_subject(rs.getString("b_subject"));
				board.setB_count(rs.getInt("b_count"));		
				board.setB_name(rs.getString("b_name"));
				board.setB_num(rs.getInt("b_num"));
				board.setB_regdate(rs.getString("b_regdate"));
				board.setPos(rs.getInt("pos"));
				board.setDepth(rs.getInt("depth"));
				board.setB_email(rs.getString("b_email"));
				board.setB_homepage(rs.getString("b_homepage"));
				board.setB_pass(rs.getString("b_pass"));
				
				list.add(board);
			}
		}
		catch(Exception e) {
			System.out.println("getBoardList : " + e);
		}
		finally {
			freeConn();
		}
		
		return list;
	}
	
	//PostProc.jsp
	public void setBoard(BoardDto board) {
		String sql = null;
		try {
//		conn = ds.getConnection();
			
		sql = "update tblboard set pos = pos + 1";
		stmt = conn.prepareStatement(sql);
		stmt.executeUpdate();
		
			
		sql = "insert into tblboard(b_num," +
				"b_name, b_email, b_homepage, b_subject, b_content, " +
				"b_pass, b_count, b_ip, b_regdate, pos, depth) " +
				"values(seq_b_num.nextVal, ?,?,?,?,?,?, 0, ?, sysdate, 0, 0)";

		stmt = conn.prepareStatement(sql);
		stmt.setString(1, board.getB_name());
		stmt.setString(2, board.getB_email());
		stmt.setString(3, board.getB_homepage());
		stmt.setString(4, board.getB_subject());
		stmt.setString(5, board.getB_content());
		stmt.setString(6, board.getB_pass());
		stmt.setString(7, board.getB_ip());
		stmt.executeUpdate();
		System.out.println(sql);
		}
		catch(Exception e) {
		System.out.println("setBoard : " + e);
		}
		finally {
		freeConn();
		}
	}
	//Read.jsp, Update.jsp, Reply.jsp
	public BoardDto getBoard(int b_num) {
		String sql;
		BoardDto result = new BoardDto();

		try{
//		conn = ds.getConnection();

		sql = "select * from tblboard where b_num=?";
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, b_num);
		rs = stmt.executeQuery();

		if(rs.next()){
		result.setB_content(rs.getString("b_content"));
		result.setB_count(rs.getInt("b_count"));
		result.setB_email(rs.getString("b_email"));
		result.setB_homepage(rs.getString("b_homepage"));
		result.setB_ip(rs.getString("b_ip"));
		result.setB_name(rs.getString("b_name"));
		result.setB_num(rs.getInt("b_num"));
		result.setB_pass(rs.getString("b_pass"));
		result.setB_regdate(rs.getString("b_regdate"));
		result.setB_subject(rs.getString("b_subject"));
		result.setPos(rs.getInt("pos"));
		result.setDepth(rs.getInt("depth"));
		}
		}
		catch(Exception err){
		System.out.println("getBoard() : " + err);
		}
		finally{
		freeConn();
		}

		return result;
	}
	
	//updateProc.jsp
	public void updateBoard(BoardDto dto) {
		String sql = "update tblboard set b_name=?, b_email=?, " +
				"b_subject=?, b_content=? where b_num=?";

		try{
//		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setString(1, dto.getB_name());
		stmt.setString(2, dto.getB_email());
		stmt.setString(3, dto.getB_subject());
		stmt.setString(4, dto.getB_content());
		stmt.setInt(5, dto.getB_num());

		stmt.executeUpdate();
		}
		catch(Exception err){
		System.out.println("updateBoard() : " + err);
		}
		finally{ freeConn(); }
	}
	
	//Delete.jsp
	public void deleteBoard(int b_num) {
		String sql = "delete from tblBoard where b_num=?";

		try{
//		conn = ds.getConnection();
		stmt = conn.prepareStatement(sql);
		stmt.setInt(1, b_num);
		
		stmt.executeUpdate();
		}
		catch(Exception err){
		System.out.println("deleteBoard() : " + err);
		}
		finally{ freeConn(); }
	}
	
	//ReplyProc.jsp
	public void replyBoard(BoardDto board) {
		String sql = "insert into tblboard(b_num," +
				"b_name, b_email, b_homepage, b_subject, b_content, " +
				"b_pass, b_count, b_ip, b_regdate, pos, depth) " +
				"values(seq_b_num.nextVal, ?,?,?,?,?,?, 0, ?, sysdate, ?, ?)";
				try {
					
				sql = "update tblboard set pos = pos + 1 where pos > ?";
				stmt = conn.prepareStatement(sql);
				stmt.setInt(1, board.getPos());
				stmt.executeUpdate();
					
					
					
				sql = "insert into tblboard(b_num," +
						"b_name, b_email, b_homepage, b_subject, b_content, " +
						"b_pass, b_count, b_ip, b_regdate, pos, depth) " +
						"values(seq_b_num.nextVal, ?,?,?,?,?,?, 0, ?, sysdate, ?, ?)";

				stmt = conn.prepareStatement(sql);
				stmt.setString(1, board.getB_name());
				stmt.setString(2, board.getB_email());
				stmt.setString(3, board.getB_homepage());
				stmt.setString(4, board.getB_subject());
				stmt.setString(5, board.getB_content());
				stmt.setString(6, board.getB_pass());
				stmt.setString(7, board.getB_ip());
				stmt.setInt(8, board.getPos() + 1);
				stmt.setInt(9, board.getDepth() + 1);
				stmt.executeUpdate();
				}
				catch(Exception e) {
				System.out.println("replyBoard : " + e);
				}
				finally {
				freeConn();
				}
	}
	
	
	
	
	
	
	
	
	
}


