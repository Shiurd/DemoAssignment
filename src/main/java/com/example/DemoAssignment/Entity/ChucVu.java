package com.example.DemoAssignment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Table(name = "ChucVu")
@Entity

@Data
@AllArgsConstructor
public class ChucVu {

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

    @OneToMany(mappedBy = "chucVu",fetch = FetchType.EAGER)
    private List<NhanVien> nhanVienList = new ArrayList<>();

    public ChucVu() {
    }
}
