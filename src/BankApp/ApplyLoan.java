package BankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankApp.Model;


public class ApplyLoan extends HttpServlet {
	HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		session=request.getSession();
		int acc_no=(int)session.getAttribute("accno");
		
		try {
			
			Model m= new Model();
			m.setAcc_no(acc_no);
            boolean b= m.applyLoan();
		    if(b==false)
		    {
		    	response.sendRedirect("/"+"BankApplication/applyLoanFailure.html");
		    }
		    else
		    {
		    session.setAttribute("name", m.getName());
		    session.setAttribute("email", m.getEmail());
		    response.sendRedirect("/"+"BankApplication/applyLoanSuccess.jsp");
		    }
		}
		catch (Exception e) {
		e.printStackTrace();
		}
	}

}
