<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 4/7/2023
  Time: 9:36 AM
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
<form action="/nhan-vien/add" method="post" class="container">

    <div class="row">
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" class="form-control form-control-lg" disabled/>
                <label class="form-label" for="firstName">Id</label>
            </div>

        </div>
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" class="form-control form-control-lg" name="ma"/>
                <label class="form-label">Mã</label>
            </div>

        </div>
    </div>
    <div class="row">
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" id="firstName" class="form-control form-control-lg"
                       name="ten"/>
                <label class="form-label" for="firstName">Tên</label>
            </div>

        </div>
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" class="form-control form-control-lg" name="tenDem"/>
                <label class="form-label">Tên Đệm</label>
            </div>

        </div>

        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" class="form-control form-control-lg" name="ho"/>
                <label class="form-label">Họ</label>
            </div>

        </div>
        <div class="col-md-6 mb-4">

            <div class="form-outline">
                <input type="text" class="form-control form-control-lg" name="matKhau"/>
                <label class="form-label">Mật khẩu</label>
            </div>

        </div>
    </div>

    <div class="row">

        <div class="form-group row">
            <label class="col-sm-2 col-form-label">Ngày Sinh</label>
            <div class="col-sm-10">
                <input class="form-control" type="date" name="ngaySinh"><br>
            </div>
        </div>
        <div class="col-md-6 mb-4">

            <h6 class="mb-2 pb-1">Giới tính </h6>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gioiTinh"
                       value="true" checked/>
                <label class="form-check-label" >Nam</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="gioiTinh"
                       value="false"/>
                <label class="form-check-label" >Nữ</label>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-4 pb-2">

            <div class="form-outline">
                <input type="text" id="emailAddress" class="form-control form-control-lg"
                       name="diaChi"/>
                <label class="form-label" for="emailAddress">Địa chỉ</label>
            </div>

        </div>
        <div class="col-md-6 mb-4 pb-2">

            <div class="form-outline">
                <input type="tel" id="phoneNumber" class="form-control form-control-lg"
                       name="sdt"/>
                <label class="form-label" for="phoneNumber">Phone Number</label>
            </div>

        </div>
    </div>

    <div class="row">
        <div class="col-12">
            <label class="form-label select-label">Cửa Hàng</label>
            <select class="select form-control-lg" name="cuaHang">
                <c:forEach items="${listcuaHang}" var="ch">
                    <option value="${ch.id}">${ch.ten}</option>
                </c:forEach>
            </select>


        </div>
    </div>
    <div class="row">
        <div class="col-12">
            <label class="form-label select-label">Chức vụ</label>
            <select class="select form-control-lg" name="chucVu">
                <c:forEach items="${listChucVu}" var="cv">
                    <option value="${cv.id}">${cv.ten}</option>
                </c:forEach>
            </select>
        </div>

    </div>
    <div class="row">
        <div class="col-md-6 mb-4">

            <h6 class="mb-2 pb-1">Trạng thái </h6>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="1" />
                <label class="form-check-label" >Đi làm</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="2"/>
                <label class="form-check-label">Đã nghỉ</label>
            </div>

        </div>
    </div>

    <div class="mt-4 pt-2">
        <input class="btn btn-primary btn-lg" type="submit" value="Submit"/>
    </div>

</form>

<table class="table">
    <thead>
    <tr>
        <td>Id</td>
        <td>Ma</td>
        <td>Ten</td>
        <td>Ten Dem</td>
        <td>Ho</td>
        <td>Gioi Tinh</td>
        <td>Ngay Sinh</td>
        <td>Dia Chi</td>
        <td>Sdt</td>
        <td>Mat Khau</td>
        <td>Cua Hang</td>
        <td>Chuc Vu</td>
        <td>Trang Thai</td>
        <td>Action</td>
    </tr>
    </thead>
    <tbody>
    <c:forEach items="${listNhanVien}" var="nv">
        <tr>
            <td>${nv.id}</td>
            <td>${nv.ma}</td>
            <td>${nv.ten}</td>
            <td>${nv.tenDem}</td>
            <td>${nv.ho}</td>
            <td>${nv.gioiTinh}</td>
            <td>${nv.ngaySinh}</td>
            <td>${nv.diaChi}</td>
            <td>${nv.sdt}</td>
            <td>${nv.matKhau}</td>
            <td>${nv.cuaHang.ten}</td>
            <td>${nv.chucVu.ten}</td>
            <td>${nv.trangThai}</td>
            <td><a href="/nhan-vien/delete?id=${nv.id}">Xoa</a>
                <a href="/nhan-vien/detail?id=${nv.id}">Detail</a></td>
        </tr>
    </c:forEach>
    </tbody>
</table>
</body>
</html>
