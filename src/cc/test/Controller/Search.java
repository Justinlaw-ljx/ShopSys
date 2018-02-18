package cc.test.Controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.*;
import java.util.Iterator;
import java.util.List;


import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import cc.test.vo.Book;
import cc.test.vo.BookList;

public class Search extends HttpServlet {

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
			throws ServletException, IOException 
	{
        String search=request.getParameter("search");
		search=new String(search.getBytes("iso-8859-1"),"utf-8");
		System.out.print(search);
		
		List<Book> booklist=null;
		BookList book=new BookList();
		booklist=book.queryResult(search);
		
		HttpSession session=request.getSession();
	    session.setAttribute("Search", booklist);
	    session.setAttribute("search", search);

		
		
		request.getRequestDispatcher("/mail/search.jsp").forward(request, response); 
		
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
