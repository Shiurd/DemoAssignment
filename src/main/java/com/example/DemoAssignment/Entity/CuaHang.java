package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "CuaHang")
@Entity

@Data
@AllArgsConstructor
public class CuaHang {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private String id;
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
}
