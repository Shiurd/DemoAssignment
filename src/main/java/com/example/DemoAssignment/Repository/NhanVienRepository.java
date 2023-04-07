package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.NhanVien;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;

/**
 * @author Shiurd
 */
public class NhanVienRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<NhanVien> getAll(){
        ArrayList<NhanVien> nhanVienArrayList = new ArrayList<>();
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            Query query = session.createQuery("from NhanVien ");
            nhanVienArrayList = (ArrayList<NhanVien>) query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return nhanVienArrayList;
    }

    public Boolean add(NhanVien nhanVien){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.save(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean update(NhanVien nhanVien){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.update(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }

    public Boolean delete(NhanVien nhanVien){
        Transaction transaction;
        try(Session session = HibernateUlti.getFACTORY().openSession()){
            transaction = session.beginTransaction();
            session.delete(nhanVien);
            transaction.commit();
            return true;
        } catch (Exception e){
            e.printStackTrace();
            return false;
        }
    }
}
