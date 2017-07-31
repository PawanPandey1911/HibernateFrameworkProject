package com.learnerslife;

import java.sql.*;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Insert {

	private String name;
	private String address;
	String about;
	BufferedReader ob = new BufferedReader(new InputStreamReader(System.in));

	public Insert() {
		System.out.println("Invoking Inserting Procedure");
	}

	public void insert(String user, String password) {

		try {
			setname();
			setaddress();
			setabout();

			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			final String url = "jdbc:sqlserver://localhost\\MSSQLSERVER";

			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			int a = st
					.executeUpdate("Insert Into dbo.EMP(EMP_NAME,EMP_ADDRESS,EMP_ABOUT)Values('"
							+ name + "','" + address + "','" + about + "')");
			System.out.println("a=" + a);
			con.close();
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Database Connection Failed Login Failed");
		}

	}

	public void setname() throws IOException {
		System.out.println("Enter Employee name");
		name = ob.readLine();
	}

	public void setaddress() throws IOException {
		System.out.println("Enter Employee address");
		address = ob.readLine();
	}

	public void setabout() throws IOException {
		System.out.println("Enter Designation of Employee");
		about = ob.readLine();
	}

}
