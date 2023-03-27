package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.CuaHang;
import com.example.DemoAssignment.Repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;

@WebServlet(name = "CuaHangServlet", value = "/cua-hang/hien-thi")
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        ArrayList<CuaHang> listCuaHang = cuaHangRepository.getAll();
        request.setAttribute("ListCuaHang", listCuaHang);
        request.getRequestDispatcher("/view/CuaHangView.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
