<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 4/3/2023
  Time: 12:52 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>Title</title>
    <link rel="stylesheet" href="sanpham.css">
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/san-pham/add" method="post" class="container">
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
    <button type="submit">Them</button>
    <br>


    <table class="table">
        <thead>
        <tr>
            <td>Id</td>
            <td>Ma</td>
            <td>Ten</td>

        </tr>
        </thead>
        <tbody>
        <c:forEach items="${listSanPham}" var="cv">
            <tr>
                <td>${cv.id}</td>
                <td>${cv.ma}</td>
                <td>${cv.ten}</td>
                <td><a href="/san-pham/delete?id=${cv.id}">Xoa</a>
                    <a href="/san-pham/detail?id=${cv.id}">Detail</a></td>
                <td><a href="/chi-tiet-sp/hien-thi?id=${cv.id}">Chi tiet SP</a></td>
            </tr>
        </c:forEach>
        </tbody>
    </table>

    <div class="container text-center">
        <div class="row">
            <div class="col">
                Column
            </div>
            <div class="col">
                Column
            </div>
        </div>
    </div>
</body>
</html>
