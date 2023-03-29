package com.example.DemoAssignment.Repository;

import com.example.DemoAssignment.Entity.CuaHang;
import com.example.DemoAssignment.db.HibernateUlti;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.UUID;

public class CuaHangRepository {
    Session session = HibernateUlti.getFACTORY().openSession();

    public ArrayList<CuaHang> getAll(){
        ArrayList<CuaHang> listCuaHang = new ArrayList<>();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            Query query = session.createQuery("FROM CuaHang");
            listCuaHang = (ArrayList<CuaHang>) query.getResultList();
        } catch (Exception e){
            e.printStackTrace();
        }
        return listCuaHang;
    }

    public CuaHang getById(UUID id){
        CuaHang ch = new CuaHang();
        try (Session session = HibernateUlti.getFACTORY().openSession()){
            ch = session.get(CuaHang.class, id);
        } catch (Exception e){
            e.printStackTrace();
        }
        return ch;
    }

    public Boolean add(CuaHang cuaHang){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.save(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean update(CuaHang cuaHang){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.update(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public Boolean delete(CuaHang cuaHang){
        Transaction transaction;
        try (Session session = HibernateUlti.getFACTORY().openSession()) {
            transaction = session.beginTransaction();
            session.delete(cuaHang);
            transaction.commit();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }

}
