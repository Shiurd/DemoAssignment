package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.MauSac;
import com.example.DemoAssignment.Repository.MauSacRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "MauSacServlet", value = {
        "/mau-sac/hien-thi",
        "/mau-sac/add",
        "/mau-sac/detail",
        "/mau-sac/update",
        "/mau-sac/delete"

})
public class MauSacServlet extends HttpServlet {
    private MauSacRepository mauSacRepository = new MauSacRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/mau-sac/hien-thi")) {
            ArrayList<MauSac> listMauSac = mauSacRepository.getAll();
            request.setAttribute("listMauSac",listMauSac);
            request.getRequestDispatcher("/view/MauSacView.jsp").forward(request,response);

        } else if(uri.contains("/mau-sac/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            request.setAttribute("mauSac",mauSac);
            request.getRequestDispatcher("/view/MauSac/DetailMauSac.jsp").forward(request,response);
        } else if (uri.contains("/mau-sac/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            mauSacRepository.delete(mauSac);
            ArrayList<MauSac> list = mauSacRepository.getAll();
            request.setAttribute("listMauSac",list);
            request.getRequestDispatcher("/view/MauSacView.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/mau-sac/add")) {
            MauSac mauSac = new MauSac();

            mauSac.setMa(request.getParameter("ma"));
            mauSac.setTen(request.getParameter("ten"));
            mauSacRepository.add(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        } else if(uri.contains("/mau-sac/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            MauSac mauSac = mauSacRepository.getById(id);
            mauSac.setMa(request.getParameter("ma"));
            mauSac.setTen(request.getParameter("ten"));
            mauSacRepository.update(mauSac);
            response.sendRedirect("/mau-sac/hien-thi");
        }
    }
}
