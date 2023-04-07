package com.example.DemoAssignment.Servlet;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.Repository.ChucVuRepository;
import jakarta.servlet.*;
import jakarta.servlet.http.*;
import jakarta.servlet.annotation.*;

import java.io.IOException;
import java.util.ArrayList;
import java.util.UUID;

@WebServlet(name = "ChucVuServlet", value = {
        "/chuc-vu/hien-thi",
        "/chuc-vu/add",
        "/chuc-vu/detail",
        "/chuc-vu/update",
        "/chuc-vu/delete"
})
public class ChucVuServlet extends HttpServlet {
    private final ChucVuRepository chucVuRepository = new ChucVuRepository();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if (uri.contains("/chuc-vu/hien-thi")) {
            ArrayList<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/ChucVuView.jsp").forward(request, response);
        } else if (uri.contains("chuc-vu/detail")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu cv = chucVuRepository.getById(id);

            request.setAttribute("chucVu", cv);
            request.getRequestDispatcher("/view/ChucVu/DetailChucVu.jsp").forward(request,response);
        } else if (uri.contains("/chuc-vu/delete")){
            UUID id = UUID.fromString(request.getParameter("id"));
            ChucVu cv = chucVuRepository.getById(id);
            chucVuRepository.delete(cv);
            ArrayList<ChucVu> listChucVu = chucVuRepository.getAll();
            request.setAttribute("listChucVu", listChucVu);
            request.getRequestDispatcher("/view/ChucVuView.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String uri = request.getRequestURI();
        if(uri.contains("/chuc-vu/add")){
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu cv = new ChucVu();
            cv.setMa(ma);
            cv.setTen(ten);

            chucVuRepository.add(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        } else if(uri.contains("/chuc-vu/update")) {
            UUID id = UUID.fromString(request.getParameter("id"));
            String ma = request.getParameter("ma");
            String ten = request.getParameter("ten");

            ChucVu cv = new ChucVu();
            cv.setId(id);
            cv.setMa(ma);
            cv.setTen(ten);
            chucVuRepository.update(cv);
            response.sendRedirect("/chuc-vu/hien-thi");
        }
    }
}
