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
			Class.forName("com.mysql.jdbc.Driver");//��������
			conn=DriverManager.getConnection("jdbc:mysql:///mvcdb","root","root");//mvcdb�����ݿ����ƣ�root��msql��������ݿ�����
			st=conn.prepareStatement("select * from user where name=? and kind=?");//SQLԤ����
			st.setString(1, names);//1��Ӧ���ݿ���һ���ֶΣ�2�Ļ����ǵڶ����ֶΣ�names��Ҫ��ѯ�Ĳ���
			st.setString(2, kinds);
			rs=st.executeQuery();//ִ�в�ѯ��䷵�ؽ����
			if(rs.next())//�жϽ�����Ƿ�Ϊ��
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
				st.setString(1, names);//����1
				st.setString(2, pwd);//����2
				st.setString(3, kinds);//����3
				System.out.print("2:"+kinds);
				int i=st.executeUpdate();//��ΪҪ�������ݣ�������executeUpdate()
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
