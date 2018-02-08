package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

public class GroupContactsModification extends TestBase{
  @Test
  public void testContactsModification () {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getGroupHelper().getContactsCount();
    if (! app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes"), true);
    }
    app.getGroupHelper().selectContact(before - 1);
    app.getGroupHelper().initContactsModification();
    app.getGroupHelper().fillContactsForm(new GroupDataContacts("TName3", "TestMiddleName3", "TestLastName1", "testNickname1", "testCompany1", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", null,"testNotes"),false);
    app.getGroupHelper().submitContactsModification();
    app.getGroupHelper().returnToHomePage();
    int after = app.getGroupHelper().getContactsCount();
    Assert.assertEquals(after, before);
  }
}
