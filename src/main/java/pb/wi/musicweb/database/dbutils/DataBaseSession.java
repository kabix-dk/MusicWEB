package pb.wi.musicweb.database.dbutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

import java.util.List;

public class DataBaseSession {

    public static SessionFactory sessionFactory;
    public static Session session;

    public static void initDataBase() {
        sessionFactory = new AnnotationConfiguration().configure("hibernate.cfg.xml").buildSessionFactory();
    }

    public static void startTransaction() {
        session = sessionFactory.openSession();
        session.beginTransaction();
    }

    public static void endTransaction() {
        session.getTransaction().commit();
    }

    public static void closeSession() {
        session.close();
    }

    public static Session getSession() {
        return session;
    }

    public static void saveObject(Object o) {
        session.save(o);
    }
}
