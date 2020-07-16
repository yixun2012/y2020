package com.neusoft.demo1;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

//测试数据库连接是否成功
public class Test1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //第1步:加载数据库驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //第2步：创建数据库连接对象
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/y18_4",
                        "root","root");
        if(connection!=null&&connection.isClosed()==false){
            System.out.println("打开数据库y18_4成功");
            connection.close();
        }else{
            System.out.println("打开数据库y18_4失败");
        }
   }
}
