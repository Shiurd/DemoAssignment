package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "HoaDonChiTiet")
@Entity

@Data
@AllArgsConstructor
public class HoaDonChiTiet {
    @Id
    @Column(name = "IdHoaDon")
    private UUID idhoadon;
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
