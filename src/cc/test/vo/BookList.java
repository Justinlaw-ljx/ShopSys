package cc.test.vo;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import javax.mail.Session;






public class BookList 
{
    public  List<Book> queryResult(String key) 
    {
    	   String url = "jdbc:mysql://localhost:3306/mvcdb";
    	   String user = "root";
    	   String password = "root";
    	   String DBDRIVER = "com.mysql.jdbc.Driver";
    	   List<Book> booklist=null;
    	   Connection conn=null;
   		   Statement stmt=null;
    	   try{      
    		      Class.forName("com.mysql.jdbc.Driver");
    		      }
    		   catch(ClassNotFoundException e){          
    		      }
    		      
    		   try{
    		         conn=DriverManager.getConnection(url,user,password);
    		         stmt=conn.createStatement();
    		         ResultSet rs=stmt.executeQuery("select * from book,seller where book.id=seller.id and (book.id like '%"+key+"%' or bookname like '%"+key+"%')"); 
    		         booklist = new ArrayList<Book>();
    		         while (rs.next())
    		         {
    		        	 Book book=new Book(rs.getString("book.id"),rs.getString("book.bookname"),rs.getDouble("book.price"),rs.getDouble("seller.price"),rs.getString("book.img"),rs.getString("seller.name"),rs.getInt("seller.number"));
    		        	 booklist.add(book);
    		         }
    		   }
               catch (Exception e)
               {
		              System.out.println("ËÑË÷Ê§°Ü");
		
               }
    		   finally
               {
       			
       			if (stmt!=null)
       			   try{
       				   stmt.close();
       				   
       			   }
       			   catch(SQLException e)
       			   {
       			   }
       			
       			if (conn!=null)
       				  try
       			      {
       					   conn.close();
       					   
       				   }catch(SQLException e){
       				   }
       		
       		}
    		return booklist;
		
	}
    public  List<Car> queryCarResult(String name) 
    {
    	   String url = "jdbc:mysql://localhost:3306/mvcdb";
    	   String user = "root";
    	   String password = "root";
    	   String DBDRIVER = "com.mysql.jdbc.Driver";
    	   List<Car> booklist=null;
    	   Connection conn=null;
   		   Statement stmt=null;      
    	   try{
    			     Class.forName("com.mysql.jdbc.Driver");
    		         conn=DriverManager.getConnection(url,user,password);
    		         stmt=conn.createStatement();
    		         ResultSet rs=stmt.executeQuery("select * from cart,book,seller where cart.name='"+name+"' and book.id=cart.id and seller.id=book.id and seller.name=cart.seller");
    		         booklist = new ArrayList<Car>();
    		         while (rs.next())
    		         {
    		        	 Car book=new Car(rs.getString("cart.id"),rs.getString("book.bookname"),rs.getString("book.img"),rs.getDouble("seller.price"),rs.getInt("cart.number"),rs.getString("seller.name"));
    		        	 booklist.add(book);
    		         }
    		   }
               catch (Exception e)
               {
		              System.out.println("ËÑË÷Ê§°Ü");
		
               }
    		   finally
               {
       			
       			if (stmt!=null)
       			   try{
       				   stmt.close();
       				   
       			   }
       			   catch(SQLException e)
       			   {
       			   }
       			
       			if (conn!=null)
       				  try
       			      {
       					   conn.close();
       					   
       				   }catch(SQLException e){
       				   }
       		
       		}
    		return booklist;
		
	}
    public  List<User> queryUserResult(String name) 
    {
    	   String url = "jdbc:mysql://localhost:3306/mvcdb";
    	   String user = "root";
    	   String password = "root";
    	   String DBDRIVER = "com.mysql.jdbc.Driver";
    	   List<User> Userlist=null;
    	   Connection conn=null;
   		   Statement stmt=null;
    	   try{      
    		      Class.forName("com.mysql.jdbc.Driver");
    		      }
    		   catch(ClassNotFoundException e){          
    		      }
    		      
    		   try{
    		         conn=DriverManager.getConnection(url,user,password);
    		         stmt=conn.createStatement();
    		         ResultSet rs=stmt.executeQuery("select * from user where name like '%"+name+"%'");
    		         Userlist = new ArrayList<User>();
    		         while (rs.next())
    		         {
    		        	 User User=new User(rs.getString("name"),rs.getString("password"),rs.getString("kind"));
    		        	 Userlist.add(User);
    		         }
    		   }
               catch (Exception e)
               {
		              System.out.println("ËÑË÷Ê§°Ü");
		
               }
    		   finally
               {
       			
       			if (stmt!=null)
       			   try{
       				   stmt.close();
       				   
       			   }
       			   catch(SQLException e)
       			   {
       			   }
       			
       			if (conn!=null)
       				  try
       			      {
       					   conn.close();
       					   
       				   }catch(SQLException e){
       				   }
       		
       		}
    		return Userlist;
		
	}
    public  List<Book> SearchByName(String name) 
    {
    	   String url = "jdbc:mysql://localhost:3306/mvcdb";
    	   String user = "root";
    	   String password = "root";
    	   String DBDRIVER = "com.mysql.jdbc.Driver";
    	   List<Book> booklist=null;
    	   Connection conn=null;
   		   Statement stmt=null;
    	   try{      
    		      Class.forName("com.mysql.jdbc.Driver");
    		      }
    		   catch(ClassNotFoundException e){          
    		      }
    		      
    		   try{
    		         conn=DriverManager.getConnection(url,user,password);
    		         stmt=conn.createStatement();
    		         ResultSet rs=stmt.executeQuery("select * from book,seller where book.id=seller.id and seller.name='"+name+"'"); 
    		         booklist = new ArrayList<Book>();
    		         while (rs.next())
    		         {
    		        	 Book book=new Book(rs.getString("book.id"),rs.getString("book.bookname"),rs.getDouble("book.price"),rs.getDouble("seller.price"),rs.getString("book.img"),rs.getString("seller.name"),rs.getInt("seller.number"));
    		        	 booklist.add(book);
    		         }
    		   }
               catch (Exception e)
               {
		              System.out.println("ËÑË÷Ê§°Ü");
		
               }
    		   finally
               {
       			
       			if (stmt!=null)
       			   try{
       				   stmt.close();
       				   
       			   }
       			   catch(SQLException e)
       			   {
       			   }
       			
       			if (conn!=null)
       				  try
       			      {
       					   conn.close();
       					   
       				   }catch(SQLException e){
       				   }
       		
       		}
    		return booklist;
		
	}
}
