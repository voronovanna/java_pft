package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

public class GroupContactsModification extends TestBase{
  @Test
  public void testContactsModification () {
    app.getNavigationHelper().gotoHomePage();
    app.getGroupHelper().initContactsModification();
    app.getGroupHelper().fillContactsForm(new GroupDataContacts("TName1", "TestMiddleName1", "TestLastName1", "testNickname1", "testCompany1", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "testNotes"));
    app.getGroupHelper().submitContactsModification();
    app.getGroupHelper().returnToHomePage();
  }
}
