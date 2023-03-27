package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.MauSac;
import com.example.DemoAssignment.Repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "MauSacServlet", value = "/mau-sac/hien-thi")
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<MauSac> listMauSac = mauSacRepository.getAll();
        request.setAttribute("listMauSac",listMauSac);
        request.getRequestDispatcher("/view/MauSacView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
