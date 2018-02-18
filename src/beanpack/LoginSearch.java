package beanpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class LoginSearch {
	private String sql;
	private Connection conn;
	private PreparedStatement ps;
	private ResultSet rs;
	private String username;
	
	public String getUsername()
	{
		return username;
	}
	public boolean loginsearch(String name,String pwd,String kind) throws ClassNotFoundException, SQLException{
		username=name;
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");
		sql="select * from user where name=? and password=? and kind=?";
		ps=conn.prepareStatement(sql);
		ps.setString(1, name);
		ps.setString(2, pwd);
		ps.setString(3, kind);
		rs=ps.executeQuery();
		if(rs.next()){
			rs.close();
			ps.close();
			conn.close();
			return true;
		}else{
			rs.close();
			ps.close();
			conn.close();
			return false;
		}
	}

}
