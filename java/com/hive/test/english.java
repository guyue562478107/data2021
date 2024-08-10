package com.hive.test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class english {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        Class.forName("org.apache.hive.jdbc.HiveDriver");

        Connection connection = DriverManager.getConnection("jdbc:hive2://hd001:10000/test", "root", "123456");
        System.out.println(connection);
        String filePath = "/root/HeForShe.txt";
        String sql = "load data local inpath '" + filePath + "' overwrite into table test.original";
        PreparedStatement ps = connection.prepareStatement(sql);
        ps.execute();

        String sql2 ="insert overwrite table seperate select explode(split(str,',')) as word from original";
        PreparedStatement ps2 = connection.prepareStatement(sql2);
        ps2.execute();
    }
}
