package com.Loki;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

/**
 * Servlet implementation class FirstServlet
 */
@WebServlet("/first")
public class FirstServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public FirstServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
        PrintWriter out=response.getWriter();
        String accNo=request.getParameter("accNo");
        String accHolderName=request.getParameter("accHolderName");
        HttpSession httpsession=request.getSession();
        httpsession.setAttribute("accNo", accNo);
        httpsession.setAttribute("accHolderName",accHolderName);
        out.println("<!DOCTYPE html><body bgcolor='skyblue'>");
        out.println("<h1 style=\"color:red\" align=\"center\">Codegnan Banking service</h1>");
        out.println("<h1 style=\"color:green\" align=\"center\" >Account Creation Form</h1>");
        out.println("<form method='post' action='"+response.encodeURL("sec")+"'>");
        out.println("<table align='center'>");
        out.println("<tr><td>Account Type</td><td><input type='text' name='accType' ></td></tr>");
        out.println("<tr><td>Account Balance</td><td><input type='text' name='balance' ></td></tr>" );
        out.println("<tr><td><input type='submit' value='Next' ></td></tr>");
        out.println("</table></form></body></html>");
	}

}
