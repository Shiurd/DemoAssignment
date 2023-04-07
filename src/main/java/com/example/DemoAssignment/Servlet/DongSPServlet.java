package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.DongSP;
import com.example.DemoAssignment.Repository.DongSPRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "DongSPServlet", value = {
        "/dongsp/hien-thi",
        "/dongsp/add",
        "/dongsp/detail",
        "/dongsp/update",
        "/dongsp/delete"
})
public class DongSPServlet extends HttpServlet {
    private DongSPRepository dongSPRepository = new DongSPRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if(uri.equals("/dongsp/hien-thi")){
            ArrayList<DongSP> listDongSP = dongSPRepository.getAll();
            request.setAttribute("listDongSP", listDongSP);
            request.getRequestDispatcher("/view/DongSPView.jsp").forward(request,response);
        } else if (uri.contains("/dongsp/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            request.setAttribute("dongSP", dongSP);
            request.getRequestDispatcher("/view/DongSP/DetailDongSP.jsp").forward(request,response);
        } else if(uri.contains("/dongsp/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            DongSP dongSP = dongSPRepository.getById(id);
            dongSPRepository.delete(dongSP);
            ArrayList<DongSP> listDongSPs = dongSPRepository.getAll();
            request.setAttribute("listDongSP", listDongSPs);
            request.getRequestDispatcher("/view/DongSPView.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String uri = request.getRequestURI();
        if(uri.contains("/dongsp/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSP dongSP = new DongSP();
            dongSP.setMa(ma);
            dongSP.setTen(ten);

            dongSPRepository.add(dongSP);
            response.sendRedirect("/dongsp/hien-thi");
        } else if (uri.contains("/dongsp/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            DongSP dongSP = new DongSP();
            dongSP.setId(id);
            dongSP.setMa(ma);
            dongSP.setTen(ten);

            dongSPRepository.update(dongSP);
            response.sendRedirect("/dongsp/hien-thi");
        }
    }
}
