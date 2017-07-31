package com.learnerslife;


import java.sql.*;

public class Display {


	public Display() {
		// TODO Auto-generated constructor stub
		System.out.println("Invoking Display procedure");
	}

	public void display(String user, String password) {
		try {
			
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
			final String url = "jdbc:sqlserver://localhost\\MSSQLSERVER";
			Connection con = DriverManager.getConnection(url, user, password);
			Statement st = con.createStatement();

			ResultSet rs = st.executeQuery("Select * from dbo.EMP;");
			while (rs.next()) {
				System.out.println("NAME:" + rs.getString("EMP_NAME"));
				System.out.println("DESIGNATION:" + rs.getString("EMP_ABOUT"));
				System.out.println("ADDRESS:" + rs.getString("EMP_ADDRESS")+"\n\n\n");
			}
			con.close();
			st.close();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Database connection failed.Please Try Later");
		}
	}

}
