package com.example.DemoAssignment.Repository;


import com.example.DemoAssignment.Entity.MauSac;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class MauSacRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<MauSac> getAll(){
       ArrayList<MauSac> list = new ArrayList<>();
       try(Session session = HibernateUlti.getFACTORY().openSession()){
           Query query = session.createQuery("FROM MauSac ");
           list = (ArrayList<MauSac>) query.getResultList();
       } catch(Exception e){
           e.printStackTrace();
       }
       return list;
    }
    public MauSac getById(UUID id){
        MauSac mauSac = new MauSac();
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            mauSac = session.get(MauSac.class, id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return mauSac;
    }

    public Boolean add(MauSac mauSac){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(mauSac);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(MauSac mauSac){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.merge(mauSac);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(MauSac mau){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(mau);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
