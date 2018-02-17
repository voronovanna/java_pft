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
      app.group().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes"), true);
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
