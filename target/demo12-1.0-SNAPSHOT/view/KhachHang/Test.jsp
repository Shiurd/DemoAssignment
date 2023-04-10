<%--
  Created by IntelliJ IDEA.
  User: Shiurd
  Date: 4/7/2023
  Time: 10:51 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <link
            href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0-alpha1/dist/css/bootstrap.min.css"
            rel="stylesheet"
            integrity="sha384-GLhlTQ8iRABdZLl6O3oVMWSktQOp6b7In1Zl3/Jr59b6EGGoI1aFkw7cmDA6j6gD"
            crossorigin="anonymous"
    />
</head>
<body>
<form action="/nhan-vien/update?id=${nhanvien.id}" method="post" class="container">
    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Id</label>
        <div class="col-sm-10">
            <input value="${nhanvien.id}" class="form-control" type="text" disabled><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mã</label>
        <div class="col-sm-10">
            <input value="${nhanvien.ma}" class="form-control" type="text" name="ma"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên</label>
        <div class="col-sm-10">
            <input value="${nhanvien.ten}" class="form-control" type="text" name="ten"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Tên Đệm</label>
        <div class="col-sm-10">
            <input value="${nhanvien.tenDem}" class="form-control" type="text" name="tenDem"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Họ</label>
        <div class="col-sm-10">
            <input value="${nhanvien.ho}" class="form-control" type="text" name="ho"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Mật khẩu</label>
        <div class="col-sm-10">
            <input value="${nhanvien.matKhau}" class="form-control" type="text" name="matKhau"><br>
        </div>
    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Ngày Sinh</label>
        <div class="col-sm-10">
            <input value="${ngaySinh}" class="form-control" type="date" name="ngaySinh"><br>
        </div>
    </div>

    <div class="col-md-6 mb-4">

        <h6 class="mb-2 pb-1">Giới tính </h6>

        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gioiTinh"
                   value="true" ${nhanvien.gioiTinh == true ? "Checked" : ""} checked/>
            <label class="form-check-label" >Nam</label>
        </div>

        <div class="form-check form-check-inline">
            <input class="form-check-input" type="radio" name="gioiTinh"
                   value="false" ${nhanvien.gioiTinh == false ? "Checked":""}/>
            <label class="form-check-label" >Nữ</label>
        </div>

    </div>

    <div class="form-group row">
        <label class="col-sm-2 col-form-label">Địa chỉ</label>
        <div class="col-sm-10">
            <input value="${nhanvien.diaChi}" class="form-control" type="text" name="diaChi"><br>
        </div>
    </div>

    <div class="row">
        <div class="col-12">

            <select class="select form-control-lg" name="cuaHang">
                <c:forEach items="${listcuaHang}" var="ch">
                    <option value="${ch.id}" ${ch.id == nhanvien.cuaHang.id ? 'selected ="selected"': ''}>${ch.ten}</option>
                </c:forEach>
            </select>
            <label class="form-label select-label">Cửa Hàng</label>

        </div>
    </div>
    <div class="row">
        <div class="col-12">

            <select class="select form-control-lg" name="chucVu">
                <c:forEach items="${listChucVu}" var="cv">
                    <option value="${cv.id}" ${cv.id == nhanvien.chucVu.id ? 'selected ="selected"': ''}>${cv.ten}</option>
                </c:forEach>
            </select>
            <label class="form-label select-label">Chức vụ</label>

        </div>
    </div>

    <div class="row">
        <div class="col-md-6 mb-4">

            <h6 class="mb-2 pb-1">Trạng thái </h6>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="1" ${nhanvien.trangThai == 1 ? "checked":""}/>
                <label class="form-check-label" >Đi làm</label>
            </div>

            <div class="form-check form-check-inline">
                <input class="form-check-input" type="radio" name="trangThai" value="2" ${nhanvien.trangThai == 2 ? "checked": ""}/>
                <label class="form-check-label">Đã nghỉ</label>
            </div>

        </div>
    </div>

    <button type="submit">Update</button>
</form>
</body>
</html>
