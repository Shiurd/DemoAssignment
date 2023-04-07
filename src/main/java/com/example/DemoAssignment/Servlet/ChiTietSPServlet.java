package com.example.DemoAssignment.Servlet;

import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/delete"
})
public class ChiTietSPServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chi-tiet-sp/hien-thi")){

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
