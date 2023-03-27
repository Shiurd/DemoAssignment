package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.NSX;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class NSXRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<NSX> getAll(){
        Query query = session.createQuery("FROM NSX");
        ArrayList<NSX> listNSX = (ArrayList<NSX>) query.getResultList();
        return listNSX;
    }

}
