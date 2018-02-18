package cc.test.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.test.vo.BookList;
import cc.test.vo.Car;

public class Order extends HttpServlet {

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
		List<Car> booklist=null;
		booklist=(List<Car>) session.getAttribute("Car");
		Connection conn;
		PreparedStatement st = null;
		ResultSet rs;
		String sql;
		

		try
		{
			Class.forName("com.mysql.jdbc.Driver");//��������
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb�����ݿ����ƣ�root��msql��������ݿ�����
			for(Car car:booklist)
			{
				st=conn.prepareStatement("select * from cart2 where name=? and id=? and seller=?");//SQLԤ����
				st.setString(1, (String) session.getAttribute("username"));//1��Ӧ���ݿ���һ���ֶΣ�2�Ļ����ǵڶ����ֶΣ�names��Ҫ��ѯ�Ĳ���
				st.setString(2, car.getBookId());
				st.setString(3,car.getSeller());
				rs=st.executeQuery();	
				if(rs.next())//�жϽ�����Ƿ�Ϊ��
				{
					int i=rs.getInt("number")+car.getNum();
					sql="update cart2 set number=? where name=? and id=? and seller=?";
					st=conn.prepareStatement(sql);
					st.setInt(1, i);//����1
					st.setString(2, (String) session.getAttribute("username"));//����2
					st.setString(3, car.getBookId());//����3
					st.setString(4,car.getSeller());
					st.executeUpdate();
				}
				else
				{
					sql="insert into cart2(name,id,number,seller) values(?,?,?,?)";
			         st=conn.prepareStatement(sql);
    		         st.setString(1, (String) session.getAttribute("username"));//����1
			         st.setString(2, car.getBookId());//����2
			         st.setInt(3, car.getNum());//����3 
			         st.setString(4,car.getSeller());
//			         System.out.print(session.getAttribute("username")+" "+car.getBookId()+" "+car.getNum()+" ");
			         st.executeUpdate();//��ΪҪ�������ݣ�������executeUpdate()
				}
			
			st=conn.prepareStatement("select number from seller where name=? and id=?");//SQLԤ����
			st.setString(1, car.getSeller());//1��Ӧ���ݿ���һ���ֶΣ�2�Ļ����ǵڶ����ֶΣ�names��Ҫ��ѯ�Ĳ���
			st.setString(2, car.getBookId());
			rs=st.executeQuery();
			
			if(rs.next())//�жϽ�����Ƿ�Ϊ��
			{	
			   sql="update seller set number=? where name=? and id=?";
			   st=conn.prepareStatement(sql);
			   int k=rs.getInt("number")-car.getNum();
			// System.out.print("k="+k);
			   st.setInt(1,k);//����1
			   st.setString(2, car.getSeller());//����2
			   st.setString(3, car.getBookId());//����3
			   st.executeUpdate();
			}
			
    		sql="delete from cart where name=? and id=? and seller=?";
			st=conn.prepareStatement(sql);
			st.setString(1, (String) session.getAttribute("username"));//����2
			st.setString(2, car.getBookId());//����3
			st.setString(3, car.getSeller());
			st.executeUpdate();
			}
		}
         catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		 request.getRequestDispatcher("/mail/order.jsp").forward(request, response); 
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
