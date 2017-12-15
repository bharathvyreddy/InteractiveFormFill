package com.bharath.selectpage.student;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import com.bharath.selectpage.Utility.DbUtil;



public class StudentDAO {
	public boolean insertRecord(Student student) {
	Connection con=DbUtil.getConnection();
	int execute=0;
	String sql="insert into studentanvesh(studentid,studentname,studentmajor,studentadvisor) values(?,?,?,?)";
	try {
		PreparedStatement ps= con.prepareStatement(sql);
		ps.setString(1, student.getStudentid());
		ps.setString(2, student.getStudentname());
		ps.setString(3, student.getStudentmajor());
		ps.setString(4, student.getStudentadvisor());
		execute=ps.executeUpdate();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	}
	if(execute==1)
	{
		return true;
	}
	else
	{
		return false;
	}
	}
}
