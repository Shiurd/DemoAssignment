package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.NSX;
import com.example.DemoAssignment.Repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "NSXServlet", value = "/nsx/hien-thi")
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<NSX> listNSX = nsxRepository.getAll();
        request.setAttribute("listNSX", listNSX);
        request.getRequestDispatcher("/view/NSXView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
