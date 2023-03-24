package com.example.DemoAssignment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "HoaDon")
@Entity

@Data
@AllArgsConstructor
public class HoaDon {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
    /**
     *
     */
    @Column(name = "IdKH")
    private String idkh;
    /**
     *
     */
    @Column(name = "IdNV")
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
    @Column(name = "NgayShip")
    private String ngayship;
    /**
     *
     */
    @Column(name = "NgayNhan")
    private String ngaynhan;
    /**
     *
     */
    @Column(name = "TinhTrang")
    private String tinhtrang;
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
}
