package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.SanPham;
import com.example.DemoAssignment.Repository.SanPhamRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "SanPhamServlet", value = {
        "/san-pham/hien-thi",
        "/san-pham/add",
        "/san-pham/detail",
        "/san-pham/update",
        "/san-pham/delete"
})
public class SanPhamServlet extends HttpServlet {
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/san-pham/hien-thi")) {
            ArrayList<SanPham> listSanPham = sanPhamRepository.getAll();
            request.setAttribute("listSanPham", listSanPham);
            request.getRequestDispatcher("/view/SanPhamView.jsp").forward(request, response);
        } else if(uri.contains("/san-pham/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);

            request.setAttribute("sanPham", sanPham);
            request.getRequestDispatcher("/view/SanPham/DetailSanPham.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.equals("/san-pham/add")) {
            SanPham sanPham = new SanPham();
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            sanPham.setMa(ma);
            sanPham.setTen(ten);

            sanPhamRepository.add(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        } else if (uri.equals("/san-pham/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            SanPham sanPham = sanPhamRepository.getById(id);

            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            sanPham.setMa(ma);
            sanPham.setTen(ten);

            sanPhamRepository.update(sanPham);
            response.sendRedirect("/san-pham/hien-thi");
        }
    }
}
