package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.Date;
import java.util.UUID;

@Table(name = "KhachHang")
@Entity

@Data
public class KhachHang {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "Id")
    private UUID id;

    @Column(name = "Ma")
    private String ma;

    @Column(name = "Ten")
    private String ten;

    @Column(name = "TenDem")
    private String tenDem;

    @Column(name = "Ho")
    private String ho;

    @Column(name = "NgaySinh")
    private Date ngaySinh;

    @Column(name = "Sdt")
    private String sdt;

    @Column(name = "DiaChi")
    private String diaChi;

    @Column(name = "ThanhPho")
    private String thanhPho;

    @Column(name = "QuocGia")
    private String quocGia;

    @Column(name = "MatKhau")
    private String matKhau;


    public KhachHang() {
    }

    public KhachHang(UUID id, String ma, String ten, String tenDem, String ho, Date ngaySinh, String sdt, String diaChi, String thanhPho, String quocGia, String matKhau) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
        this.tenDem = tenDem;
        this.ho = ho;
        this.ngaySinh = ngaySinh;
        this.sdt = sdt;
        this.diaChi = diaChi;
        this.thanhPho = thanhPho;
        this.quocGia = quocGia;
        this.matKhau = matKhau;
    }
}
