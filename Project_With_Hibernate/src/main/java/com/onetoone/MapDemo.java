package com.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class MapDemo
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Question q1 = new Question();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java?");

        Answer a1 = new Answer();
        a1.setAnswerId(901);
        a1.setAnswer("Java is a programming language");
        a1.setQuestion(q1);
        q1.setAnswer(a1);

        Question q2 = new Question();
        q2.setQuestionId(102);
        q2.setQuestion("What is your name?");

        Answer a2 = new Answer();
        a2.setAnswerId(902);
        a2.setAnswer("My name is Rahul Singh");
        a2.setQuestion(q2);
        q2.setAnswer(a2);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();
        session.save(q1);
        session.save(q2);
        session.save(a1);
        session.save(a2);
        tx.commit();

        //fetching data
        Question newQ = (Question) session.get(Question.class, 101);
        System.out.println(newQ.getQuestion());
        System.out.println(newQ.getAnswer().getAnswer());
        session.close();
        factory.close();
    }
}
