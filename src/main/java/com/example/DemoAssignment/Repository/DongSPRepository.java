package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.DongSP;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class DongSPRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<DongSP> getAll() {
        Query query = session.createQuery("FROM DongSP ");
        ArrayList<DongSP> listDongSP = (ArrayList<DongSP>) query.getResultList();
        return listDongSP;
    }
}
