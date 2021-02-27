package BankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankApp.Model;

public class ChangePwd extends HttpServlet {
	HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		session=request.getSession();
		int acc_no=(int)session.getAttribute("accno");
		String npwd=request.getParameter("npwd");
		
		try {
			Model m=new Model();
			m.setAcc_no(acc_no);
			m.setPwd(npwd);
			boolean b=m.ChangePwd();
			
			if(b==true)
			{
				response.sendRedirect("/"+"BankApplication/changePwdSuccess.html");
			}
			else
			{
				response.sendRedirect("/"+"BankApplication/changePwdFailure.html");
			}
			
		}
		
		catch (Exception e) {
			e.printStackTrace();
		}
		
		
	}

}
