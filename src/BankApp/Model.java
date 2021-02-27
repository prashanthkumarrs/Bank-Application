package BankApp;

import java.sql.*;
import java.util.ArrayList;

import oracle.jdbc.OracleDriver;

public class Model {

	String name;
	String cust_id;
	int acc_no;
	int acc_no1;
	float amount;
	float bal;
	String email;
	String pwd;
	public ArrayList al1=new ArrayList();
	public ArrayList al2=new ArrayList();
	public ArrayList al3=new ArrayList();
	
	private String url="jdbc:oracle:thin:@//localhost:1521/XE";
	private String user="SYSTEM";
	private String password="oracle";
	private Connection con;
	private PreparedStatement pstmt;
	private ResultSet res;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCust_id() {
		return cust_id;
	}
	public void setCust_id(String cust_id) {
		this.cust_id = cust_id;
	}
	public int getAcc_no() {
		return acc_no;
	}
	public int getAcc_no1() {
		return acc_no1;
	}
	public float getAmount() {
		return amount;
	}
	public void setAmount(float amount) {
		this.amount = amount;
	}
	public void setAcc_no1(int acc_no1) {
		this.acc_no1 = acc_no1;
	}
	public void setAcc_no(int acc_no) {
		this.acc_no = acc_no;
	}
	public float getBal() {
		return bal;
	}
	public void setBal(float bal) {
		this.bal = bal;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPwd() {
		return pwd;
	}
	public void setPwd(String pwd) {
		this.pwd = pwd;
	}
	
	public Model() throws Exception
	{
		DriverManager.registerDriver(new OracleDriver());
		con=DriverManager.getConnection(url, user, password);
	}
	
	public boolean balance() throws Exception
	{
		String s="select balance from BankDB where accno=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1, acc_no);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			bal=res.getInt(1);
	
			return true;
		}
		return false;
		
	}
	
	public boolean applyLoan() throws Exception
	{
		String s="select * from BankDB where accno=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1, acc_no);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			name=res.getString(1);
			email=res.getString(6);
			return true;
		}
		
		return false;
	}
	
	public boolean ChangePwd()throws Exception
	{
	    String s="update bankdb set pwd=? where accno=? ";
	    pstmt=con.prepareStatement(s);
	    pstmt.setString(1, pwd);
	    pstmt.setInt(2, acc_no);
	    int x=pstmt.executeUpdate();
	    if(x==1)
	    {
	     return true;	
	    }
	    else
	    {
	 return false;
	    }
	}
	
	
	public ArrayList getStatement() throws Exception
	{
		String s="select * from getstatement where s_accno=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1, acc_no);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
			
			al1.add(res.getInt(2));
			al2.add(res.getFloat(3));
			al3.add(res.getTimestamp(4));
		}
		
		return al1;
		
	}
	
	
	public boolean transferAmt()throws Exception
	{
		
		String s="select balance from bankdb where accno=?";
		pstmt=con.prepareStatement(s);
		pstmt.setInt(1, acc_no);
		res=pstmt.executeQuery();
		while(res.next()==true)
		{
		float balance=res.getFloat("balance");
		if(amount<balance)
		{
	    String s1="select * from bankdb where accno=?";
	
	  pstmt=con.prepareStatement(s1);
	  pstmt.setInt(1, acc_no1);
	  res=pstmt.executeQuery();
	  while(res.next()==true)
	  {
		  String s2="update bankdb set balance=balance-? where accno=?";
		  pstmt=con.prepareStatement(s2);
		  pstmt.setFloat(1, amount);
		  pstmt.setInt(2, acc_no);
		  int x=pstmt.executeUpdate();
		  if(x==1)
		  {
			  String s3="update bankdb set balance=balance+? where accno=?";
			  pstmt=con.prepareStatement(s3);
			  pstmt.setFloat(1, amount);
			  pstmt.setInt(2, acc_no1);
			  int x1=pstmt.executeUpdate();
			  if(x1==1)
			  {
				  String s4="insert into getstatement values(?,?,?,?)";
				  pstmt=con.prepareStatement(s4);
				  pstmt.setInt(1, acc_no);
				  pstmt.setInt(2, acc_no1);
				  pstmt.setFloat(3, amount);
				  java.util.Date date=new java.util.Date();
				  long t=date.getTime();
				  java.sql.Timestamp sqltimestamp=new java.sql.Timestamp(t);
				  pstmt.setTimestamp(4, sqltimestamp);
				  int x2=pstmt.executeUpdate();
				  if(x2==1)
				  {
					  return true;
				  }
				  else
				  {
					  return false;
				  }
			  }
			  else
			  {
				  return false;
			  }
		  }
		  else
		  {
			  
			  return false;
		  }
	  }
	  return false;
	}
		else {
			return false;
		}
	}
	return false;
	}
	
	
	public boolean changeNPwd()throws Exception
	{
		String s="update bankdb set password=? where email=?";
		pstmt=con.prepareStatement(s);
		pstmt.setString(1, pwd);
		pstmt.setString(2,email);
		
		int x=pstmt.executeUpdate();
		if(x==1)
		{
			return true;
		}
		else {
			return false;		
		}
	
	}
	
	public boolean login()throws Exception
	{
	    String s="select * from BankDB where cusid=? and pwd=? ";
	    pstmt=con.prepareStatement(s);
	    if(cust_id.length()!=0 &&pwd.length()!=0)
		{
	    pstmt.setString(1, cust_id);
	    pstmt.setString(2, pwd);
	    res=pstmt.executeQuery();
	    while(res.next()==true)
	    {
	    	acc_no=res.getInt("accno");
	    	return true;
	    }
		}
	    else {
	    	return false;
	    }
	    return false;
	}
	
	
}
