package com.example.DemoAssignment.Entity;

/**
 * @author Shiurd
 * Session session = HibernateUlti.getFACTORY().openSession();
 * <p>
 * public ArrayList<ChucVu> getAll(){
 * ArrayList<ChucVu> listChucVu = new ArrayList<>();
 * try (Session session = HibernateUlti.getFACTORY().openSession()){
 * <p>
 * Query query = session.createQuery("FROM ChucVu ");
 * listChucVu = (ArrayList<ChucVu>) query.getResultList();
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * return listChucVu;
 * }
 * <p>
 * public ChucVu getById(UUID id){
 * ChucVu chucVu = new ChucVu();
 * try (Session session = HibernateUlti.getFACTORY().openSession()){
 * chucVu = session.get(ChucVu.class, id);
 * } catch (Exception e) {
 * e.printStackTrace();
 * }
 * return chucVu;
 * }
 * <p>
 * public Boolean add(ChucVu chucVu){
 * Transaction transaction;
 * try (Session session = HibernateUlti.getFACTORY().openSession()) {
 * transaction = session.beginTransaction();
 * session.save(chucVu);
 * transaction.commit();
 * return true;
 * } catch (Exception e) {
 * e.printStackTrace();
 * return false;
 * }
 * }
 * <p>
 * public Boolean update(ChucVu chucVu){
 * Transaction transaction;
 * try (Session session = HibernateUlti.getFACTORY().openSession()) {
 * transaction = session.beginTransaction();
 * session.merge(chucVu);
 * transaction.commit();
 * return true;
 * } catch (Exception e) {
 * e.printStackTrace();
 * return false;
 * <p>
 * }
 * }
 * <p>
 * public Boolean delete(ChucVu chucVu){
 * Transaction transaction = null;
 * try (Session session = HibernateUlti.getFACTORY().openSession()){
 * transaction = session.beginTransaction();
 * session.delete(chucVu);
 * transaction.commit();
 * return true;
 * } catch (Exception e){
 * e.printStackTrace();
 * }
 * return false;
 * }
 */
public class test {
}
