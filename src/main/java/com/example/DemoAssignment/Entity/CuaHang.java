package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "CuaHang")
@Entity

@Data
@AllArgsConstructor
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

    @OneToMany(mappedBy = "cuaHang", fetch = FetchType.EAGER)
    private List<NhanVien> nhanVienList = new ArrayList<>();

    public CuaHang() {
    }


}
