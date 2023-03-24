package com.example.DemoAssignment.Entity;


import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;

@Table(name = "ChucVu")
@Entity

@Data
@AllArgsConstructor
public class ChucVu {

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

}
