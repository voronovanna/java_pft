package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class GroupContactsModification extends TestBase{
  @Test
  public void testContactsModification () {
    app.getNavigationHelper().gotoHomePage();
    if (! app.getGroupHelper().isThereAContact()){
      app.getGroupHelper().createContacts(new GroupDataContacts("TName", "TestMiddleName", "TestLastName", "testNickname", "testCompany", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", "test1","testNotes"), true);
      app.getNavigationHelper().gotoHomePage();
    }
    List<GroupDataContacts> before = app.getGroupHelper().getContactsList();
    app.getGroupHelper().selectContact(before.size()-1);
    app.getGroupHelper().initContactsModification();
    GroupDataContacts contact = new GroupDataContacts(before.get(before.size()-1).getId(),"TName3", "TestMiddleName3", "TestLastName1", "testNickname1", "testCompany1", "testAddress", "testPhoneHome", "testMobile", "testemail.com", "testemail@i.com", "testHomepage", "testAddress2", "testHome2", null,"testNotes");
    app.getGroupHelper().fillContactsForm(contact,false);
    app.getGroupHelper().submitContactsModification();
    app.getGroupHelper().returnToHomePage();
    List<GroupDataContacts> after = app.getGroupHelper().getContactsList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(before.size() - 1);
    before.add(contact);
    Comparator<? super GroupDataContacts> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    }
}
