package com.example.DemoAssignment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.util.UUID;

@Table(name = "ChucVu")
@Entity

@Data

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

    public ChucVu() {
    }

    public ChucVu(UUID id, String ma, String ten) {
        this.id = id;
        this.ma = ma;
        this.ten = ten;
    }
}
