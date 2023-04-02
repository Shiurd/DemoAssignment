package com.example.DemoAssignment.Entity;

import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "CuaHang")
@Entity

@Data
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;
    /**
     *
     */
    @Column(name = "Ma")
    private String ma;
    /**
     *
     */
    @Column(name = "Ten")
    private String ten;
    /**
     *
     */
    @Column(name = "DiaChi")
    private String diaChi;
    /**
     *
     */
    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    public CuaHang() {
    }

    public CuaHang(UUID id, String ma, String ten, String diaChi, String thanhPho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
    }
}
