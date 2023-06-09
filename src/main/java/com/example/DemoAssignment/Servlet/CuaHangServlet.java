package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.CuaHang;
import com.example.DemoAssignment.Repository.CuaHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "CuaHangServlet", value = {
        "/cua-hang/hien-thi",
        "/cua-hang/add",
        "/cua-hang/update",
        "/cua-hang/delete",
        "/cua-hang/detail",
})
public class CuaHangServlet extends HttpServlet {
    private CuaHangRepository cuaHangRepository = new CuaHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/cua-hang/hien-thi")) {
            ArrayList<CuaHang> listCuaHang = cuaHangRepository.getAll();
            request.setAttribute("listCuaHang", listCuaHang);
            request.getRequestDispatcher("/view/CuaHangView.jsp").forward(request, response);
        } else if ("/cua-hang/detail".equals(uri)) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            request.setAttribute("cuaHang", cuaHang);
            request.getRequestDispatcher("/view/CuaHang/DetailCuaHang.jsp").forward(request, response);
        } else if ("/cua-hang/delete".equals(uri)) {
            UUID id = UUID.fromString(request.getParameter("id"));
            CuaHang cuaHang = cuaHangRepository.getById(id);
            cuaHangRepository.delete(cuaHang);
            ArrayList<CuaHang> listCuaHang = cuaHangRepository.getAll();
            request.setAttribute("listCuaHang", listCuaHang);
            request.getRequestDispatcher("/view/CuaHangView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/cua-hang/add")) {
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String diaChi = request.getParameter("diachi");
            String thanhPho = request.getParameter("thanhpho");
            String quocGia = request.getParameter("quocgia");

            CuaHang cuaHang = new CuaHang();
            cuaHang.setMa(ma);
            cuaHang.setTen(ten);
            cuaHang.setDiaChi(diaChi);
            cuaHang.setThanhPho(thanhPho);
            cuaHang.setQuocGia(quocGia);


            cuaHangRepository.add(cuaHang);
            response.sendRedirect("/cua-hang/hien-thi");
        } else {
            if (uri.contains("/cua-hang/update")){
                UUID id = UUID.fromString(request.getParameter("id"));
                String ma = request.getParameter("ma");
                String ten = request.getParameter("ten");
                String diaChi = request.getParameter("diachi");
                String thanhPho = request.getParameter("thanhpho");
                String quocGia = request.getParameter("quocgia");

                CuaHang cuaHang = cuaHangRepository.getById(id);
                cuaHang.setMa(ma);
                cuaHang.setTen(ten);
                cuaHang.setDiaChi(diaChi);
                cuaHang.setThanhPho(thanhPho);
                cuaHang.setQuocGia(quocGia);

                cuaHangRepository.update(cuaHang);
                response.sendRedirect("/cua-hang/hien-thi");
            }
        }
    }
}
