package com;

import com.config.JdbcUtils;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;

public  class Test001 {
    public static void main(String[] args) {
        Connection conn = JdbcUtils.getConn();
        try {
            Statement statement = conn.createStatement();
            statement.execute("select * FROM users ");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
