package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.CuaHang;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class CuaHangRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<CuaHang> getAll(){
        Query query = session.createQuery("FROM CuaHang");
        ArrayList<CuaHang> listCuaHang = (ArrayList<CuaHang>) query.getResultList();
        return listCuaHang;
    }
}
