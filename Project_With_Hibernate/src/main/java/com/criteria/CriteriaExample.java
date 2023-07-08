package com.criteria;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.cfg.Configuration;
import org.example.Student;
import org.hibernate.criterion.Restrictions;

import java.util.List;

public class CriteriaExample
{
    public static void main(String[] args) {
        Session session = new Configuration().configure().buildSessionFactory().openSession();
        Criteria criteria = session.createCriteria(Student.class);

        // adding restriction
        // eq - equal (course == Android)
        criteria.add(Restrictions.eq("certi.course", "Android"));
        // gt - greater than (id > 24)
        criteria.add(Restrictions.gt("id", 24));
        // like is case sensitive whereas ilike is not
        criteria.add(Restrictions.like("certi.course", "Java%"));

        List<Student> studentList = criteria.list();
        for (Student s : studentList) {
            System.out.println(s);
        }
        session.close();
    }
}

/* -> Criteria Interface :
      The Criteria interface provides many methods to specify criteria. The object of Criteria can be obtained by
      calling the createCriteria() method of Session interface.The Criteria interface provides methods to apply
      criteria such as retreiving all the records of table whose salary is greater than 50000 etc.
 */
