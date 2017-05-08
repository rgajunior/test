package com.test.web.testservlet;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String nextUrl = null;
		if(page == null)
			nextUrl = showInitialPage();
		 
		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
	}

	private String showInitialPage() {
		return "/test/index.jsp";
	}
}
