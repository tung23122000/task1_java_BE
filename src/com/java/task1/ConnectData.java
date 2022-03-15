package com.java.task1;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectData  {

  public static Connection getDataSql(){
    final  String url = "jdbc:mysql://localhost:3306/students";
    final String user="root";
    final String password  ="tung002312";
    try {
      Class.forName("com.mysql.cj.jdbc.Driver");
      return DriverManager.getConnection(url,user,password);
    } catch (ClassNotFoundException e) {
      e.printStackTrace();
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return null;
  }
}
