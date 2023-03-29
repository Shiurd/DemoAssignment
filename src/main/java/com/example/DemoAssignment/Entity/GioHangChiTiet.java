package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "GioHangChiTiet")
@Entity

@Data

public class GioHangChiTiet {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "IdGioHang")
    private UUID idgiohang;
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

    public GioHangChiTiet() {

    }

    public GioHangChiTiet(UUID idgiohang, String idchitietsp, String soluong, Double dongia, Double dongiakhigiam) {
        this.idgiohang = idgiohang;
        this.idchitietsp = idchitietsp;
        this.soluong = soluong;
        this.dongia = dongia;
        this.dongiakhigiam = dongiakhigiam;
    }
}
