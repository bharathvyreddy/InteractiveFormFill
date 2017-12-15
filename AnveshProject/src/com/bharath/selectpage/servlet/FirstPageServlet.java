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

/**
 * Servlet implementation class FirstPageServlet
 */

public class FirstPageServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#service(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		PrintWriter out=response.getWriter();
		HttpSession session=request.getSession();
		int checkboxnumber=getcheckboxnumber(request.getParameter("checkbox1"),
											request.getParameter("checkbox2"),
											request.getParameter("checkbox3"),
											request.getParameter("checkbox4"));
		System.out.println(checkboxnumber);
		if(checkboxnumber<1) {
			RequestDispatcher rd=request.getRequestDispatcher("firstpage.jsp");
			out.println("Select atleast one option.(Not more than one)");
			rd.include(request, response);
		}
		else {
		String studentid=checkentry(request.getParameter("studentid1"),
									request.getParameter("studentid2"),
									request.getParameter("studentid3"),
									request.getParameter("studentid4"),
									checkboxnumber);
		String studentname=checkentry(request.getParameter("studentname1"),
									request.getParameter("studentname2"),
									request.getParameter("studentname3"),
									request.getParameter("studentname4"),
									checkboxnumber);
		String studentmajor=checkentry(request.getParameter("studentmajor1"),
										request.getParameter("studentmajor2"),
										request.getParameter("studentmajor3"),
										request.getParameter("studentmajor4"),
										checkboxnumber);
		String studentadvisor=checkentry(request.getParameter("studentadvisor1"),
										request.getParameter("studentadvisor2"),
										request.getParameter("studentadvisor3"),
										request.getParameter("studentadvisor4"),
										checkboxnumber);
		
		session.setAttribute("studentid", studentid);
		session.setAttribute("studentname", studentname);
		session.setAttribute("studentmajor", studentmajor);
		session.setAttribute("studentadvisor", studentadvisor);
		
		RequestDispatcher rd=request.getRequestDispatcher("secondpage.jsp");
		out.println("Please confirm the following entry:");
		rd.include(request, response);
		}
		
	}

	private int getcheckboxnumber(String checkbox1, String checkbox2, String checkbox3, String checkbox4) {
		
		int i=0;
		int checkboxnumber=0;
		if(!(checkbox1==null)) {
			checkboxnumber=1;
			i++;
		}
		if(!(checkbox2==null)) {
			checkboxnumber=2;
			i++;
		}
		if(!(checkbox3==null)) {
			checkboxnumber=3;
			i++;
		}
		if(!(checkbox4==null)) {
			checkboxnumber=4;
			i++;
		}
		
		if(i>1) {
		return 0;
		}else {
			return checkboxnumber;
		}
	}

	private String checkentry(String studententry1, String studententry2, String studententry3, String studententry4,
			int checkboxnumber) {
	
		String[] users = {studententry1,studententry2,studententry3,studententry4};
		return users[(checkboxnumber-1)];
	
	}

}
