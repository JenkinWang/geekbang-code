package com.geekbang.servlet;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
@WebServlet()
public class CustomServlet extends HttpServlet {
	@Override
	protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

		System.out.println("do custom servlet service");
	}

	@Override
	public void destroy() {
		System.out.println("do custom servlet destroy...");
	}

	@Override
	public void init() throws ServletException {
		System.out.println("do custom servlet init...");
	}
}

