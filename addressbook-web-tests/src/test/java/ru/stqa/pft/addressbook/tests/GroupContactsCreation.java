package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.List;

public class GroupContactsCreation extends TestBase{

  @Test
  public void testGroupContactsCreation () {
    app.getNavigationHelper().gotoHomePage();
    List<GroupDataContacts> before = app.getGroupHelper().getContactsList();
    app.gotoContactsCreationPage();
    app.getGroupHelper().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes" ), true);
    List<GroupDataContacts> after = app.getGroupHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);
  }

}
