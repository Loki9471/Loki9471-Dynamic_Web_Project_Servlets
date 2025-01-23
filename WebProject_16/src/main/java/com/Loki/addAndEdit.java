package com.Loki;

import java.io.IOException;
import java.io.PrintWriter;

import com.Loki.action.AccountAction;
import com.Loki.beans.Account;
import com.Loki.factories.AccountActionFactory;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class addAndEdit
 */
@WebServlet("/addAndEdit")
public class addAndEdit extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		 response.setContentType("text/html");
		 PrintWriter out=response.getWriter();
		 HttpSession hs=request.getSession(false);
		 AccountAction accountAction=AccountActionFactory.getAccountAction();
		 Account account=new Account();
		 account.setAccNo((String)hs.getAttribute("accNo"));
		 account.setAccHolderName((String)hs.getAttribute("accHolderName"));
		 account.setAccType((String)hs.getAttribute("accType"));
		 account.setBalance((Double)hs.getAttribute("balance"));
		 account.setAccBranch((String)hs.getAttribute("accBranch"));
		 account.setAccBank((String)hs.getAttribute("accBank"));
		 String status=accountAction.addAccount(account);
		 RequestDispatcher rd=null;
		 if(status.equalsIgnoreCase("success")) {
			 rd=request.getRequestDispatcher("/Form2.html");
			 rd.forward(request, response);
		 }else {
			 rd=request.getRequestDispatcher("/Form3.html");
			 rd.forward(request, response);
		 }
		 
	}

}
