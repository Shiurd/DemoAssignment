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
    private String nambh;
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
    private Double gianhap;
    /**
     *
     */
    @Column(name = "SoLuongTon")
    private Integer soLuongTon;

    @Column(name = "GiaBan")
    private Double giaban;

    public ChiTietSP() {
    }

    public ChiTietSP(SanPham sanPham, MauSac mauSac, DongSP dongSP, String nambh, String mota, NSX nsx, Double gianhap, Integer soLuongTon, Double giaban) {
        this.sanPham = sanPham;
        this.mauSac = mauSac;
        this.dongSP = dongSP;
        this.nambh = nambh;
        this.mota = mota;
        this.nsx = nsx;
        this.gianhap = gianhap;
        this.soLuongTon = soLuongTon;
        this.giaban = giaban;
    }
}
