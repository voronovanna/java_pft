package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

public class GroupContactsDeletion extends TestBase{
  @Test
  public void testContactsDeletion () {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes"), true);
    }
    app.getGroupHelper().selectContact();
    app.getGroupHelper().deleteSelectedContacts();
    app.getGroupHelper().acceptAlert();
  }

  }
