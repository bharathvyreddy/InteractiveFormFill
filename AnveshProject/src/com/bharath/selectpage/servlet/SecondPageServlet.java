package com.bharath.selectpage.servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.bharath.selectpage.student.Student;
import com.bharath.selectpage.student.StudentDAO;

/**
 * Servlet implementation class SecondPageServlet
 */
@WebServlet("/SecondPageServlet")
public class SecondPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();	
		String select=request.getParameter("confirm");
		if(select.equals("No")) 
		{
			RequestDispatcher rd=request.getRequestDispatcher("firstpage.jsp");
			out.println("Please insert new record");
			rd.include(request, response);
		}
		else {
		String studentid=(String) session.getAttribute("studentid");
		String studentname=(String) session.getAttribute("studentname");
		String studentmajor=(String) session.getAttribute("studentmajor");
		String studentadvisor=(String) session.getAttribute("studentadvisor");
		Student student=new Student();
		student.setStudentid(studentid);
		student.setStudentname(studentname);
		student.setStudentmajor(studentmajor);
		student.setStudentadvisor(studentadvisor);
		StudentDAO dao=new StudentDAO();
		if(dao.insertRecord(student)) {
			RequestDispatcher rd=request.getRequestDispatcher("success.jsp");
			out.println("Record Inserted Successfully");
			rd.include(request, response);
			}
		}
	}

}
