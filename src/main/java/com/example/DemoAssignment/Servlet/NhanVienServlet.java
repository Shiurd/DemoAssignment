package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.CuaHang;
import com.example.DemoAssignment.Entity.NhanVien;
import com.example.DemoAssignment.Repository.ChucVuRepository;
import com.example.DemoAssignment.Repository.CuaHangRepository;
import com.example.DemoAssignment.Repository.NhanVienRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.UUID;
import java.util.Date;

@WebServlet(name = "NhanVienServlet", value = {
        "/nhan-vien/hien-thi",
        "/nhan-vien/detail",
        "/nhan-vien/add",
        "/nhan-vien/update",
        "/nhan-vien/delete"
})
public class NhanVienServlet extends HttpServlet {
    private NhanVienRepository nhanVienRepo = new NhanVienRepository();
    private ChucVuRepository chucVuRepo = new ChucVuRepository();
    private CuaHangRepository cuaHangRepo = new CuaHangRepository();
    private SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/nhan-vien/hien-thi")){
            ArrayList<NhanVien> listNhanVien = nhanVienRepo.getAll();
            request.setAttribute("listNhanVien",listNhanVien);
            ArrayList<ChucVu> listChucVu = chucVuRepo.getAll();
            request.setAttribute("listChucVu",listChucVu);
            ArrayList<CuaHang> listCuaHang = cuaHangRepo.getAll();
            request.setAttribute("listcuaHang",listCuaHang);
            request.getRequestDispatcher("/view/NhanVienView.jsp").forward(request,response);

        }else if(uri.contains("/nhan-vien/detail")){

            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nhanVien = nhanVienRepo.getById(id);
            String ngaySinh = dateFormat.format(nhanVien.getNgaySinh());
            ArrayList<ChucVu> listChucVu = chucVuRepo.getAll();
            request.setAttribute("listChucVu",listChucVu);
            ArrayList<CuaHang> listCuaHang = cuaHangRepo.getAll();
            request.setAttribute("listcuaHang",listCuaHang);
            request.setAttribute("nhanvien",nhanVien);
            request.setAttribute("ngaySinh",ngaySinh);
            request.getRequestDispatcher("/view/NhanVien/DetailNhanVien.jsp").forward(request,response);

        }else if(uri.contains("/nhan-vien/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            NhanVien nv = nhanVienRepo.getById(id);
            nhanVienRepo.delete(nv);
            ArrayList<NhanVien> listNhanVien = nhanVienRepo.getAll();
            request.setAttribute("listNhanVien",listNhanVien);
            ArrayList<ChucVu> listChucVu = chucVuRepo.getAll();
            request.setAttribute("listChucVu",listChucVu);
            ArrayList<CuaHang> listCuaHang = cuaHangRepo.getAll();
            request.setAttribute("listcuaHang",listCuaHang);
            request.getRequestDispatcher("/view/NhanVienView.jsp").forward(request,response);

        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        if(uri.contains("/nhan-vien/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            UUID idCh = UUID.fromString(request.getParameter("cuaHang"));
            UUID idCv = UUID.fromString(request.getParameter("chucVu"));
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            CuaHang cuaHang = cuaHangRepo.getById(idCh);
            ChucVu chucVu = chucVuRepo.getById(idCv);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            nhanVien.setTrangThai(trangThai);
            nhanVienRepo.add(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");

        }else if(uri.contains("/nhan-vien/update")){
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");
            String tenDem = request.getParameter("tenDem");
            String ho = request.getParameter("ho");
            Boolean gioiTinh = Boolean.parseBoolean(request.getParameter("gioiTinh"));
            Date ngaySinh;
            try {
                ngaySinh = dateFormat.parse(request.getParameter("ngaySinh"));
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
            String diaChi = request.getParameter("diaChi");
            String sdt = request.getParameter("sdt");
            String matKhau = request.getParameter("matKhau");
            UUID idCh = UUID.fromString(request.getParameter("cuaHang"));
            UUID idCv= UUID.fromString(request.getParameter("chucVu"));
            int trangThai = Integer.parseInt(request.getParameter("trangThai"));
            CuaHang cuaHang = cuaHangRepo.getById(idCh);
            ChucVu chucVu = chucVuRepo.getById(idCv);
            NhanVien nhanVien = new NhanVien();
            nhanVien.setId(id);
            nhanVien.setMa(ma);
            nhanVien.setTen(ten);
            nhanVien.setTenDem(tenDem);
            nhanVien.setHo(ho);
            nhanVien.setGioiTinh(gioiTinh);
            nhanVien.setNgaySinh(ngaySinh);
            nhanVien.setDiaChi(diaChi);
            nhanVien.setSdt(sdt);
            nhanVien.setMatKhau(matKhau);
            nhanVien.setCuaHang(cuaHang);
            nhanVien.setChucVu(chucVu);
            nhanVien.setTrangThai(trangThai);
            nhanVienRepo.update(nhanVien);
            response.sendRedirect("/nhan-vien/hien-thi");
        }

    }
}
