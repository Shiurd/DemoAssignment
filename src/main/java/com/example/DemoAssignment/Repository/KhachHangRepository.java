package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.KhachHang;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class KhachHangRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<KhachHang> getAll(){
        ArrayList<KhachHang> listKhachHang = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            Query query = session.createQuery("from KhachHang ");
            listKhachHang = (ArrayList<KhachHang>) query.getResultList();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listKhachHang;
    }

    public KhachHang getById(UUID id) {
        KhachHang khachHang = new KhachHang();
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
//            Query query = session.createQuery("from KhachHang where id =: id");
//            query.setParameter("id", id);
//            khachHang= (KhachHang) query.getSingleResult();
            khachHang = session.get(KhachHang.class, id);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return khachHang;
    }
    public Boolean add(KhachHang khachHang) {
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(KhachHang khachHang) {
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.merge(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;

        }
    }
    public Boolean delete(KhachHang khachHang){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(khachHang);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
        }
        return false;
    }

}
