/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ResourceBundle;
import java.util.Scanner;

/**
 *
 * @author QuangAnh
 */
public class Main {
    public static void main(String[] args) throws IOException, FileNotFoundException, ClassNotFoundException {
        EmployeeTest t=new EmployeeTest();
        int choice;
        ResourceBundle r;
        while(true){
            r=ResourceBundle.getBundle("employee.language",t.getLocale());
            System.out.println("=========Menu========");
            System.out.println("1. "+r.getString("Input"));
            System.out.println("2. "+r.getString("Display"));
            System.out.println("3. "+r.getString("Write")+" "+r.getString("To")+" "+r.getString("File"));
            System.out.println("4. "+r.getString("Read")+" "+r.getString("From")+" "+r.getString("File"));
            System.out.println("5. "+r.getString("Change")+" "+r.getString("Language"));
            System.out.println("6. "+r.getString("WriteToDatabase"));
            System.out.println("7. "+r.getString("ReadFromDatabase"));
            System.out.println("8. "+r.getString("Exit"));
            System.out.println("== "+r.getString("Choice")+" ==");
            Scanner sc=new Scanner(System.in);
            choice=sc.nextInt();
            switch(choice){
                case 1:t.input();break;
                case 2:t.display();break;
                case 3:t.WriteToFile();break;
                case 4:t.ReadFromFile();break;
                case 5:t.changeLanguage();break;
                case 6:t.WriteToDB();break;
                case 7:t.ReadFromDB();break;
                case 8:System.exit(0);
            }
        }
    }
}
