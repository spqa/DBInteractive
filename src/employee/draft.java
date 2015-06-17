/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author QuangAnh
 */
public class draft {

    int yob;
    static final String email = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
		+ "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

    public void input() throws IOException {
        InputStreamReader i = new InputStreamReader(System.in);
        BufferedReader b = new BufferedReader(i);
        System.out.println("Enter yob");
        this.yob = Integer.parseInt(b.readLine());
        System.out.println(yob);
    }

    public static void main(String[] args) throws IOException {
        System.out.println("Enter email:");
        Scanner sc=new Scanner(System.in);
        String email1=sc.nextLine();
        Pattern p = Pattern.compile(email);
        Matcher m = p.matcher(email1);
        System.out.println(m.matches());
    }
}
