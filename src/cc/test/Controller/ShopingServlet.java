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
import javax.servlet.http.HttpSession;

import cc.test.vo.Book;

public class ShopingServlet extends HttpServlet {

	
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException{
		request.setCharacterEncoding("utf-8");
		
		HttpSession session=request.getSession();
		
		String id=request.getParameter("id");
		String seller=(String) request.getParameter("seller");
		String name=(String) session.getAttribute("username");
		
		Connection conn;
		PreparedStatement st;
		ResultSet rs;
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb是数据库名称，root是msql密码和数据库密码
			st=conn.prepareStatement("select * from cart where name=? and id=? and seller=?");//SQL预编译
			st.setString(1, name);//1对应数据库表第一个字段，2的话就是第二个字段，names是要查询的参数
			st.setString(2, id);
			st.setString(3, seller);
			rs=st.executeQuery();
			if(rs.next())//判断结果集是否为空
			{
				int i=rs.getInt("number")+1;
				String sql="update cart set number=? where name=? and id=? and seller=?";
				st=conn.prepareStatement(sql);
				st.setInt(1, i);//参数1
				st.setString(2, name);//参数2
				st.setString(3, id);//参数3
				st.setString(4, seller);
				st.executeUpdate();
				rs.close();
				st.close();
				conn.close();
			}
			else
			{
				String sql="insert into cart(name,id,number,seller) values(?,?,?,?)";
				st=conn.prepareStatement(sql);
				st.setString(1, name);//参数1
				st.setString(2, id);//参数2
				st.setString(3, "1");//参数3
				st.setString(4, seller);
				st.executeUpdate();//因为要插入数据，所以用executeUpdate()
			}
			
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
		

		
		request.getRequestDispatcher("/mail/log.jsp").forward(request, response);
				
	}

	
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		doGet(request,response);
	}

	

}
