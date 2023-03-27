package com.example.DemoAssignment.Repository;


import com.example.DemoAssignment.Entity.MauSac;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;

public class MauSacRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<MauSac> getAll(){
        Query query = session.createQuery("FROM MauSac");
    ArrayList<MauSac> listMauSac = (ArrayList<MauSac>) query.getResultList();
        return listMauSac;
    }
}
