package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "GioHang")
@Entity

@Data
@AllArgsConstructor
public class GioHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
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

    public GioHang() {
    }

     GioHang( String idkh, String idnv, String ma, String ngaytao, String ngaythanhtoan, String tennguoinhan, String diachi, String sdt, int tinhTrang) {
      //  this.id = id;
        this.idkh = idkh;
        this.idnv = idnv;
        this.ma = ma;
        this.ngaytao = ngaytao;
        this.ngaythanhtoan = ngaythanhtoan;
        this.tennguoinhan = tennguoinhan;
        this.diachi = diachi;
        this.sdt = sdt;
        this.tinhTrang = tinhTrang;
    }
}
