package com.example.springhibernate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import java.awt.*;
import java.util.Date;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        //configuration.configure(new File("C:\\Users\\SURESH\\IdeaProjects\\Spring-core\\src\\hibernate.cfg.xml"));
        //configuration.configure("hibernate.cfg.xml");
        //configuration.addResource("Message.hbm.xml");
        //configuration.addResource("Category.hbm.xml");
        //configuration.addResource("User.hbm.xml");
        //configuration.addResource("CreditCard.hbm.xml");
        configuration.addResource("BillingDetails.hbm.xml");
        configuration.setPhysicalNamingStrategy(new HINamingStrategy());
        //configuration.addClass(com.example.springhibernate.Message.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        /*Message message1 = session.get(Message.class, 5L);
        Message message=new Message("using log4j2.properties");
        message.setNextMessage(message1);*/


        /*Category parentCategory=new Category();
        parentCategory.setName("parent Category Example 2");
        Category childCategory=new Category();
        childCategory.setName("child category 2");
        parentCategory.addChildCategory(childCategory);*/

        /*User user=new User();
        Address homeAddress=new Address();
        Address billingAddress=new Address();
        user.setUsername("hibernate_user");
        homeAddress.setCity("Hyderabad");
        homeAddress.setStreet("hi-tech city");
        homeAddress.setZipcode("500074");

        billingAddress.setStreet("Royal Meenakshi Mall");
        billingAddress.setCity("Bangalore");
        billingAddress.setZipcode("600012");
        user.setHomeAddress(homeAddress);
        user.setBillingAddress(billingAddress);*/

        /*CreditCard creditCard=new CreditCard();
        creditCard.setOwner("Money_back_Credit_Card");
        creditCard.setNumber("741-852-963");
        creditCard.setType("Indian-Oil");
        creditCard.setExpMonth("Feb");
        creditCard.setExpYear("2036");
        creditCard.setDate(new Date());*/

        BankAccount bankAccount=new BankAccount();
        bankAccount.setDate(new Date());
        bankAccount.setNumber("124-745-968");
        bankAccount.setOwner("HDFC-BANK");
        bankAccount.setAccountNumber("5010045874");
        bankAccount.setBankName("HDFC-BANK");
        session.save(bankAccount);
        transaction.commit();
        System.out.println("Inserted record successfully");
        /*childCategory.setParentCategory(parentCategory);
        parentCategory.getChildCategories().add(childCategory);*/
        //System.exit(1);
    }
}
