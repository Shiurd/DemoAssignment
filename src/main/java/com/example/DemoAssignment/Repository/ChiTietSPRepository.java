package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.ChiTietSP;
import com.example.DemoAssignment.Entity.ChucVu;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Shiurd
 */
public class ChiTietSPRepository {
    Session session = HibernateUlti.getFACTORY().openSession();


    public ArrayList<ChiTietSP> getChiTietSP(){
        ArrayList<ChiTietSP> list = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Query query = session.createQuery("from ChiTietSP");
            list = (ArrayList<ChiTietSP>) query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        }
        return list;
    }

    public ChiTietSP getChiTietSPById(UUID id) {
        ChiTietSP chiTietSP = new ChiTietSP();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            Query query = session.createQuery("from ChiTietSP where id = :id");
            query.setParameter("id", id);
            chiTietSP = (ChiTietSP) query.getSingleResult();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return chiTietSP;
    }
    public Boolean add(ChiTietSP chiTietSP){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(ChiTietSP chiTietSP){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(ChiTietSP chiTietSP){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(chiTietSP);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
