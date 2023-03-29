<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 3/29/2023
  Time: 12:59 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
          rel="stylesheet"
          integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
          crossorigin="anonymous">
</head>
<body>
<form action="/cua-hang/update?id=${cuaHang.id}" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${cuaHang.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${cuaHang.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa chỉ</label>
        <div class="col-sm-10">
            <input value="${cuaHang.diachi}" class="form-control" type="text" name="diachi"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Thành phố</label>
        <div class="col-sm-10">
            <input value="${cuaHang.thanhpho}" class="form-control" type="text" name="thanhpho"><br>
        </div>
    </div>
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Quốc gia</label>
        <div class="col-sm-10">
            <input value="${cuaHang.quocGia}" class="form-control" type="text" name="quocgia"><br>
        </div>
    </div>
    <button type="submit">Update</button>
</body>
</html>
