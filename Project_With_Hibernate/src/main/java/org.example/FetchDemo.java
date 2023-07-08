package org.example;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class FetchDemo
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session session = factory.openSession();
        // get student 101
        // get and load are same
        // session.get takes 2 arguments, one the class for which we are using it and the other one is the value
        // of that record
        Student student = (Student) session.get(Student.class, 101);
        System.out.println(student);

        Address ad = (Address) session.get(Address.class, 1);
        System.out.println(ad.getStreet()+" : "+ad.getCity());
        session.close();
        factory.close();
    }
}
