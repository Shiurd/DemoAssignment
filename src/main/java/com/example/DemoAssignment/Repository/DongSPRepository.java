package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.DongSP;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class DongSPRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<DongSP> getAll() {
        ArrayList<DongSP> dongSPList = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            Query query = session.createQuery("From DongSP");
            dongSPList = (ArrayList<DongSP>) query.getResultList();
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dongSPList;
    }

    public DongSP getById(UUID id) {
        DongSP dongSP = new DongSP();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
//            Query query = session.createQuery("From DongSP where id=:id");
//            query.setParameter("id", id);
//            dongSP = (DongSP) query.getSingleResult();
            dongSP = session.get(DongSP.class, id);
        } catch(Exception e) {
            e.printStackTrace();
        }
        return dongSP;
    }
    public Boolean add(DongSP dongSP) {
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            session.beginTransaction();
            session.save(dongSP);
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean update(DongSP dongSP) {
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            session.beginTransaction();
            session.update(dongSP);
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
    public Boolean delete(DongSP dongSP) {
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            session.beginTransaction();
            session.delete(dongSP);
            session.getTransaction().commit();
        } catch(Exception e) {
            e.printStackTrace();
            return false;
        }
        return true;
    }
}
