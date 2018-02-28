package ru.stqa.pft.addressbook.tests;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.List;

public class HbConnectionTest {

  private SessionFactory sessionFactory;

  @BeforeClass
  protected void setUp() throws Exception {
    // A SessionFactory is set up once for an application
    final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
            .configure()
            .build();
    try {
      sessionFactory = new MetadataSources( registry ).buildMetadata().buildSessionFactory();
    }
    catch (Exception e) {
      e.printStackTrace();
      StandardServiceRegistryBuilder.destroy (registry);
    }
  }

  @Test
  public void testHbConnection(){
    Session session = sessionFactory.openSession();
    session.beginTransaction();
    List<GroupDataContacts> result = session.createQuery( "from GroupDataContacts where deprecated = '0000-00-00'").list();
//  for ( GroupDataContacts contact : result ) {
//    System.out.println( contact );
//  }
    session.getTransaction().commit();
    session.close();
  }
}
