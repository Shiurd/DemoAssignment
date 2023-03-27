package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class ChucVuRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<ChucVu> getAll(){
        Query query = session.createQuery("FROM ChucVu ");
        ArrayList<ChucVu> listChucVu = (ArrayList<ChucVu>) query.getResultList();
        return listChucVu;
    }
}
