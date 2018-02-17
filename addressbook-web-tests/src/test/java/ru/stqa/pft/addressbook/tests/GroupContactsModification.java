package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.Comparator;
import java.util.List;

public class GroupContactsModification extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
//    if (! app.group().isThereAContact()){
      if (app.group().allCont().size()==0){
        app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup("test1").withNotes("testNotes"), true);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactsModification () {
    List<GroupDataContacts> before = app.group().getContactsList();
    int index = before.size()-1;
    GroupDataContacts contact = new GroupDataContacts()
            .withId(before.get(index).getId()).withName("TName18").withMiddle("TestMiddleName18").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("testPhoneHome").withPhonemobile("testMobile").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withTestphone2("testHome2").withGroup(null).withNotes("testNotes");
    app.group().modifyContact(contact);
    List<GroupDataContacts> after = app.group().getContactsList();
    Assert.assertEquals(after.size(),before.size());

    before.remove(index);
    before.add(contact);
    Comparator<? super GroupDataContacts> byId = (g1, g2)->Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);
    }

}
