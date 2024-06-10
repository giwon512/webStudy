package mybean.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;

import mybean.dto.Employee;

public class EmployeeDao2 {
	private Connection conn;
	private PreparedStatement stmt;
	private ResultSet rs;
	
	public EmployeeDao2() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver"); 
			String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
			conn = DriverManager.getConnection(url,"scott","1111"); 
		}
		catch(Exception err) {
			System.out.println("연결 객체 생성 실패 : " + err);
		}
	}
	
	public void freeConn() {
		try {
			if(conn != null) conn.close();
			if(stmt != null) stmt.close();
			if(rs != null) rs.close();
		}
		catch(Exception err) {}
	}
	
	//addEmp_proc.jsp
	public void setEmp(Employee emp) {
		String sql = "insert into tblEmp values(seq_eno.nextVal, ?, ?, ?, ?)";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getE_id());
			stmt.setString(2, emp.getE_name());
			stmt.setString(3, emp.getE_pass());
			stmt.setString(4, emp.getE_address());
			
			stmt.executeUpdate();
		}
		catch(Exception err) {
			System.out.println("setEmp()에서 오류 : " + err);
		}
		finally{
			freeConn();
		}
	}
	
	//updateEmp.jsp
	public Employee getEmp(String no) {
		Employee emp = new Employee();
		String sql = "select * from tblEmp where e_no=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(no));
			rs = stmt.executeQuery();
			rs.next();
			
			emp.setE_id(rs.getString("e_id"));
			emp.setE_name(rs.getString("e_name"));
			emp.setE_pass(rs.getString("e_pass"));
			emp.setE_address(rs.getString("e_address"));
		}
		catch(Exception err) {
			System.out.println("getEmp()에서 오류 : " + err);
		}
		finally{
			freeConn();
		}
		
		
		return emp;
	}
	
	//updateEmp_proc.jsp
	public void updateEmp(Employee emp) {
		String sql = "update tblEmp set e_id=?, e_name=?, e_pass=?, e_address=? where e_no=?";
		
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setString(1, emp.getE_id());
			stmt.setString(2, emp.getE_name());
			stmt.setString(3, emp.getE_pass());
			stmt.setString(4, emp.getE_address());
			stmt.setString(5, emp.getE_no());
			
			stmt.executeUpdate();
		}
		catch(Exception err) {
			System.out.println("updateEmp()에서 오류 : " + err);
		}
		finally{
			freeConn();
		}
	}
	
	//deleteEmp.jssp
	public void setDeleteEmp(String no) {
		String sql = "delete from tblEmp where e_no=?";
		try {
			stmt = conn.prepareStatement(sql);
			stmt.setInt(1, Integer.parseInt(no));
			
			stmt.executeUpdate();
		}
		catch(Exception err) {
			System.out.println("deleteEmp()에서 오류 : " + err);
		}
		finally{
			freeConn();
		}
	}
	
	//index.jsp
	public ArrayList<Employee> getList(String keyword, String searchText){
		ArrayList<Employee> list = new ArrayList<Employee>();
		String sql = null;
		
		if(searchText == null || searchText.isEmpty()){
			sql = "select * from tblEmp order by e_no";
		}
		else{
			sql = "select * from tblEmp where "+ keyword + " like '%" + searchText + "%'";
		}
		try {
			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			
			while(rs.next()) {
				Employee emp = new Employee();
				emp.setE_no(rs.getString("e_no"));
				emp.setE_id(rs.getString("e_id"));
				emp.setE_name(rs.getString("e_name"));
				emp.setE_pass(rs.getString("e_pass"));
				emp.setE_address(rs.getString("e_address"));
				
				list.add(emp);
			}
		}
		catch(Exception err) {
			System.out.println("getList()에서 오류 : " + err);
		}
		finally{
			freeConn();
		}
		return list;
	}
}
