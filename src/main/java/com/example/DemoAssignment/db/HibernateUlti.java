package com.example.DemoAssignment.db;

import com.example.DemoAssignment.Entity.*;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;

import java.util.Properties;

public class HibernateUlti {
    private static final SessionFactory FACTORY;

    static {
        Configuration conf = new Configuration();

        Properties properties = new Properties();
        properties.put(Environment.DIALECT, "org.hibernate.dialect.SQLServerDialect");
        properties.put(Environment.DRIVER, "com.microsoft.sqlserver.jdbc.SQLServerDriver");
        properties.put(Environment.URL, "jdbc:sqlserver://localhost:1433;databaseName=SOF2041_Assignment_Database");
        properties.put(Environment.USER, "shiurd");
        properties.put(Environment.PASS, "123456");
        properties.put(Environment.SHOW_SQL, "true");

        conf.setProperties(properties);
//        conf.addAnnotatedClass(DongVat.class);
        conf.addAnnotatedClass(KhachHang.class);
      //  conf.addAnnotatedClass(SinhVien.class);
        conf.addAnnotatedClass(ChiTietSP.class);
        conf.addAnnotatedClass(ChucVu.class);
        conf.addAnnotatedClass(CuaHang.class);
        conf.addAnnotatedClass(DongSP.class);
        conf.addAnnotatedClass(GioHang.class);
        conf.addAnnotatedClass(NhanVien.class);


        ServiceRegistry registry = new StandardServiceRegistryBuilder()
                .applySettings(conf.getProperties()).build();
        FACTORY = conf.buildSessionFactory(registry);

    }

    public static SessionFactory getFACTORY() {
        return FACTORY;
    }

    public static void main(String[] args) {
        System.out.println(getFACTORY());
        System.out.println("Connected");
    }

}
