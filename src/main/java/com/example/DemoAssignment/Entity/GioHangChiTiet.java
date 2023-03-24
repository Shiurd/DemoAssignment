package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "GioHangChiTiet")
@Entity

@Data
@AllArgsConstructor
public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdGioHang")
    private String idgiohang;
    /**
     *
     */
    @Column(name = "IdChiTietSP")
    private String idchitietsp;
    /**
     *
     */
    @Column(name = "SoLuong")
    private String soluong;
    /**
     *
     */
    @Column(name = "DonGia")
    private Double dongia;
    /**
     *
     */
    @Column(name = "DonGiaKhiGiam")
    private Double dongiakhigiam;

}
