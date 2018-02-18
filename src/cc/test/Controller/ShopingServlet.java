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
			Class.forName("com.mysql.jdbc.Driver");//��������
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb�����ݿ����ƣ�root��msql��������ݿ�����
			st=conn.prepareStatement("select * from cart where name=? and id=? and seller=?");//SQLԤ����
			st.setString(1, name);//1��Ӧ���ݿ���һ���ֶΣ�2�Ļ����ǵڶ����ֶΣ�names��Ҫ��ѯ�Ĳ���
			st.setString(2, id);
			st.setString(3, seller);
			rs=st.executeQuery();
			if(rs.next())//�жϽ�����Ƿ�Ϊ��
			{
				int i=rs.getInt("number")+1;
				String sql="update cart set number=? where name=? and id=? and seller=?";
				st=conn.prepareStatement(sql);
				st.setInt(1, i);//����1
				st.setString(2, name);//����2
				st.setString(3, id);//����3
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
				st.setString(1, name);//����1
				st.setString(2, id);//����2
				st.setString(3, "1");//����3
				st.setString(4, seller);
				st.executeUpdate();//��ΪҪ�������ݣ�������executeUpdate()
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
