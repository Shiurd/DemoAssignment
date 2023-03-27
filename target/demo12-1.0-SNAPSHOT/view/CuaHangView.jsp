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
    <c:forEach items="${ListCuaHang}" var="ch">
        <tr>
            <td>${ch.id}</td>
            <td>${ch.ma}</td>
            <td>${ch.ten}</td>
            <td>${ch.diachi}</td>
            <td>${ch.thanhpho}</td>
            <td>${ch.quocGia}</td>
            <td><a href="">Xoa</a>
                <a href="">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
