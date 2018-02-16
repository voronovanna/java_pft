package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.Comparator;
import java.util.List;

public class GroupContactsModification extends TestBase{
  @Test
  public void testContactsModification () {
    app.goTo().gotoHomePage();
    if (! app.group().isThereAContact()){
//    app.group().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes"), true);
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup("test1").withNotes("testNotes"), true);
      app.goTo().gotoHomePage();
    }
    List<GroupDataContacts> before = app.group().getContactsList();
//  app.group().getIndexContact(before.size()-1);
    app.group().initContactsModification();
//  GroupDataContacts contact = new GroupDataContacts(before.get(before.size()-1).getId(),"TName15", "TestMiddleName4", "TestLastName1", "testNickname1", "testCompany1", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", null,"testNotes");
    GroupDataContacts contact = new GroupDataContacts()
            .withId(before.get(before.size()-1).getId()).withName("TName18").withMiddle("TestMiddleName18").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup(null).withNotes("testNotes");
    app.group().fillContactsForm(contact,false);
    app.group().submitContactsModification();
    app.group().returnToHomePage();
    List<GroupDataContacts> after = app.group().getContactsList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super GroupDataContacts> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    }
}
