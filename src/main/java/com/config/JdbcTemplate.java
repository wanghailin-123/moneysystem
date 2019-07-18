package com.config;

import java.lang.reflect.Field;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



/**
 * 增删改查通用模板
 * @author wdb
 *
 */
public class JdbcTemplate <T>{
    private JdbcTemplate() {}

    /**
     *
     *  DML 操作模板
     *
     *  */
    public static void update(String sql,Object...args) {
        Connection conn = null;
        PreparedStatement st =null;
        try {
            conn=JdbcUtils.getConn();
            st = conn.prepareStatement(sql);
            for(int i=0;i<args.length;i++) {
                st.setObject(i+1, args[i]);
            }
            st.executeUpdate();
        }catch(Exception e) {
            e.printStackTrace();
        }finally {
            JdbcUtils.closeStream(conn, st, null);
        }
    }
    public  List<Object> query(String sql,Object o,Object...args) {
        Connection conn = null;
        PreparedStatement st = null;
        ResultSet rs = null;
        try {
            conn=JdbcUtils.getConn();

            st= conn.prepareStatement(sql);
            //设置参数完毕
            for(int i=0;i<args.length;i++) {
                st.setObject(i+1, args[i]);
            }
            rs = st.executeQuery();
            ArrayList<T> list = new ArrayList<T>();
            return resultDemo(rs, o);

        }catch(Exception e) {
            e.printStackTrace();
        }finally{
            JdbcUtils.closeStream(conn, st, rs);
        }
        return null;
    }
    public static List<Object> resultDemo(ResultSet rs,Object o) throws Exception {
        ArrayList<Object> list = new ArrayList<Object>();
        while(rs.next()) {
            //可以获取指定表中每一列的列名
            ResultSetMetaData metaData = rs.getMetaData();
            int count = metaData.getColumnCount();//获取当前表的列个数
            Class clazz = o.getClass();
            Object newInstance = clazz.newInstance();//通过无参构造创建对象
            for(int i=1;i<=count;i++) {
                String columnName = metaData.getColumnName(i);
                /**
                 * 反射
                 */
                Field f = clazz.getDeclaredField(columnName);
                f.setAccessible(true);//破除私有
                if(rs.getObject(i)!=null) {
                    f.set(newInstance, rs.getObject(i));
                }
            }
            list.add(newInstance);
        }
        return list;
    }
}

