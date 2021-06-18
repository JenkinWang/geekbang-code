package com.geekbang.web.db;

import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.Connection;
import java.util.logging.Logger;

/**
 * @author <a href="mailto:jenkinsmile@gmail.com">JenkinWang</a>
 * @since 1.0.0
 */
public class DBConnectionManager {
    private final Logger logger = Logger.getLogger(DBConnectionManager.class.getName());

    @Resource(name = "jdbc/JNDIDataSource")
    private DataSource dataSource;

    public Connection getConnection() {
        Connection connection = null;

        try {
            connection = dataSource.getConnection();
        } catch (Exception e) {
            logger.info("获取数据库连接失败");
        }

        if (connection != null) {
            logger.info("获取数据库连接成功");
        }

        return connection;
    }
}
