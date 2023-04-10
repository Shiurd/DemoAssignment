<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 4/7/2023
  Time: 12:33 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
    <form action="/chi-tiet-sp/add" method="post" class="container">
        <div class="row">
            <div class="col-12">
                <label class="form-label select-label">San Pham</label>
                <select class="select form-control-lg" name="sap">
                    <c:forEach items="${sanPhamArrayList}" var="sap">
                        <option value="${sap.id}">${sap.ten}</option>
                    </c:forEach>
                </select>


            </div>
            <div class="col-12">
                <label class="form-label select-label">NSX</label>
                <select class="select form-control-lg" name="nsx">
                    <c:forEach items="${nsxArrayList}" var="nsx">
                        <option value="${nsx.id}">${nsx.ten}</option>
                    </c:forEach>
                </select>


            </div>
            <div class="col-12">
                <label class="form-label select-label">Mau Sac</label>
                <select class="select form-control-lg" name="ms">
                    <c:forEach items="${mauSacArrayList}" var="ms">
                        <option value="${ms.id}">${ms.ten}</option>
                    </c:forEach>
                </select>


            </div>
            <div class="col-12">
                <label class="form-label select-label">Dong SP</label>
                <select class="select form-control-lg" name="dongSP">
                    <c:forEach items="${dongSPArrayList}" var="dongSP">
                        <option value="${dongSP.id}">${dongSP.ten}</option>
                    </c:forEach>
                </select>


            </div>

            <div class="col-md-6 mb-4">

                <div class="form-outline">
                    <input type="text" class="form-control form-control-lg" name="namBH"/>
                    <label class="form-label">Nam Ban Hang</label>
                </div>

            </div>
            <div class="col-md-6 mb-4">

                <div class="form-outline">
                    <input type="text" class="form-control form-control-lg" name="moTa"/>
                    <label class="form-label">Mo Ta</label>
                </div>

            </div>

            <div class="col-md-6 mb-4">

                <div class="form-outline">
                    <input type="text" class="form-control form-control-lg" name="soLuongTon"/>
                    <label class="form-label">So Luong Ton</label>
                </div>

            </div>

            <div class="col-md-6 mb-4">

                <div class="form-outline">
                    <input type="text" class="form-control form-control-lg" name="giaNhap"/>
                    <label class="form-label">Gia Nhap</label>
                </div>

            </div>

            <div class="col-md-6 mb-4">

                <div class="form-outline">
                    <input type="text" class="form-control form-control-lg" name="giaBan"/>
                    <label class="form-label">Gia Ban</label>
                </div>

            </div>
            <div class="mt-4 pt-2">
                <input class="btn btn-primary btn-lg" type="submit" value="Submit"/>
            </div>
        </div>
    </form>>

    <table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>SP</td>
        <td>NSX</td>
        <td>Mau Sac</td>
        <td>Dong SP</td>
        <td>Nam BH</td>
        <td>Mo Ta</td>
        <td>So luong ton</td>
        <td>Gia Nhap</td>
        <td>Gia Ban</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${chiTietSPArrayList}" var="ct">
        <tr>
            <td>${ct.id}</td>
            <td>${ct.sanPham.ten}</td>
            <td>${ct.nsx.ten}</td>
            <td>${ct.mauSac.ten}</td>
            <td>${ct.dongSP.ten}</td>
            <td>${ct.nambh}</td>
            <td>${ct.mota}</td>
            <td>${ct.soLuongTon}</td>
            <td>${ct.gianhap}</td>
            <td>${ct.giaban}</td>

            <td><a href="/chi-tiet-sp/delete?id=${nv.id}">Xoa</a>
                <a href="/chi-tiet-sp/detail?id=${nv.id}">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
    </table>
</body>
</html>
