package BankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankApp.Model;

public class transfer extends HttpServlet {
HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
       session=request.getSession();
		
		int acc_no=(int)session.getAttribute("accno");
		int acc_no1=Integer.parseInt(request.getParameter("accno"));
		int amt=Integer.parseInt(request.getParameter("amount"));
		
		
		try {
           		
			Model m=new Model();
			m.setAcc_no(acc_no);
			m.setAcc_no1(acc_no1);
			m.setAmount(amt);
			
			boolean b=m.transferAmt();
			
			if(b==true)
			{
				response.sendRedirect("/"+"BankApplication/transferSuccess.html");
				
			}
			
			else
			{
				response.sendRedirect("/"+"BankApplication/transferFailure.html");
			}
		}
		
		catch (Exception e) {
		e.printStackTrace();
		}
	}

}
