package beanpack;
import java.sql.*;
public class dbBean 
{
	Connection conn;
	PreparedStatement st;
	ResultSet rs;
	String names,kinds;
	
	public boolean dbBean(String name,String pwd,String kind) throws ClassNotFoundException, SQLException{
		names=name;
		kinds=kind;
			Class.forName("com.mysql.jdbc.Driver");//加载驱动
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb是数据库名称，root是msql密码和数据库密码
			st=conn.prepareStatement("select * from user where name=? and kind=?");//SQL预编译
			st.setString(1, names);//1对应数据库表第一个字段，2的话就是第二个字段，names是要查询的参数
			st.setString(2, kinds);
			rs=st.executeQuery();//执行查询语句返回结果集
			if(rs.next())//判断结果集是否为空
			{
				rs.close();
				st.close();
				conn.close();
				return false;	
			}
			else
			{
				String sql="insert into user(name,password,kind) values(?,?,?)";
				st=conn.prepareStatement(sql);
				st.setString(1, names);//参数1
				st.setString(2, pwd);//参数2
				st.setString(3, kinds);//参数3
				System.out.print("2:"+kinds);
				int i=st.executeUpdate();//因为要插入数据，所以用executeUpdate()
				if(i<1)
				{
					rs.close();
					st.close();
					conn.close();
					return false;
				}
				else
				{
					rs.close();
					st.close();
					conn.close();
					return true;
				}
			}
	
		
	}

}
