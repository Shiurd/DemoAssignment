package com.example.DemoAssignment.Entity;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.List;
import java.util.ArrayList;
import java.util.UUID;

@Table(name = "SanPham")
@Entity

@Data
@AllArgsConstructor
public class SanPham {
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

    @OneToMany(mappedBy = "SanPham",fetch = FetchType.LAZY)
    private List<ChiTietSP> chiTietSPList =new ArrayList<>();

    public SanPham() {
    }

    public SanPham(String ma, String ten) {
        this.ma = ma;
        this.ten = ten;
    }
}
