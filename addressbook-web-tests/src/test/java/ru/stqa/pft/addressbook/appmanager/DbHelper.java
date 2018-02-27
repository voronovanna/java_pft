package ru.stqa.pft.addressbook.appmanager;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.List;

public class DbHelper {

  private final SessionFactory sessionFactory;

  public DbHelper() {

    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
      sessionFactory = new MetadataSources(registry).buildMetadata().buildSessionFactory();
  }

  public Groups groups(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupData> result = session.createQuery( "from GroupData").list();
    session.getTransaction().commit();
    session.close();
    return new Groups (result);
  }

  public Contacts contacts(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupDataContacts> result = session.createQuery( "from GroupDataContacts where deprecated = '0000-00-00'").list();
    for ( GroupDataContacts contact : result ) {
      System.out.println( contact );
    }
    session.getTransaction().commit();
    session.close();
    return new Contacts (result);
  }

}

