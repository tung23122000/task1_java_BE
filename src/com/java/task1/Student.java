package com.java.task1;

public class Student {
  private  String MSV;
  private String Name;
  private long numbers;
  private double Diemtb;

  public Student(String MSV, String name, long numbers, double diemtb) {
    this.MSV = MSV;
    Name = name;
    this.numbers = numbers;
    Diemtb = diemtb;
  }

  public String getMSV() {
    return MSV;
  }

  public void setMSV(String MSV) {
    this.MSV = MSV;
  }

  public String getName() {
    return Name;
  }

  public void setName(String name) {
    Name = name;
  }

  public long getNumbers() {
    return numbers;
  }

  public void setNumbers(long numbers) {
    this.numbers = numbers;
  }

  public double getDiemtb() {
    return Diemtb;
  }

  public void setDiemtb(double diemtb) {
    Diemtb = diemtb;
  }
}
