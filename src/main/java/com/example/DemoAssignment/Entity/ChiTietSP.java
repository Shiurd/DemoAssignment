package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

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

    @Column(name = "idSP")
    private String idsp;
    /**
     *
     */
    @Column(name = "idNxs")
    private String idnsx;
    /**
     *
     */
    @Column(name = "idMauSac")
    private String idmausac;
    /**
     *
     */
    @Column(name = "idDongSP")
    private String iddongsp;
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
    @Column(name = "iDNxs")
    private String soluongton;
    /**
     *
     */
    @Column(name = "GiaNhap")
    private Double gianhap;
    /**
     *
     */
    @Column(name = "GiaBan")
    private Double giaban;

    public ChiTietSP() {
    }

    public ChiTietSP(String idsp, String idnsx, String idmausac, String iddongsp, String nambh, String mota, String soluongton, Double gianhap, Double giaban) {
        this.idsp = idsp;
        this.idnsx = idnsx;
        this.idmausac = idmausac;
        this.iddongsp = iddongsp;
        this.nambh = nambh;
        this.mota = mota;
        this.soluongton = soluongton;
        this.gianhap = gianhap;
        this.giaban = giaban;
    }
}
