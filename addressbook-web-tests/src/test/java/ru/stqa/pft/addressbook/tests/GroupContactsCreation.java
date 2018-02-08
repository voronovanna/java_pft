package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

public class GroupContactsCreation extends TestBase{

  @Test
  public void testGroupContactsCreation () {
    app.getNavigationHelper().gotoHomePage();
    int before = app.getGroupHelper().getContactsCount();
    app.gotoContactsCreationPage();
    app.getGroupHelper().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes" ), true);
    int after = app.getGroupHelper().getContactsCount();
    Assert.assertEquals(after, before + 1);
  }

}
