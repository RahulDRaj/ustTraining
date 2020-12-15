package com;

import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;


public class Welcome extends HttpServlet {

    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        response.setContentType("text/html");
        PrintWriter out = response.getWriter();
        out.println("Welcome user");
      }  
}