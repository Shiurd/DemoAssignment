package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.Entity.NSX;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class NSXRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<NSX> getAll() {
        ArrayList<NSX> resultList = new ArrayList<NSX>();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            Query query = session.createQuery("from NSX");
            resultList = (ArrayList<NSX>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return resultList;
    }

    public NSX getById(UUID id) {
        NSX nsx = new NSX();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
             nsx = session.get(NSX.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return nsx;
    }

    public Boolean add(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(NSX nsx) {
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(nsx);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
}
