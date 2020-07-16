package com.neusoft.demo2;

import java.sql.*;

//PreparedStatement select
public class Test6 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
         //第1步:加载数据库驱动程序
        Class.forName("com.mysql.jdbc.Driver");
        //第2步：创建数据库连接对象
        Connection connection= DriverManager
                .getConnection("jdbc:mysql://localhost:3306/y18_4",
                        "root","root");

        //第3步：创建预编译语句对象
        PreparedStatement preparedStatement=connection.prepareStatement("select * from stu where id<=?");
        preparedStatement.setInt(1,10);
        ResultSet resultSet=preparedStatement.executeQuery();
        while(resultSet.next()){
            System.out.println(resultSet.getInt("id"));
            System.out.println(resultSet.getString("username"));
            System.out.println(resultSet.getString(3));
            System.out.println();
        }
        if(resultSet!=null){
            resultSet.close();
        }
        if(preparedStatement!=null){
            preparedStatement.close();
        }
        if(connection!=null&&connection.isClosed()==false){
            System.out.println("打开数据库y18_4成功");
            connection.close();
        }
   }
}
