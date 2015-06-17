/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Serializable;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author QuangAnh
 */
public class Employee implements Serializable{

    private String name;
    private int yob;
    private String address;
    private String phoneNo;
    private String email;
    static final String phone_regex = "^[0-9]{4}.[0-9]{3}.[0-9]{3}$";
    static final String email_regex="^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public Employee() {
    }

    public Employee(String name, int yob, String address, String phoneNo, String email) {
        this.name = name;
        this.yob = yob;
        this.address = address;
        this.phoneNo = phoneNo;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getYob() {
        return yob;
    }

    public void setYob(int yob) {
        this.yob = yob;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNo() {
        return phoneNo;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void input() throws IOException {
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(i);
        boolean isPhoneValid = false;
        boolean isYobValid = false;
        boolean isEmailValid=false;
        
        System.out.println("Enter name:");
        this.name = b.readLine();
        
        while (isYobValid == false) {
            try {
                System.out.println("Enter Yob");
                this.yob = Integer.parseInt(b.readLine());
                isYobValid = true;
            } catch (Exception ex) {
                System.out.println("Ban da nhap sai!! Hay nhap lai!");
               
            }
            
        }
        System.out.println("Enter Address");
        this.address = b.readLine();
        
        while (isPhoneValid == false) {
            System.out.println("Enter Phone Number");
            this.phoneNo = b.readLine();
            Pattern p = Pattern.compile(phone_regex);
            Matcher m = p.matcher(this.phoneNo);
            if (m.matches()) {
                isPhoneValid = true;
            }
        }
        
        while(isEmailValid==false){
        System.out.println("Enter Email");
        this.email = b.readLine();
        Pattern pe=Pattern.compile(email_regex);
        Matcher ma=pe.matcher(this.email);
        if(ma.matches()){
        isEmailValid=true;
        }
    }
    }
    public void display(){
        System.out.println("========================");
        System.out.println("Name:"+this.name);
        System.out.println("Phone:"+this.phoneNo);
        System.out.println("Address:"+this.address);
        System.out.println("Email:"+this.email);
        System.out.println("Yob:"+this.yob);
    }
}
