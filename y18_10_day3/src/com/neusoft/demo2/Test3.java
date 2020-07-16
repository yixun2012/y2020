package com.neusoft.demo2;

import java.sql.*;

//用JDBC查询记录操作
public class Test3 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //第1步:加载数据库驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //第2步：创建数据库连接对象
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/y18_4",
                        "root","root");

        //第3步：创建简单语句对象
        Statement statement=connection.createStatement();
        ResultSet resultSet=statement.executeQuery("select * from stu");
        while(resultSet.next()){
           System.out.println(resultSet.getInt("id"));
           System.out.println(resultSet.getString("username"));
           System.out.println(resultSet.getString(3));
           System.out.println();
        }
        if(resultSet!=null){
            resultSet.close();
        }
        if(statement!=null){
            statement.close();
        }
        if(connection!=null&&connection.isClosed()==false){
            System.out.println("打开数据库y18_4成功");
            connection.close();
        }
   }
}
