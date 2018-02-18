package servletPack;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import beanpack.dbBean;

public class Rigst extends HttpServlet {

	private static final long serialVersionUID = 1L;

	
	String name;
	String pwd;
	String kind;
	dbBean db;
	boolean bool=false;
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
         name=request.getParameter("username");
         pwd=request.getParameter("pwd");
         kind=request.getParameter("Item");
         System.out.println("name---  "+name);
           try {
        	   db=new dbBean();
		     bool=db.dbBean(name, pwd, kind);
			if(bool==false){
				response.sendRedirect("/secondWeb/mail/unrigst.jsp");
			}
			else if(bool==true){
			response.sendRedirect("/secondWeb/mail/rigst.jsp");}
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

	doGet(request,response);
	}

}
