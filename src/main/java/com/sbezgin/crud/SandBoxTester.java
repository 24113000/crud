package com.sbezgin.crud;

import com.sbezgin.crud.db.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.Metadata;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.model.naming.ImplicitNamingStrategyJpaCompliantImpl;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import javax.jws.soap.SOAPBinding;

/**
 * Created by sergii.bezgin on 03.12.2015.
 * It is my class ha-ha-ha
 */
public class SandBoxTester {
    public static void main(String[] args) {
        StandardServiceRegistry standardRegistry = new StandardServiceRegistryBuilder()
                .configure("hibernateConf.xml")
                .build();

        Metadata metadata = new MetadataSources(standardRegistry)
                .addAnnotatedClass(User.class)
                .getMetadataBuilder()
                .applyImplicitNamingStrategy(ImplicitNamingStrategyJpaCompliantImpl.INSTANCE)
                .build();

        SessionFactory sessionFactory = metadata.getSessionFactoryBuilder().build();
        Session session = sessionFactory.openSession();
        /*User user = new User();
        user.setEmail("bla@bla.com");
        user.setUserName("test_name");
        session.save(user);*/
        User user = session.get(User.class, 1);

        session.close();
    }
}
