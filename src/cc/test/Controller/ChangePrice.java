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

public class ChangePrice extends HttpServlet {

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

		double price=Double.parseDouble(request.getParameter("price"));
		String id=request.getParameter("id");
		
		HttpSession session=request.getSession();
		String name=(String) session.getAttribute("username");
		
		Connection conn;
		PreparedStatement st;

		try
		{
			Class.forName("com.mysql.jdbc.Driver");//��������
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb�����ݿ����ƣ�root��msql��������ݿ�����
			String sql="update seller set price=? where name=? and id=?";
			st=conn.prepareStatement(sql);
			st.setDouble(1, price);//����1
			st.setString(2, name);//����2
			st.setString(3, id);//����3
			st.executeUpdate();
			st.close();
			conn.close();

			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("Login2").forward(request, response);
		
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
