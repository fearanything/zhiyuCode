package com.fh.proxool;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import java.sql.DriverManager;
import java.sql.SQLException;

/**
 * 此示例适用于 hibernate proxool 连接池
 * @date 2021/12/28 0028
 */
public class DbteServlet extends HttpServlet {

    public void init() throws ServletException {
        try {
            DriverManager.registerDriver(new DbteDriver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
