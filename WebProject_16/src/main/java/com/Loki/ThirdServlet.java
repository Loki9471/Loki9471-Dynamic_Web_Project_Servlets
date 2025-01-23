package com.Loki;

import java.io.IOException;
import java.io.PrintWriter;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
@WebServlet("/disp")
public class ThirdServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html"); // Correct content type
        PrintWriter out = response.getWriter();

        // Retrieve parameters from the request
        String accBranch = request.getParameter("accBranch");
        String accBank = request.getParameter("accBank");

        // Retrieve session attributes
        HttpSession httpsession = request.getSession();
        httpsession.setAttribute("accBranch", accBranch);
        httpsession.setAttribute("accBank", accBank);

        String accNo = (String) httpsession.getAttribute("accNo");
        String accHolderName = (String) httpsession.getAttribute("accHolderName");
        String accType = (String) httpsession.getAttribute("accType");
        double balance = (double) httpsession.getAttribute("balance");

        // Generate the response HTML
        out.println("<html><body>");
        out.println("<h2 style='color:blue' align='center'>Codegnan Banking Services</h2>");
        out.println("<h3 style='color:red' align='center'>Account Details</h3>");
        out.println("<table border='2' align='center'>");
        out.println("<tr><td>Account Number</td><td>" + accNo + "</td></tr>");
        out.println("<tr><td>Account Holder Name</td><td>" + accHolderName + "</td></tr>");
        out.println("<tr><td>Account Type</td><td>" + accType + "</td></tr>");
        out.println("<tr><td>Account Balance</td><td>" + balance + "</td></tr>");
        out.println("<tr><td>Account Branch</td><td>" + accBranch + "</td></tr>");
        out.println("<tr><td>Account Bank</td><td>" + accBank + "</td></tr>");
        out.println("</table>");

        // Add a confirmation form
        out.println("<form method='post' action='" + response.encodeURL("addAndEdit") + "'>");
        out.println("<table align='center'>");
        out.println("<tr><td><input type='submit' value='Confirm'></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
