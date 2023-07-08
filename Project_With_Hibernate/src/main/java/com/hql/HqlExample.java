package com.hql;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HqlExample {
    public static void main(String[] args) {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();
        Session s = factory.openSession();
        String query = "from student where city=:x";

        // use ':' to give dynamic values at run time ex - q.setParameters("x", "Delhi");

       /* Query q = s.createQuery(query);
        q.setParameters("x", "Delhi");

        // implementing pagination using hibernate
        // 0 means the starting pt. and 5 means how many record we want so it will return 5 elements

        q.setFirstResult(0);
        q.setMaxResults(5);

        // single - unique
        // multiple - list

        List<Student> list = q.list();
        // if the query returns multiple results then use list

        for (Student student:list)
        {
            System.out.println(Student.getName());
        }

        s.close();
        factory.close();
    }
}

-> Hibernate Cascading -
   Cascading is a feature in Hibernate, which is used to manage the state of the mapped
   entity whenever the state of its relationship owner (superclass) affected. When the relationship owner
   (superclass) is saved/ deleted, then the mapped entity associated with it should also be saved/ deleted
   automatically. Mostly cascading is used in Hibernate mapping strategies (one-to-one, many-to-one, etc.).

   ex - @Cascade({CascadeType.ALL})

-> First Level Cache
   The first-level cache is related to the Session object. It is mandatory cache as all the requests made
   in the application passed through it. It is enabled by default, and we can’t disable it. Scope of first
   level cache is of the Session that means it is not available to the entire application.

   There are some essential methods used in the first-level cache. They are listed below-

     evict()- It is used to remove the loaded object from a first-level cache.
     clear()- It is used to remove all the objects stored in the first-level cache.
     contains()- It is used to check an object is present in the cache or not. If the object is found,
     it returns true else false.

-> Second Level Cache
   The second-level cache is related to the SessionFactory object, and it is optional. Scope of the
   second-level cache is global, that means it is available to the entire application. Unlike the first-level
   cache, it is not enabled by default. So, we need to enable it explicitly.

   When a user retrieves data from the database for the first time, the data gets stored in the second-level
   cache (if enabled for that object).
        */
    }
}