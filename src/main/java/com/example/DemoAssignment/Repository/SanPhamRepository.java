package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.SanPham;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

/**
 * @author Shiurd
 */
public class SanPhamRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<SanPham> getAll(){
        ArrayList<SanPham> listSanPham = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Query query = session.createQuery("From SanPham");
            listSanPham = (ArrayList<SanPham>) query.getResultList();
        } catch(Exception e){
            e.printStackTrace();
        }
        return listSanPham;
    }
   public SanPham getById(UUID id){
        SanPham sanPham = new SanPham();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            sanPham = session.get(SanPham.class, id);
        } catch(Exception e){
            e.printStackTrace();
        }
        return sanPham;
   }

   public Boolean add(SanPham sanPham){
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.save(sanPham);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
   }

   public Boolean update(SanPham sanPham){
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.merge(sanPham);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();
            return false;
        }
   }

   public Boolean delete(SanPham sanPham){
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Transaction transaction = session.beginTransaction();
            session.delete(sanPham);
            transaction.commit();
            return true;
        } catch(Exception e){
            e.printStackTrace();

        }
       return false;
   }
}
