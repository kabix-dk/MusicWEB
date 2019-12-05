package pb.wi.musicweb.database.dbutils;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.AnnotationConfiguration;

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

    public static void updateObject(Object o) {
        Object mergedOne = session.merge(o);
        session.update(mergedOne);
    }

    public static void deleteObject(Object o) {
        Object mergeOne = session.merge(o);
        session.delete(mergeOne);
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
