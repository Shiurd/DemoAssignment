package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;

@Table(name = "KhachHang")
@Entity

@Data
@AllArgsConstructor
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;
}
