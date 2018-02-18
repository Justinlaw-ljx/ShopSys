package cc.test.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Delete2 extends HttpServlet {

	/**
	 * The doGet method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to get.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String name=request.getParameter("username");
System.out.print(name);
Connection conn;
PreparedStatement st;
ResultSet rs;


try
{
	Class.forName("com.mysql.jdbc.Driver");//加载驱动
	conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb是数据库名称，root是msql密码和数据库密码
	st=conn.prepareStatement("select * from user where name=?");//SQL预编译
	st.setString(1, name);//1对应数据库表第一个字段，2的话就是第二个字段，names是要查询的参数
	rs=st.executeQuery();
	if(rs.next())//判断结果集是否为空
	{
		if(rs.getString("kind").equals("1"))
		{
		String sql="delete cart2.* from book,cart2 where book.name=? and cart2.id=book.id" ;
		st=conn.prepareStatement(sql);
		st.setString(1, name);
		st.executeUpdate();
		
		sql="delete cart.* from book,cart where book.name=? and cart.id=book.id" ;
		st=conn.prepareStatement(sql);
		st.setString(1, name);
		st.executeUpdate();
		
		sql="delete from book where name=? " ;
		st=conn.prepareStatement(sql);
		st.setString(1, name);
		st.executeUpdate();
		
		sql="delete  from user where name=?" ;
		st=conn.prepareStatement(sql);
		st.setString(1, name);
		st.executeUpdate();
		
		rs.close();
		st.close();
		conn.close();
		}
		else if(rs.getString("kind").equals("0"))
		{
			String sql="delete from cart where name=?" ;
			st=conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			
			sql="delete from cart2 where name=?" ;
			st=conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			
			sql="delete  from user where name=?" ;
			st=conn.prepareStatement(sql);
			st.setString(1, name);
			st.executeUpdate();
			rs.close();
			st.close();
			conn.close();
		}
	}
	else
	{
		rs.close();
		st.close();
		conn.close();
	}
	
} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}

request.getRequestDispatcher("Admin").forward(request, response);

	}

	/**
	 * The doPost method of the servlet. <br>
	 *
	 * This method is called when a form has its tag value method equals to post.
	 * 
	 * @param request the request send by the client to the server
	 * @param response the response send by the server to the client
	 * @throws ServletException if an error occurred
	 * @throws IOException if an error occurred
	 */
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

}
