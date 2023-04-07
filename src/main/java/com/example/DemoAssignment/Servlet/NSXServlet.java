package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.NSX;
import com.example.DemoAssignment.Repository.NSXRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "NSXServlet", value = {
        "/nsx/hien-thi",
        "/nsx/add",
        "/nsx/detail",
        "/nsx/update",
        "/nsx/delete"
})
public class NSXServlet extends HttpServlet {
    private NSXRepository nsxRepository = new NSXRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/nsx/hien-thi")){
            ArrayList<NSX> listNSX = nsxRepository.getAll();
            request.setAttribute("listNSX", listNSX);
            request.getRequestDispatcher("/view/NSXView.jsp").forward(request,response);
        } else if(uri.contains("/nsx/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            request.setAttribute("nsx", nsx);
            request.getRequestDispatcher("/view/NSX/DetailNSX.jsp").forward(request,response);
        } else if (uri.contains("/nsx/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NSX nsx = nsxRepository.getById(id);
            nsxRepository.delete(nsx);
            ArrayList<NSX> list = nsxRepository.getAll();
            request.setAttribute("listNSX", list);
            request.getRequestDispatcher("/view/NSXView.jsp").forward(request, response);

        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.equals("/nsx/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            NSX nsx = new NSX();
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.add(nsx);
            response.sendRedirect("/nsx/hien-thi");
        } else if(uri.contains("/nsx/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            NSX nsx = new NSX();
            nsx.setId(id);
            nsx.setMa(ma);
            nsx.setTen(ten);
            nsxRepository.update(nsx);
            response.sendRedirect("/nsx/hien-thi");
        }
    }
}
