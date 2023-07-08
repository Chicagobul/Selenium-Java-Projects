package org.example;

import org.example.Certificate;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.*;

public class Embed {
    public static void main(String[] args)
    {

        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Student st1 =new Student();
        st1.setId(13452);
        st1.setName("Jane");
        st1.setCity("Mumbai");

        Certificate certificate1 = new Certificate();
        certificate1.setCourse("Android");
        certificate1.setDuration("2 months");
        st1.setCert(certificate1);

        Student st2 =new Student();
        st2.setId(13453);
        st2.setName("Jolly");
        st2.setCity("Pune");

        Certificate certificate2 = new Certificate();
        certificate2.setCourse("Machine Learning");
        certificate2.setDuration("3 months");
        st2.setCert(certificate2);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st1);
        session.save(st2);
        tx.commit();
        session.close();
        factory.close();
    }
}
