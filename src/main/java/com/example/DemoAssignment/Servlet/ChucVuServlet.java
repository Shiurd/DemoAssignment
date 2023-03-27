package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.Repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "ChucVuServlet", value = "/chuc-vu/hien-thi")
public class ChucVuServlet extends HttpServlet {
    private ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chuc-vu/hien-thi")) {
            ArrayList<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/ChucVuView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
