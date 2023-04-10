package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;
import java.util.List;

@Table(name = "ChiTietSP")
@Entity

@Data
@AllArgsConstructor

public class ChiTietSP {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "idSP")
    private SanPham sanPham;
    /**
     *
     */

    @ManyToOne
    @JoinColumn(name = "IdMauSac")
    private MauSac mauSac;
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "IdDongSP")
    private DongSP dongSP;
//    @Column(name = "IdDongSP")
//    private String idDongSP;
    /**
     *
     */
    @Column(name = "namBH")
    private Integer nambh;
    /**
     *
     */
    @Column(name = "MoTa")
    private String mota;
    /**
     *
     */
    @ManyToOne
    @JoinColumn(name = "IdNsx")
    private NSX nsx;
    /**
     *
     */
    @Column(name = "GiaNhap")
    private Integer gianhap;
    /**
     *
     */
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaBan")
    private Integer giaban;

    public ChiTietSP() {
    }

}
