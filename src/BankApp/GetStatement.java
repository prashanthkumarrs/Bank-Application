package BankApp;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankApp.Model;

public class GetStatement extends HttpServlet {
HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		int acc_no=(int)session.getAttribute("accno");
		
		try {
			Model m=new Model();
			m.setAcc_no(acc_no);
			
			ArrayList al=m.getStatement();
			if(al.isEmpty()==true)
			{
				response.sendRedirect("/"+"BankApplication/StatementFailure.html");
			}
			else
			{
				session.setAttribute("al1", m.al1);
				session.setAttribute("al2", m.al2);
				session.setAttribute("al3", m.al3);
				response.sendRedirect("/"+"BankApplication/StatementSuccess.jsp");
			}
		} 
		
		catch (Exception e) {
		e.printStackTrace();
		}

		
	}

}
