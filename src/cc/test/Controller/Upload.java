package cc.test.Controller;

import java.io.*;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import javax.servlet.http.Part;

@MultipartConfig
public class Upload extends HttpServlet {
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		 // 处理中文名称
		request.setCharacterEncoding("UTF-8");
    	Part part=request.getPart("photo");//根据上传文件信息得到Par对象
		String filename = getFilename(part);
		writeTo(filename, part);
		
        HttpSession session=request.getSession();
		
		String id=request.getParameter("id");
		String bookname=request.getParameter("bookname");
		String price=request.getParameter("price");
		String sellprice=request.getParameter("sellprice");
		String number=request.getParameter("number");
		String seller=(String) session.getAttribute("username");
		String img="/ShopSys/img/"+filename;
	
		
		Connection conn;
		PreparedStatement st;
		ResultSet rs;
		
		
		try
		{
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb是数据库名称，root是msql密码和数据库密码
			st=conn.prepareStatement("select * from book where id=?");//SQL预编译
			st.setString(1, id);
			rs=st.executeQuery();
			if(!rs.next())//判断结果集是否为空
			{
				System.out.print("1111111111");
				String sql="insert into book(id,bookname,price,img) values(?,?,?,?)";
				st=conn.prepareStatement(sql);
				st.setString(1, id);//参数1
				st.setString(2, bookname);//参数2
				st.setString(3, price);//参数3
				st.setString(4, img);
				st.executeUpdate();//因为要插入数据，所以用executeUpdate()
				System.out.print("2222222222222");
			}
			String sql="insert into seller(name,id,price,number) values(?,?,?,?)";
			st=conn.prepareStatement(sql);
			st.setString(1, seller);//参数1
			st.setString(2, id);//参数2
			st.setString(3, sellprice);//参数3
			st.setString(4, number);
			st.executeUpdate();//因为要插入数据，所以用executeUpdate()
			System.out.print("33333333333333");
			rs.close();
			st.close();
			conn.close();
		} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
		} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		request.getRequestDispatcher("mail/log2.jsp").forward(request, response);
	}

	private String getFilename(Part part) {
	 // 取得上传文件名
		String header=part.getHeader("Content-Disposition");
		String filename=
				header.substring(header.indexOf("filename=\"")+10,header.lastIndexOf("\""));
		return filename;
	}
	
	private void writeTo(String filename, Part part) throws IOException,
			FileNotFoundException {
		InputStream in = part.getInputStream();
		String path = super.getServletContext().getRealPath("/img");
		OutputStream out = new FileOutputStream(path+"/"+ filename);
		byte[] buffer = new byte[1024];
		int length = -1;
		while ((length = in.read(buffer)) != -1) {
			out.write(buffer, 0, length);
		}
		in.close();
		out.close();
	}
}
