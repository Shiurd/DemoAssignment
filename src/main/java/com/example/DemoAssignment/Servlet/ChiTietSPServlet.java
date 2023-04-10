package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.*;
import com.example.DemoAssignment.Repository.*;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ChiTietSPServlet", value = {
        "/chi-tiet-sp/hien-thi",
        "/chi-tiet-sp/add",
        "/chi-tiet-sp/detail",
        "/chi-tiet-sp/update",
        "/chi-tiet-sp/delete"
})
public class ChiTietSPServlet extends HttpServlet {

    private ChiTietSPRepository chiTietSPRepository = new ChiTietSPRepository();
    private NSXRepository nsxRepository = new NSXRepository();
    private MauSacRepository mauSacRepository = new MauSacRepository();
    private DongSPRepository dongSPRepository = new DongSPRepository();
    private SanPhamRepository sanPhamRepository = new SanPhamRepository();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chi-tiet-sp/hien-thi")){
            ArrayList<ChiTietSP> chiTietSPArrayList = chiTietSPRepository.getChiTietSP();
            ArrayList<NSX> nsxArrayList = nsxRepository.getAll();
            ArrayList<SanPham> sanPhamArrayList = sanPhamRepository.getAll();
            ArrayList<MauSac> mauSacArrayList = mauSacRepository.getAll();
            ArrayList<DongSP> dongSPArrayList = dongSPRepository.getAll();

            request.setAttribute("chiTietSPArrayList", chiTietSPArrayList);
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.setAttribute("mauSacArrayList", mauSacArrayList);
            request.setAttribute("dongSPArrayList", dongSPArrayList);
            request.setAttribute("sanPhamArrayList", sanPhamArrayList);
            request.getRequestDispatcher("/view/ChiTietSPView.jsp").forward(request, response);
        } else if (uri.contains("/chi-tiet-sp/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getChiTietSPById(id);
            ArrayList<NSX> nsxArrayList = nsxRepository.getAll();
            ArrayList<MauSac> mauSacArrayList = mauSacRepository.getAll();
            ArrayList<DongSP> dongSPArrayList = dongSPRepository.getAll();
            ArrayList<SanPham> sanPhamArrayList = sanPhamRepository.getAll();

            request.setAttribute("chiTietSP", chiTietSP);
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.setAttribute("mauSacArrayList", mauSacArrayList);
            request.setAttribute("dongSPArrayList", dongSPArrayList);
            request.setAttribute("sanPhamArrayList", sanPhamArrayList);
            request.getRequestDispatcher("/view/ChiTietSP/ChiTietSPDetail.jsp").forward(request, response);
        } else if (uri.contains("chi-tiet-sp/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChiTietSP chiTietSP = chiTietSPRepository.getChiTietSPById(id);
            chiTietSPRepository.delete(chiTietSP);

            ArrayList<ChiTietSP> chiTietSPArrayList = chiTietSPRepository.getChiTietSP();
            ArrayList<NSX> nsxArrayList = nsxRepository.getAll();
            ArrayList<SanPham> sanPhamArrayList = sanPhamRepository.getAll();
            ArrayList<MauSac> mauSacArrayList = mauSacRepository.getAll();
            ArrayList<DongSP> dongSPArrayList = dongSPRepository.getAll();

            request.setAttribute("chiTietSPArrayList", chiTietSPArrayList);
            request.setAttribute("nsxArrayList", nsxArrayList);
            request.setAttribute("mauSacArrayList", mauSacArrayList);
            request.setAttribute("dongSPArrayList", dongSPArrayList);
            request.setAttribute("sanPhamArrayList", sanPhamArrayList);

            request.getRequestDispatcher("/view/ChiTietSPView.jsp").forward(request,response);
        }

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chi-tiet-sp/add")){
            UUID idSP = UUID.fromString(request.getParameter("sap"));
            UUID idNSX = UUID.fromString(request.getParameter("nsx"));
            UUID idMauSac = UUID.fromString(request.getParameter("ms"));
            UUID idDongSP = UUID.fromString(request.getParameter("dongSP"));

            Integer namHB = Integer.valueOf(request.getParameter("namBH"));
            String moTa = request.getParameter("moTa");
            Integer soLuongTon = Integer.valueOf(request.getParameter("soLuongTon"));
            Integer giaNhap = Integer.valueOf(request.getParameter("giaNhap"));
            Integer giaBan = Integer.valueOf(request.getParameter("giaBan"));

            SanPham sanPham = sanPhamRepository.getById(idSP);
            MauSac mauSac = mauSacRepository.getById(idMauSac);
            DongSP dongSP = dongSPRepository.getById(idDongSP);
            NSX nsx = nsxRepository.getById(idNSX);

            ChiTietSP chiTietSP = new ChiTietSP();
            chiTietSP.setSanPham(sanPham);
            chiTietSP.setMauSac(mauSac);
            chiTietSP.setDongSP(dongSP);
            chiTietSP.setNambh(namHB);
            chiTietSP.setMota(moTa);
            chiTietSP.setNsx(nsx);
            chiTietSP.setGianhap(giaNhap);
            chiTietSP.setSoLuongTon(soLuongTon);
            chiTietSP.setGiaban(giaBan);

            chiTietSPRepository.add(chiTietSP);
            response.sendRedirect("/chi-tiet-sp/hien-thi");


        }
    }
}
