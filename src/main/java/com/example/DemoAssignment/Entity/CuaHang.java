package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
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
    private String diachi;
    /**
     *
     */
    @Column(name = "ThanhPho")
    private String thanhpho;

    @Column(name = "QuocGia")
    private String quocGia;

    public CuaHang() {
    }

    public CuaHang(UUID id, String ma, String ten, String diachi, String thanhpho, String quocGia) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.diachi = diachi;
        this.thanhpho = thanhpho;
        this.quocGia = quocGia;
    }
}
