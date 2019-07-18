package com.config;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.apache.commons.dbcp.BasicDataSourceFactory;

public class JdbcUtils {
    private JdbcUtils() {};
    private static Properties ppt =null;
    private static DataSource dataSource =null;
    static {
        try {
            ppt = new Properties();
            ppt.load(JdbcUtils.class.getClassLoader().getResourceAsStream("c3p0.properties"));
            //创建一个数据源工厂
            BasicDataSourceFactory data = new BasicDataSourceFactory();
            dataSource = data.createDataSource(ppt);//连接池（数据源）

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    /**
     * 获取数据源
     * @return 数据源（连接池）
     */
    public DataSource getDataSource() {
        return dataSource;
    }
    /**
     * 获取连接对象
     * @return 返回连接对象
     * @throws SQLException
     */
    public static Connection getConn() {
        try {
            return dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     * 关流
     */
    public static void closeStream(Connection conn, Statement st, ResultSet rs) {
        if(conn!= null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }finally {
                if(st!=null) {
                    try {
                        st.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }finally {
                        if(rs!=null) {
                            try {
                                rs.close();
                            } catch (SQLException e) {
                                e.printStackTrace();
                            }
                        }
                    }
                }
            }
        }
    }
}
