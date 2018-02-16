package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.HashSet;
import java.util.List;

public class GroupContactsCreation extends TestBase{

  @Test
  public void testGroupContactsCreation () {
    app.getNavigationHelper().gotoHomePage();
    List<GroupDataContacts> before = app.getGroupHelper().getContactsList();
    GroupDataContacts contact = new GroupDataContacts("TName3", "TestMiddleName3", "TestLastName1", "testNickname1", "testCompany1", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes");
    app.gotoContactsCreationPage();
    app.getGroupHelper().createContacts(contact, true);
    List<GroupDataContacts> after = app.getGroupHelper().getContactsList();
    Assert.assertEquals(after.size(), before.size() + 1);

    int max=0;
    for (GroupDataContacts g: after){
      if (g.getId()>max){
        max = g.getId();
      }
    }
    contact.setId(max);
    before.add(contact);
    Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));
  }

}
