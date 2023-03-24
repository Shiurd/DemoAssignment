package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "GioHang")
@Entity

@Data
@AllArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
    /**
     *
     */
    @Column(name = "idKH")
    private String idkh;
    /**
     *
     */
    @Column(name = "idNV")
    private String idnv;
    /**
     *
     */
    @Column(name = "Ma")
    private String ma;
    /**
     *
     */
    @Column(name = "NgayTao")
    private String ngaytao;
    /**
     *
     */
    @Column(name = "NgayThanhToan")
    private String ngaythanhtoan;
    /**
     *
     */
    @Column(name = "TenNguoiNhan")
    private String tennguoinhan;
    /**
     *
     */
    @Column(name = "DiaChi")
    private String diachi;
    /**
     *
     */
    @Column(name = "Sdt")
    private String sdt;
    /**
     *
     */
    @Column(name = "TinhTrang")
    private int tinhTrang;
}
