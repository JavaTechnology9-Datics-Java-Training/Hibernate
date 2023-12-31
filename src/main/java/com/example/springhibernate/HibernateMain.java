package com.example.springhibernate;

import org.hibernate.*;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;

import javax.persistence.criteria.Expression;
import java.awt.*;
import java.util.Date;
import java.util.List;
import java.util.Set;

public class HibernateMain {
    public static void main(String[] args) {

        Configuration configuration=new Configuration();
        //configuration.configure(new File("C:\\Users\\SURESH\\IdeaProjects\\Spring-core\\src\\hibernate.cfg.xml"));
        //configuration.configure("hibernate.cfg.xml");
        //configuration.addResource("Message.hbm.xml");
        configuration.addResource("Category.hbm.xml");
//        configuration.addResource("User.hbm.xml");
//        configuration.addResource("Address.hbm.xml");
        //configuration.addResource("CreditCard.hbm.xml");
        //configuration.addResource("BillingDetails.hbm.xml");
        //configuration.addResource("BankAccount.hbm.xml");
        configuration.addResource("Item.hbm.xml");
        configuration.addResource("Bid.hbm.xml");
        //configuration.addResource("Register.hbm.xml");
        configuration.setPhysicalNamingStrategy(new HINamingStrategy());
        //configuration.addClass(com.example.springhibernate.Message.class);
        SessionFactory sessionFactory = configuration.buildSessionFactory();
        Session session = sessionFactory.openSession();
        Transaction transaction = session.beginTransaction();
        /*Message message1 = session.get(Message.class, 5L);
        Message message=new Message("using log4j2.properties");
        message.setNextMessage(message1);*/
        /*Transaction transaction=null;
        try {
             transaction = session.beginTransaction();
            Category parentCategory=new Category();
            parentCategory.setName("EHCache");
            Category childCategory=new Category();
            childCategory.setName("Ehcache1");
            Category childCategory2=new Category();
            childCategory2.setName("Ehcache2");
            parentCategory.addChildCategory(childCategory);
            parentCategory.addChildCategory(childCategory2);
            session.save(parentCategory);
            //session.flush();
            transaction.commit();
            //FlushMode.COMMIT;
            Category computerCategory = session.load(Category.class, 14l,LockMode.NONE);
        }catch (Exception e){
            transaction.rollback();
        }*/
        /*Category parentCategory=new Category();
        parentCategory.setName("Many to Many");
        Category childCategory=new Category();
        childCategory.setName("Many to Many-child1");
        Category childCategory2=new Category();
        childCategory2.setName("Many to Many-child2");
        parentCategory.addChildCategory(childCategory);
        parentCategory.addChildCategory(childCategory2);

        Item item=new Item();
        item.setName("Many to Many Item");
        item.setDescription("Many to Many Item example");

        Bid bid1=new Bid();
        bid1.setAmount("963");
        bid1.setItem(item);
        Bid bid2=new Bid();
        bid2.setAmount("852");
        bid2.setItem(item);

        item.getBids().add(bid1);
        item.getBids().add(bid2);

        parentCategory.setItems(Set.of(item));
        item.setCategories(Set.of(parentCategory));
        session.save(parentCategory);
        transaction.commit();*/

        //Query query = session.createQuery("from Category c where c.name like 'Many to Many%'");
       /* List<Category> list=session.createCriteria(Category.class).add(Restrictions.like("name","Many to Many1%")).list();
        //List<Category> list = query.list();
        System.out.println(list);*/
        Query namedQuery = session.getNamedQuery("CategoryLike");
        namedQuery.setString("name","Many to Many");
        List<Category> list=namedQuery.list();
        System.out.println(list);
        /*Address address=new Address();
        address.setStreet("646 Toorak Road");
        address.setCity("Toorak");
        address.setZipcode("3000");
        User user=new User();
        user.setUsername("Address-User");
        address.setUser(user);
        user.setBillingAddress(address);
        session.save(user);
        transaction.commit();*/
        /*Category computerCategory = session.load(Category.class, 14l);
        Category childCategory=new Category();
        childCategory.setName("Laptops");
        *//*Category childCategory2=new Category();
        childCategory2.setName("Monitors");*//*
        computerCategory.addChildCategory(childCategory);
        computerCategory.addChildCategory(childCategory2);
        transaction.commit();*/
        //Query category = session.createQuery("from Category");
        /*Query category = session.createSQLQuery("select * FROM  hibernate.HI_CATEGORY");
        //category.setLong("id",12l);
        List list = category.list();
        //System.out.println(list);
        list.forEach(object->{
            if(object instanceof Object[]){
                Object[] arr=(Object[]) object;
                System.out.println(arr[1]);
            }

        });*/
        /*Criteria criteria = session.createCriteria(Item.class);
        //criteria.add(Restrictions.like("name","Computers"));
        List<Item> list = criteria.list();
        for (Item item : list) {
            System.out.println(item.getName());
            Hibernate.initialize(item.getBids());
            System.out.println(item.getBids());
        }*/

        /*Criteria criteria1 = session.createCriteria(Bid.class);
        List<Bid> list1 = criteria1.list();
        for (Bid bid : list1) {
            System.out.println(bid);
        }*/
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
        creditCard.setOwner("Table per sub class (Credit_Card)");
        creditCard.setNumber("741-852-963");
        creditCard.setType("Indian-Oil");
        creditCard.setExpMonth("Feb");
        creditCard.setExpYear("2036");
        creditCard.setDate(new Date());*/

        /*BankAccount bankAccount=new BankAccount();
        bankAccount.setDate(new Date());
        bankAccount.setNumber("124-745-968");
        bankAccount.setOwner("Table per sub class");
        bankAccount.setAccountNumber("5010045874");
        bankAccount.setBankName("HDFC-BANK");*/
        /*Item item=new Item();
        item.setName("cascade2");
        item.setDescription("cascade2 example");

        Bid bid1=new Bid();
        bid1.setAmount("123");
        bid1.setItem(item);
        Bid bid2=new Bid();
        bid2.setAmount("456");
        bid2.setItem(item);

        item.getBids().add(bid1);
        item.getBids().add(bid2);
        session.save(item);
        transaction.commit();*/
        //System.out.println("Inserted record successfully");
        /*Item item=new Item();
        Item load = session.load(Item.class, 1l);// load(ClassType, primaryKey)
        session.load(item,2l);// load(Object, primaryKey)
        Object item1 = session.load("com.example.springhibernate.Item", 3l);
        System.out.println(load);
        System.out.println(item);
        System.out.println(item1);*/
        /*Object item = session.get("com.example.springhibernate.Item", 3l);
        System.out.println(item);
        session.evict(item);*/
        /*childCategory.setParentCategory(parentCategory);
        parentCategory.getChildCategories().add(childCategory);*/
        //System.exit(1);
        /*Object item1 = session.get("com.example.springhibernate.Item", 3l);
        Object item2 = session.get("com.example.springhibernate.Item", 3l);
        if(item1==item2) System.out.println("1 and 2 items are identical");
            transaction.commit();
            session.close();
        Session session2 = sessionFactory.openSession();
        Transaction transaction1 = session2.beginTransaction();
        Object load = session2.get("com.example.springhibernate.Item", 3l);
        if(item1==load) System.out.println("1 and 2 items are identical");
        transaction1.commit();
        session2.close();*/
        /*Object item1 = session.get("com.example.springhibernate.Item", 3l);
        Object bid1 = session.get("com.example.springhibernate.Bid", 5l);
        Object bid2 = session.get("com.example.springhibernate.Bid", 6l);
        session.delete(bid1);
        session.delete(bid2);
        session.delete(item1);
        transaction.commit();
        session.close();*/
       /* Item item=new Item();
        item.setName("Inverse");
        item.setDescription("Inverse Example");

        Bid bid1=new Bid();
        bid1.setAmount("450");
        bid1.setItem(item);
        Bid bid2=new Bid();
        bid2.setAmount("750");
        bid2.setItem(item);

        item.getBids().add(bid1);
        item.getBids().add(bid2);
        session.saveOrUpdate(item);
        transaction.commit();*/
        //session.update();
        /*Register register=new Register();// new transient to persistent
        register.setFirstName("John");
        register.setLastName("Doe");
        session.save(register);
        transaction.commit();
        //session.close();
        Session session2 = sessionFactory.openSession();
        Transaction transaction2 = session2.beginTransaction();
        register.setPassword("secret123");
        register.setUsername("jonny");
        register.setLoginName("jonny_doe");
        session2.update(register);
        transaction2.commit();*/
    }
}

