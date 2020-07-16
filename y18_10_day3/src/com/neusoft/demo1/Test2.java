package com.neusoft.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//用JDBC插入记录操作
public class Test2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //第1步:加载数据库驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //第2步：创建数据库连接对象
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/y18_4",
                        "root","root");
        connection.setAutoCommit(false);
        //第3步：创建简单语句对象
        Statement statement=connection.createStatement();
        int row=statement.
                executeUpdate
                        ("insert into stu values(null,'guo2','hrb2')");
        connection.commit();
        System.out.println(row);
        if(statement!=null){
            statement.close();
        }
        if(connection!=null&&connection.isClosed()==false){
            System.out.println("打开数据库y18_4成功");
            connection.close();
        }
   }
}
