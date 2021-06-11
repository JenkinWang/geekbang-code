package com.geekbang.web.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class CustomServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        System.out.println("do custom servlet service");

        /*PrintWriter printWriter = response.getWriter();
        printWriter.println("Custom servlet...");*/

        request.getRequestDispatcher("/index").forward(request, response);
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

