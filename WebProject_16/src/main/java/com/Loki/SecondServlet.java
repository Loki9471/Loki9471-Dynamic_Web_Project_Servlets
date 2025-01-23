package com.Loki;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/sec")
public class SecondServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    public SecondServlet() {
        super();
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();

        // Retrieve form data
        String accType = request.getParameter("accType");
        double balance = Double.parseDouble(request.getParameter("balance"));

        // Store data in session
        HttpSession httpsession = request.getSession();
        httpsession.setAttribute("accType", accType);
        httpsession.setAttribute("balance", balance);

        // Generate response form for ThirdServlet
        out.println("<!DOCTYPE html><body>");
        out.println("<h2 style='color:blue' align='center'>Codegnan Banking Services</h2>");
        out.println("<h3 style='color:green' align='center'>Account Creation - Step 2</h3>");
        out.println("<form method='post' action='" + response.encodeURL("disp") + "'>");
        out.println("<table align='center'>");
        out.println("<tr><td>Account Branch</td><td><input type='text' name='accBranch'></td></tr>");
        out.println("<tr><td>Account Bank</td><td><input type='text' name='accBank'></td></tr>");
        out.println("<tr><td colspan='2' align='center'><input type='submit' value='Next'></td></tr>");
        out.println("</table>");
        out.println("</form>");
        out.println("</body></html>");
    }
}
