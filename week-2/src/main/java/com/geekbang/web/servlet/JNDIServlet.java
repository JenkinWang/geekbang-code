package com.geekbang.web.servlet;


import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class JNDIServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        PrintWriter printWriter = response.getWriter();
        Connection connection = null;
        try {
            connection = getConnection();
        } catch (Exception e) {
            e.printStackTrace();
        }

        if (connection == null) {
            printWriter.println("获取 JDBC 连接失败");
        } else {
            printWriter.println("获取 JDBC 连接成功");

            try {
                // 释放连接
                connection.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
    }

    private Connection getConnection() throws NamingException, SQLException {
        Context initialContext = new InitialContext();
        Context context = (Context) initialContext.lookup("java:comp/env");
        DataSource dataSource = (DataSource) context.lookup("jdbc/JNDIDataSource");
        return dataSource.getConnection();
    }
}