/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author QuangAnh
 */
public class EmployeeTest {

    List<Employee> emp;
    Locale locale=Locale.US;

    public Locale getLocale() {
        return locale;
    }

    public void input() throws IOException {
        emp = new ArrayList<>();
        for (int i = 0; i < 2; i++) {
            System.out.println("===============");
            System.out.println("Enter Employee number " + (i + 1) + ":");
            Employee e = new Employee();
            e.input();
            emp.add(e);
        }
    }

    public void display() {
        for (int i = 0; i < 2; i++) {
            emp.get(i).display();
        }
    }

    public void WriteToFile() throws IOException {
        try {
            try (ObjectOutputStream o = new ObjectOutputStream(new FileOutputStream("employee.data"))) {
                o.writeObject(emp);
            }
        } catch (FileNotFoundException ex) {
            System.out.println("File not found");
        }
    }

    public void ReadFromFile() throws FileNotFoundException, IOException, ClassNotFoundException {
        FileInputStream f = new FileInputStream("employee.data");
        try (ObjectInputStream o = new ObjectInputStream(f)) {
            List<Employee> em = (List<Employee>) o.readObject();
            for (int i = 0; i < 2; i++) {
                em.get(i).display();
            }
        }
    }

    public void changeLanguage() {
        System.out.println("Choose Language:");
        System.out.println("1. Tiếng Việt");
        System.out.println("2. English");
        Scanner sc = new Scanner(System.in);
        int choice = sc.nextInt();
        switch (choice) {
            case 1:locale=new Locale("vi","VN");break;
            case 2:locale=new Locale("en","US");break;
        }
    }
    //database
    SingleDBConn s=new SingleDBConn();
    PreparedStatement pre=null;
    String sql_add="insert into `empTable`(`name`,`address`,`phone`,`email`,`yob`) values (?,?,?,?,?)";
    public void WriteToDB(){
        try {
            pre=s.getConn().prepareStatement(sql_add);
            for (Employee emp1 : emp) {
                pre.setString(1, emp1.getName());
                pre.setString(2, emp1.getAddress());
                pre.setString(3, emp1.getPhoneNo());
                pre.setString(4, emp1.getEmail());
                pre.setInt(5, emp1.getYob());
                pre.addBatch();
            }
            pre.executeBatch();
            System.out.println("Complete!");
        } catch (SQLException ex) {
            System.out.println("SQL Err!");
        }catch(NullPointerException n){
            System.out.println("Ban phai nhap trc ghi ,hien thoi mang ko du lieu");
        }
    }
    String sql_read="Select * from `empTable` where 1";
    ResultSet result=null;
    public void ReadFromDB(){
        try {
            result=pre.executeQuery(sql_read);
            while(result.next()){
                System.out.println(result.getInt("id")+"-"+result.getString("name")+"-"+result.getString("address")+"-"
                +result.getString("phone")+"-"+result.getString("email")+"-"+result.getInt("yob")
                );
            }
        } catch (SQLException ex) {
            System.err.println("Cant Read");
        }catch(NullPointerException n){
            System.out.println("ko co du lieu");
        }
        
    }
}
