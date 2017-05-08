package com.test.web.testservlet;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.test.model.test.TestVo;

public class TestServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public TestServlet() {
        super();
    }

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String page = request.getParameter("page");
		String nextUrl = null;
		if(page == null)
			nextUrl = showInitialPage(request);
		 
		RequestDispatcher rd = request.getRequestDispatcher(nextUrl);
		rd.forward(request, response);
	}

	private String showInitialPage(HttpServletRequest request) {
		try {
			TestServletBe be = new TestServletBe();
			TestVo testVo = be.select(1);
			
			request.setAttribute("testVo", testVo);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return "/test/index.jsp";
	}
}
