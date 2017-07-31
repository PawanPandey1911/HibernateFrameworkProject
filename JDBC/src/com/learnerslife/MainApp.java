package com.learnerslife;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;

public class MainApp {
	

	public static void main(String[] args) throws IOException {

		// System.out.println("Hello");
		// TODO Auto-generated method stub
		// Program to insert employee in database
		// Program to show employee details in database
		BufferedReader ob = new BufferedReader(new InputStreamReader(
				System.in));
		short ch = 1;
		String url = "jdbc:sqlserver://localhost\\MSSQLSERVER";
		System.out.println("WELCOME TO LEARNERS LIFE EMPLOYEE DATABASE");
		String user=setuser(ob);
		String password=setpassword(ob);
		try {
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			

			Connection con = DriverManager.getConnection(url, user, password);
			con.close();
		} catch (Exception e) {
			System.out.println("Login failed");

		}
		while (ch > 0) {
			System.out
					.println("Enter \n 1 :To Insert employee details\n 2 :To display employee list \n 0 :Exit Program and Logout Database");
			ch = (short) Integer.parseInt(ob.readLine());
			switch (ch) {
			case 0:
				break;
			case 1:
				Insert a = new Insert();
				a.insert(user, password);
				a = null;
				break;
			case 2:
				Display b = new Display();
				b.display(user, password);
				break;
			default:
				System.out.println("Enter correct choice\n");

			}
		}

	}

	public static String setuser(BufferedReader ob) throws IOException {

		System.out.println("Enter Database Username");
		return(ob.readLine());
	}

	public static String setpassword(BufferedReader ob) throws IOException {
		System.out.println("Enter Database Password");
		return(ob.readLine());
	}

}
