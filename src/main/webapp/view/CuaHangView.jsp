<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 3/27/2023
  Time: 7:22 AM
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
<form action="/cua-hang/add" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa chỉ</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="diachi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Thành phố</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="thanhpho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Quốc gia</label>
        <div class="col-sm-10">
            <input class="form-control" type="text" name="quocgia"><br>
        </div>
    </div>
    <button type="submit">Them</button>
    <br>


<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Ma</td>
        <td>Ten</td>
        <td>Dia chi</td>
        <td>Thanh pho</td>
        <td>Quoc gia</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listCuaHang}" var="ch">
        <tr>
            <td>${ch.id}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diaChi}</td>
            <td>${ch.thanhPho}</td>
            <td>${ch.quocGia}</td>
            <td><a href="/cua-hang/delete?id=${ch.id}">Xoa</a>
                <a href="/cua-hang/detail?id=${ch.id}">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
