package com.example.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        //configuration.configure(new File("C:\\Users\\SURESH\\IdeaProjects\\Spring-core\\src\\hibernate.cfg.xml"));
        configuration.configure("hibernate.cfg.xml");
        //configuration.addResource("Message.hbm.xml");
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        Message message1 = session.get(Message.class, 5L);
        Message message=new Message("loading the record2");
        message.setNextMessage(message1);
        session.save(message);
        transaction.commit();
        System.out.println("Inserted record successfully");
    }
}
