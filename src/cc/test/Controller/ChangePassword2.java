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

public class ChangePassword2 extends HttpServlet {

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

		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("changename");
		String pwd1=(String) request.getParameter("pwd1");
		String pwd2=(String) request.getParameter("pwd2");
//		System.out.print(name);
		if(pwd1.equals(pwd2))
		{
			try
			{
				Connection conn;
				PreparedStatement st;
				Class.forName("com.mysql.jdbc.Driver");//加载驱动
				conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb是数据库名称，root是msql密码和数据库密码
				String sql="update user set password=? where name=? ";
				st=conn.prepareStatement(sql);
				st.setString(1, pwd1);//参数1
				st.setString(2, name);//参数2
				st.executeUpdate();
				st.close();
				conn.close();
			}
		   catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
	        } catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		    }
			session.setAttribute("message", "密码修改成功");
		}
		else
		{
			session.setAttribute("message", "两次输入的密码不一致");
		}
		request.getRequestDispatcher("/mail/changepwd2.jsp").forward(request, response);
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
