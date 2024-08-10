package com.mysql.test;

import org.junit.Before;
import org.junit.Test;

import java.sql.*;

public class TestMysql {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("com.mysql.jdbc.Driver");
        Connection connection = DriverManager.getConnection("jdbc:mysql://hd001:3306/test","root","123456");

//        System.out.println(connection);
        PreparedStatement ps = connection.prepareStatement("select * from emp;");
        ResultSet rs = ps.executeQuery();
        while (rs.next()){
            int id = rs.getInt("id");
            String text = rs.getString("text");
            System.out.println(id+":"+text+":");
        }

    }
    Connection connection;
    @Before
    public  void testbefore() throws SQLException {
//        第一步  加载驱动类 进入 jvm
//        Class.forName("com.mysql.jdbc.Driver");


        connection= DriverManager.getConnection("jdbc:mysql://hd001:3306/test?useUnicode=true&characterEncoding=utf8", "root", "123456");



    }

    @Test
    public  void  test1() throws SQLException {


        PreparedStatement ps = connection.prepareStatement("select * from  emp where id=?");

        ps.setInt(1,2);
//  执行查询的语句
        ResultSet rs = ps.executeQuery();

        if(rs.next()){

            int id = rs.getInt("id");
            String text = rs.getString("text");


            System.out.println(id+":"+text+":");
        }else{
            rs.close();
        }





    }

}
