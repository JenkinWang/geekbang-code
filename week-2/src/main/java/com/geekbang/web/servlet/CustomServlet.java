package com.geekbang.web.servlet;


import com.geekbang.web.db.DBConnectionManager;

import javax.annotation.Resource;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class CustomServlet extends HttpServlet {

    @Resource(name = "jdbc/DBDataSourceManager")
    private DBConnectionManager dbConnectionManager;

    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        System.out.println("------------- custom servlet -------------");

        PrintWriter printWriter = response.getWriter();
        Connection connection = null;
        try {
            getConnection();
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

    private Connection getConnection() {
        return dbConnectionManager.getConnection();
    }
}