package com.codingrevolution.junit5.lifecycle;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class JettyServlet extends HttpServlet {
    protected void doGet(HttpServletRequest request,
                         HttpServletResponse response) {
        response.setStatus(HttpServletResponse.SC_OK);
    }
}
