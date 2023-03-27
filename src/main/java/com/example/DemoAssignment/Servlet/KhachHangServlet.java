package com.example.DemoAssignment.Servlet;


import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.Repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/update"
})
public class KhachHangServlet extends HttpServlet {

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/hien-thi")) {
            ArrayList<KhachHang> listKhachHang = khachHangRepository.getAll();
            request.setAttribute("listKhachHang", listKhachHang);
            request.getRequestDispatcher("/view/KhachHangView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
