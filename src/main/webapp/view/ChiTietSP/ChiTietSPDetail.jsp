<%--<jsp:useBean id="chiTietSP" scope="request" type="java.util.ArrayList"/>--%>

<%--
  Created by IntelliJ IDEA.
  User: Shiurdj
  Date: 4/10/2023
  Time: 10:33 AM
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
<form action="${pageContext.request.contextPath}/chi-tiet-sp/update?id=${chiTietSP.id}" method="post" class="container">
    <div class="row">
        <div class="col-12">
            <label class="form-label select-label">San Pham</label>
            <select class="select form-control-lg" name="sap">
                <jsp:useBean id="sanPhamArrayList" scope="request" type="java.util.List"/>
                <c:forEach items="${sanPhamArrayList}" var="sap">
                    <option value="${sap.id}" ${sap.id == chiTietSP.sanPham.id ? 'selected ="selected"': ''}>${sap.ten}</option>
                </c:forEach>
            </select>


        </div>
        <div class="col-12">
            <label class="form-label select-label">NSX</label>
            <select class="select form-control-lg" name="nsx">
                <jsp:useBean id="nsxArrayList" scope="request" type="java.util.List"/>
                <c:forEach items="${nsxArrayList}" var="nsx">
                    <option value="${nsx.id}" ${nsx.id == chiTietSP.nsx.id ? 'selected ="selected"': ''}>${nsx.ten}</option>
                </c:forEach>
            </select>


        </div>
        <div class="col-12">
            <label class="form-label select-label">Mau Sac</label>
            <select class="select form-control-lg" name="ms">
                <jsp:useBean id="mauSacArrayList" scope="request" type="java.util.List"/>
                <c:forEach items="${mauSacArrayList}" var="ms">
                    <option value="${ms.id}" ${ms.id == chiTietSP.mauSac.id ? 'selected ="selected"': ''}>${ms.ten}</option>
                </c:forEach>
            </select>


        </div>
        <div class="col-12">
            <label class="form-label select-label">Dong SP</label>
            <select class="select form-control-lg" name="dongSP">
                <jsp:useBean id="dongSPArrayList" scope="request" type="java.util.List"/>
                <c:forEach items="${dongSPArrayList}" var="dongSP">
                    <option value="${dongSP.id}" ${dongSP.id == chiTietSP.dongSP.id ? 'selected ="selected"': ''}>${dongSP.ten}</option>
                </c:forEach>
            </select>


        </div>

        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input value="${chiTietSP.nambh}" type="text" class="form-control form-control-lg" name="namBH"/>
                <label class="form-label">Nam Ban Hang</label>
            </div>

        </div>
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input value="${chiTietSP.mota}" type="text" class="form-control form-control-lg" name="moTa"/>
                <label class="form-label">Mo Ta</label>
            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input value="${chiTietSP.soLuongTon}" type="text" class="form-control form-control-lg" name="soLuongTon"/>
                <label class="form-label">So Luong Ton</label>
            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input value="${chiTietSP.gianhap}" type="text" class="form-control form-control-lg" name="giaNhap"/>
                <label class="form-label">Gia Nhap</label>
            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input value="${chiTietSP.giaban}" type="text" class="form-control form-control-lg" name="giaBan"/>
                <label class="form-label">Gia Ban</label>
            </div>

        </div>
        <div class="mt-4 pt-2">
            <input class="btn btn-primary btn-lg" type="submit" value="Submit"/>
        </div>
    </div>
</form>>
</body>
</html>
