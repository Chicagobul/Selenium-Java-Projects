package com.onetomany;

import com.onetoone.Answer;
import com.onetoone.Question;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDemo2
{
    public static void main(String[] args)
    {
        Configuration cfg = new Configuration();
        cfg.configure();
        SessionFactory factory = cfg.buildSessionFactory();

        Question2 q1 = new Question2();
        q1.setQuestionId(101);
        q1.setQuestion("What is Java?");

        Answer2 a1 = new Answer2();
        a1.setAnswerId(901);
        a1.setAnswer("Java is a programming language");
        a1.setQuestion(q1);

        Answer2 a2 = new Answer2();
        a2.setAnswerId(902);
        a2.setAnswer("With the help of java we can create softwares");
        a2.setQuestion(q1);

        Answer2 a3 = new Answer2();
        a3.setAnswerId(903);
        a3.setAnswer("Java has diff types of frameworks");
        a3.setQuestion(q1);

        List<Answer2> list = new ArrayList<Answer2>();
        list.add(a1);
        list.add(a2);
        list.add(a3);
        q1.setAnswers(list);

        Session session = factory.openSession();
        Transaction tx = session.beginTransaction();

        session.save(q1);
        session.save(a1);
        session.save(a2);
        session.save(a3);
        tx.commit();

        //fetching data
        /*Question2 newQ = (Question2) session.get(Question2.class, 101);
        System.out.println(newQ.getQuestion());
        for(Answer2 a : newQ.getAnswers())
        {
           System.out.println(a.getAnswer());
        }
        session.close();
        factory.close();*/
    }
}
