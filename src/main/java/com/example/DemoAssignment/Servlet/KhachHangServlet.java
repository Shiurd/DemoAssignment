package com.example.DemoAssignment.Servlet;


import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.Repository.KhachHangRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;

@WebServlet(name = "KhachHangServlet", value = {
        "/khach-hang/hien-thi",
        "/khach-hang/add",
        "/khach-hang/detail",
        "/khach-hang/update",
        "/khach-hang/delete"
})
public class KhachHangServlet extends HttpServlet {
    SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private KhachHangRepository khachHangRepository = new KhachHangRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/hien-thi")) {
            ArrayList<KhachHang> listKhachHang = khachHangRepository.getAll();
            request.setAttribute("listKhachHang", listKhachHang);
            request.getRequestDispatcher("/view/KhachHangView.jsp").forward(request, response);
        } else if (uri.contains("/khach-hang/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang kh = khachHangRepository.getById(id);

            request.setAttribute("khachHang", kh);
            String ngSinh = dateFormat.format(kh.getNgaySinh());
            request.setAttribute("ngaySinh", ngSinh);
            request.getRequestDispatcher("/view/KhachHang/DetailKhachHang.jsp").forward(request,response);
        } else if (uri.contains("/khach-hang/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            KhachHang kh = khachHangRepository.getById(id);
            khachHangRepository.delete(kh);
            ArrayList<KhachHang> listKhachHang = khachHangRepository.getAll();
            request.setAttribute("listKhachHang", listKhachHang);
            request.getRequestDispatcher("/view/KhachHangView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        String uri = request.getRequestURI();
        if (uri.contains("/khach-hang/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("thanhPho");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));

            } catch (ParseException e){
                throw new RuntimeException(e);
            }

            KhachHang kh = new KhachHang();
            kh.setMa(ma);
            kh.setTen(ten);
            kh.setHo(ho);
            kh.setTenDem(tenDem);
            kh.setNgaySinh(ngaySinh);
            kh.setSdt(sdt);
            kh.setDiaChi(diaChi);
            kh.setThanhPho(thanhPho);
            kh.setQuocGia(quocGia);
            kh.setMatKhau(matKhau);
            khachHangRepository.add(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        } else if(uri.contains("/khach-hang/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            String sdt = request.getParameter("sdt");
            String diaChi = request.getParameter("diaChi");
            String thanhPho = request.getParameter("thanhPho");
            String quocGia = request.getParameter("thanhPho");
            String matKhau = request.getParameter("matKhau");
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));

            } catch (ParseException e){
                throw new RuntimeException(e);
            }
            KhachHang kh = new KhachHang();
            kh.setId(id);
            kh.setMa(ma);
            kh.setTen(ten);
            kh.setHo(ho);
            kh.setTenDem(tenDem);
            kh.setNgaySinh(ngaySinh);
            kh.setSdt(sdt);
            kh.setDiaChi(diaChi);
            kh.setThanhPho(thanhPho);
            kh.setQuocGia(quocGia);
            kh.setMatKhau(matKhau);
            khachHangRepository.update(kh);
            response.sendRedirect("/khach-hang/hien-thi");
        }
    }
}
