package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class ChucVuRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<ChucVu> getAll(){
        ArrayList<ChucVu> listChucVu = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Query query = session.createQuery("FROM ChucVu ");
            listChucVu = (ArrayList<ChucVu>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listChucVu;
    }

    public ChucVu getById(UUID id){
        ChucVu chucVu = new ChucVu();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            chucVu = session.get(ChucVu.class, id);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chucVu;
    }

    public Boolean add(ChucVu chucVu){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(ChucVu chucVu){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }

    public Boolean delete(ChucVu chucVu){
        Transaction transaction = null;
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(chucVu);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }
}
