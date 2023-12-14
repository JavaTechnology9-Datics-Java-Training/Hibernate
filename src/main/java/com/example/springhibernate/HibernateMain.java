package com.example.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        //configuration.configure(new File("C:\\Users\\SURESH\\IdeaProjects\\Spring-core\\src\\hibernate.cfg.xml"));
        //configuration.configure("hibernate.cfg.xml");
        configuration.addResource("Message.hbm.xml");
        configuration.addResource("Category.hbm.xml");
        //configuration.addClass(com.example.springhibernate.Message.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        /*Message message1 = session.get(Message.class, 5L);
        Message message=new Message("using log4j2.properties");
        message.setNextMessage(message1);*/


        Category parentCategory=new Category();
        parentCategory.setName("parent Category Example");
        Category childCategory=new Category();
        childCategory.setName("child category");
        parentCategory.addChildCategory(childCategory);
        session.save(parentCategory);
        transaction.commit();
        System.out.println("Inserted record successfully");
        /*childCategory.setParentCategory(parentCategory);
        parentCategory.getChildCategories().add(childCategory);*/
        //System.exit(1);
    }
}
