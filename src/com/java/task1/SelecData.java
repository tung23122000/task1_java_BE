package com.java.task1;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;


public class SelecData {

  public void selectData() {
//   public void selectData(){
    Connection conn = ConnectData.getDataSql();

    try {
      Statement statement = conn.createStatement();

      final String sql = "SELECT*FROM student";
      ResultSet rs = statement.executeQuery(sql);
      while (rs.next()) {
        int MSV = rs.getInt("MSV");
        String Name = rs.getString("Name");
        String SDT = rs.getString("SDT");
        String DIEM = rs.getString("DIEM");
        System.out.println("\t" + MSV + "  \t" + Name + " \t" + SDT + " \t" + DIEM);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }


  public void SortData() throws SQLException {
    Connection conn = ConnectData.getDataSql();

    try {
      Statement statement = conn.createStatement();
      final String sql = "SELECT * from student order by DIEM ASC;";
      ResultSet rs = statement.executeQuery(sql);

      while (rs.next()) {
        int MSV = rs.getInt("MSV");
        String Name = rs.getString("Name");
        String SDT = rs.getString("SDT");
        Double DIEM = rs.getDouble("DIEM");

        System.out.println("\t\t" + MSV + "  \t\t" + Name + " \t\t" + SDT + " \t\t" + DIEM);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }


  public boolean addData(int nMSV, String nName, String nSDT, double nDIEM) {
    Connection conn = ConnectData.getDataSql();
    String sql = "INSERT into student(MSV, Name, SDT,DIEM ) values(?,?,?,?)";

    try {
      PreparedStatement preparedStatement = conn.prepareStatement(sql);
      preparedStatement.setInt(1, nMSV);
      preparedStatement.setString(2, nName);
      preparedStatement.setString(3, nSDT);
      preparedStatement.setDouble(4, nDIEM);
      return preparedStatement.executeUpdate() > 0;

    } catch (SQLException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
    return false;
  }

  public void searchData(String string) {
    Connection conn = ConnectData.getDataSql();
    try {
      Statement statement = conn.createStatement();
      final String sql = "SELECT * from student WHERE NAME LIKE '%"+string+"%';";
      ResultSet rs = statement.executeQuery(sql);

      while(rs.next()){

        int MSV = rs.getInt("MSV");
        String Name = rs.getString("Name");
        String SDT = rs.getString("SDT");
        Float DIEM = rs.getFloat("DIEM");
        System.out.println("\t\t" + MSV + "  \t\t" + Name + " \t\t" + SDT + " \t\t" + DIEM);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  public void MinMaxData(float min, float max) {
    Connection conn = ConnectData.getDataSql();
    try {
      Statement statement = conn.createStatement();
      final String sql = "SELECT * from student WHERE DIEM  BETWEEN "+ min+" AND "+max +";" ;
      ResultSet rs = statement.executeQuery(sql);

      while(rs.next()){
        int MSV = rs.getInt("MSV");
        String Name = rs.getString("Name");
        String SDT = rs.getString("SDT");
        Float DIEM = rs.getFloat("DIEM");
        System.out.println("\t\t" + MSV + "  \t\t" + Name + " \t\t" + SDT + " \t\t" + DIEM);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }

  }

  public static void main(String[] args) {
    SelecData selecData= new SelecData();
    selecData.MinMaxData(2.3f,3.2f);
  }


}
