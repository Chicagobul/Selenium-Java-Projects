package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MappingDemo
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Emp e1 = new Emp();
        Emp e2 = new Emp();

        e1.setE_id(201);
        e1.setName("Ram");

        e2.setE_id(202);
        e2.setName("Shyam");

        Project p1 = new Project();
        Project p2 = new Project();

        p1.setP_id(3456);
        p1.setProjectName("Library Management System");

        p2.setP_id(3457);
        p2.setProjectName("Chatbot");

        List<Emp> empList = new ArrayList<Emp>();
        List<Project> projectList = new ArrayList<Project>();

        empList.add(e1);
        empList.add(e2);

        projectList.add(p1);
        projectList.add(p2);

        e1.setProjects(projectList);
        p1.setEmps(empList);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(e1);
        session.save(e2);
        session.save(p1);
        session.save(p2);
        tx.commit();
        session.close();
    }
}
