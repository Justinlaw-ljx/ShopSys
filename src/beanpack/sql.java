package beanpack;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class sql {
	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		
		Connection conn;
		PreparedStatement st;
		ResultSet rs;
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");
		st=conn.prepareStatement("select * from user where name=? and password=?");
		st.setString(1,"ab");
		st.setString(2,"iuiui");
		rs=st.executeQuery();
		if(rs.next())
		{
			while(rs.next()){
				System.out.println(rs.getString(1));	
				System.out.println(rs.getString(2));
				System.out.println(rs.getString(3));
			}
			rs.close();
			st.close();
			conn.close();
			System.out.println("存在此用户名");	
		}
		else
			System.out.println("不存在此用户名");
			
	}

}
