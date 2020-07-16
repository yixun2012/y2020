package com.neusoft.demo2;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//PreparedStatement  insert
public class Test5 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //第1步:加载数据库驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //第2步：创建数据库连接对象
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/y18_4",
                        "root","root");
        connection.setAutoCommit(false);
        //第3步：创建预编译语句对象
        PreparedStatement preparedStatement=connection.prepareStatement("insert into stu values(null,?,?)");
        String username="wht";
        String address="hrb4";
        preparedStatement.setString(1,username);
        preparedStatement.setString(2,address);
        int row=preparedStatement.executeUpdate();
        System.out.println(row);
        connection.commit();
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(connection!=null&&connection.isClosed()==false){
            System.out.println("打开数据库y18_4成功");
            connection.close();
        }
   }
}
