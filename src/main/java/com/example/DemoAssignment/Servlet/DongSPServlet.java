package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.DongSP;
import com.example.DemoAssignment.Repository.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "DongSPServlet", value = "/dongsp/hien-thi")
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<DongSP> listDongSP = dongSPRepository.getAll();
        request.setAttribute("listDongSP", listDongSP);
        request.getRequestDispatcher("/view/DongSPView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
