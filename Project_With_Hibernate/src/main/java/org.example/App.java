package org.example;

import org.example.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.util.Date;

public class App
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Student st = new Student();
        st.setId(101);
        st.setName("Tom");
        st.setCity("Delhi");
        System.out.println(st);

        Address ad = new Address();
        ad.setStreet("street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(1234.123);

        /* Code to read the image

        FileInputStream fis = new FileInputStream("src/main/java/pic.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data); */

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(st);
        session.save(ad);
        tx.commit();
        session.close();
        System.out.println("Done....");
    }
}

/* Configuration:
   - Configuration is a class which is present in org.hibernate.cfg package. It activates Hibernate framework.
     It reads both configuration file and mapping files.
   - It checks whether the config file is syntactically correct or not.
   - If the config file is not valid then it will throw an exception. If it is valid then it creates a
     meta-data in memory and returns the meta-data to object to represent the config file.

   SessionFactory:
   - SessionFactory is an Interface which is present in org.hibernate package and it is used to create
     Session Object.
   - It is immutable and thread-safe in nature.
     buildSessionFactory() method gathers the meta-data which is in the cfg Object.
     From cfg object it takes the JDBC information and create a JDBC Connection.

   Session:
   - Session is an interface which is present in org.hibernate package. Session object is created based upon
    SessionFactory object i.e. factory.
   - It opens the Connection/Session with Database software through Hibernate Framework.
   - It is a light-weight object and it is not thread-safe.
   - Session object is used to perform CRUD operations.

   Transaction:
   - Transaction object is used whenever we perform any operation and based upon that operation there is
     some change in database.
   - Transaction object is used to give the instruction to the database to make the changes that happen because
     of operation as a permanent by using commit() method.
 */
