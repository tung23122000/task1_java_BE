package com.java.task1;

import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

public class Main {

  public static void main(String[] args) throws InterruptedException, SQLException {
    Scanner scanner = new Scanner(System.in);
    int input = 0;

    do{
      System.out.println("MENU: \n"
          + "1. Nhập vào danh sách sinh vien\n"
          + "2. Xem danh sách sinh vien \n"
          + "3. Xắp xếp danh sách sinh viên theo điểm tăng dần \n"
          + "4. Tìm kiếm sinh viên theo tên\n"
          + "5. Tìm kiếm sinh viên theo khoảng điểm min max\n"
          + "0. thoat khỏi chuong trinh ");

      input = scanner.nextInt();
      SelecData selecData= new SelecData();
      switch (input){
        case 1:

          System.out.println("bạn có muốn tiếp tục nhập danh sách sinh viên không Y/N?");
          scanner.nextLine();
          String string = scanner.nextLine();
          System.out.println(string);
          if(string.equalsIgnoreCase("y")) {
            System.out.println("\n nhập số lượng sinh viên muốn thêm: ");
            int slg = scanner.nextInt();

            for (int i = 0; i < slg; i++) {
              System.out.print("nhập vao mã sinh vien [" + (i + 1) + "]: ");
              int MSV = scanner.nextInt();
              scanner.nextLine();
              System.out.print("nhập vao ten sinh vien [" + (i + 1) + "]: ");
              String Name = scanner.nextLine();
              System.out.print("nhập vao sdt sinh vien [" + (i + 1) + "]: ");
              String SDT = scanner.nextLine();
              System.out.print("nhập vao diem sinh vien [" + (i + 1) + "]: ");
              double DIEM = scanner.nextDouble();

              selecData.addData(MSV, Name, SDT, DIEM);
            }
            System.out.println("nhâp thành công");
          }else if(string.equalsIgnoreCase("n")) break;
            else{
            System.out.println("nhập sai :");
            break;
          }
          break;

        case 2:
          System.out.println("hiển thị danh sách sv");
          SelecData selectData = new SelecData();
          System.out.println("\tMSV" +  "  \tName " +  " \tSDT" +   " \tDIEM"  );
          selectData.selectData();
            break;
        case 3:
          System.out.println("thực hiện sắp xếp rồi in ra màn hình:");
          SelecData selecData1 = new SelecData();
          System.out.println("\tMSV" +  "  \tName " +  " \tSDT" +   " \tDIEM"  );
          selecData1.SortData();
          break;
        case 4:
          System.out.print("nhập tên cần tìm kiếm: ");
          scanner.nextLine();
          String string1 = scanner.nextLine();
          System.out.println("Danh sách tìm kiếm");
          System.out.println("\tMSV" +  "  \tName " +  " \tSDT" +   " \tDIEM"  );
          selecData.searchData(string1);
          break;
        case 5:
          System.out.println("thực hiện tìm kiếm các sinh viên có điểm trong khoảng và in :");
          System.out.print("điểm thấp nhất: "); float min = scanner.nextFloat();
          System.out.print("điểm cao nhất: "); float max = scanner.nextFloat();
          System.out.println("\tMSV" +  "  \tName " +  " \tSDT" +   " \tDIEM"  );
          selecData.MinMaxData(min,max);
          break;
        case 0:
          System.out.println("chương trình kết thúc");
          break;
      }
    }while(input!=0);
  }
}
