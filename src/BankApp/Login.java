package BankApp;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import BankApp.Model;

public class Login extends HttpServlet {
	private static final long serialVersionUID = 1L;

	HttpSession session;
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


		String cust_id=request.getParameter("cusid");
		String pwd=request.getParameter("pwd");
		session=request.getSession(true);
try {
			
			Model m=new Model();
			m.setCust_id(cust_id);
			m.setPwd(pwd);
		    boolean b=m.login();
		    if(b==false) {
			
		  		    	response.sendRedirect("/"+"BankApplication/loginFailure.html");
		    }
		    else
		    {
		    	session.setAttribute("accno",m.getAcc_no());
		    	response.sendRedirect("/"+"BankApplication/Home.html");
		    	
		    }
		} 
		catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
	}

}
