package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class KhachHangRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<KhachHang> getAll(){
        Query query = session.createQuery("FROM KhachHang ");
        ArrayList<KhachHang> listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        return listKhachHang;
    }
}
