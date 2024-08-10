package com.hive.test;

import org.junit.Test;

import java.sql.*;

public class Testhive {
//测试用的main 以及测试用的sql语句
    public static void main(String[] args)

      throws ClassNotFoundException, SQLException {

        Class.forName("org.apache.hive.jdbc.HiveDriver");

        Connection connection = DriverManager.getConnection("jdbc:hive2://hd001:10000/test", "root", "123456");
            System.out.println(connection);


        PreparedStatement ps = connection.prepareStatement("select recommend_time,views,title,tags from datatable where recommend_time = ?");
        ps.setString(1, "13.09");
        ResultSet rs = ps.executeQuery();

        while (rs.next()){

            String recommend_time = rs.getString("recommend_time");
            float views = rs.getFloat("views");
            String title = rs.getString("title");
            String tags = rs.getString("tags");
            System.out.println(recommend_time+" "+views+" "+ title+ " "+tags+" ");
        }



    }
    @Test
    public  void  testLoadData() throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");

        Connection conn = DriverManager.getConnection("jdbc:hive2://hd001:10000/hive01", "root", "123456");

        PreparedStatement ps = conn.prepareStatement("select title,recommend_time,comment_count ,channel_title from test.datatable where recommend_time = ?");
        ps.setString(1, "26.09");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            String title = rs.getString("title");
            String recommend_time = rs.getString("recommend_time");
            float comment_count = rs.getFloat("comment_count");
            String channel_title = rs.getString("channel_title");

            System.out.println(title+" "+recommend_time+" "+ comment_count+ " "+channel_title+" ");
        }


    }




}
