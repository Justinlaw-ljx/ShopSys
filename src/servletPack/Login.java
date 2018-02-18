package servletPack;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import beanpack.LoginSearch;

public class Login extends HttpServlet {

	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		request.setCharacterEncoding("UTF-8");
		 response.setContentType("text/html;charset=UTF-8");
		    String ucode = request.getParameter("code");
	        HttpSession ses = request.getSession();
	        String scode = (String)ses.getAttribute("safecode").toString();
		
			String name=request.getParameter("username");
			String password=request.getParameter("pwd");
			String kind=request.getParameter("Item");
			LoginSearch logsearch=new LoginSearch();
			try {
				boolean bool=logsearch.loginsearch(name,password,kind);
				if(bool==true)
				{
					HttpSession session=request.getSession();
					session.setAttribute("username", name);
					if(ucode.equals(scode))
					{
					if(kind.equals("0"))
					{
					    request.getRequestDispatcher("Login1").forward(request, response);
					}
					else if(kind.equals("1"))
					{
						request.getRequestDispatcher("Login2").forward(request, response);
					}
					else
					{
						request.getRequestDispatcher("Admin").forward(request, response);
					}
					}
					else 
		            {
						request.setAttribute("message", "ÑéÖ¤Âë´íÎó");
						request.getRequestDispatcher("/mail/unlog.jsp").forward(request, response);
		            }
			
				}
				else
					{request.setAttribute("message", "fail to login : "+name);
				request.getRequestDispatcher("/mail/unlog.jsp").forward(request, response);}
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
