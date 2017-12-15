package com.bharath.selectpage.Utility;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DbUtil {
	public static Connection getConnection(){
			Connection con=null;
			if(con==null)
			{
			try {
				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				con=DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:orcl","system","bleach#1");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			}
			return con;
	}
}

