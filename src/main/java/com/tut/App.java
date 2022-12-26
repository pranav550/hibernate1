package com.tut;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws IOException
    {
        System.out.println( "Hello World!" );
        Configuration cfg = new Configuration();
        cfg.configure("hibernate.cfg.xml");
        SessionFactory factory = cfg.buildSessionFactory();
        
        System.out.println(factory);
        System.out.println(factory.isClosed());
        
        
        // Student  object
        Student st = new Student();
        st.setId(102);
        st.setName("Amit");
        st.setCity("Delhi");
        
        System.out.println(st);
        
        
        // Address Object of class
        Address ad = new Address();
        ad.setStreet("Street1");
        ad.setCity("Delhi");
        ad.setOpen(true);
        ad.setAddedDate(new Date());
        ad.setX(123.122);
        
        
        //Read image
        
        FileInputStream fis = new FileInputStream("src/main/java/pic1.jpg");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        ad.setImage(data);
        
        
        Session session = factory.openSession();
        Transaction tx =session.beginTransaction();
        session.save(st);
        session.save(ad);
        
        tx.commit();
        session.close();
        System.out.println("Done");
    }
}
