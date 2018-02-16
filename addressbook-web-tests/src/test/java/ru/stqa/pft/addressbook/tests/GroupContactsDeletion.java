package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.List;

public class GroupContactsDeletion extends TestBase{
  @Test
  public void testContactsDeletion () {
    app.goTo().gotoHomePage();
    if (! app.group().isThereAContact()){
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup("test1").withNotes("testNotes"), true);
    }
    List<GroupDataContacts> before = app.group().getContactsList();
    app.group().selectContact(before.size() - 1);
    app.group().deleteSelectedContacts();
    app.group().acceptAlert();
    app.goTo().gotoHomePage();
    List<GroupDataContacts> after = app.group().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);
  }

  }
