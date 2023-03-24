package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "HoaDonChiTiet")
@Entity

@Data
@AllArgsConstructor
public class HoaDonChiTiet {
    @Id
    @Column(name = "IdHoaDon")
    private String idhoadon;
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
}
