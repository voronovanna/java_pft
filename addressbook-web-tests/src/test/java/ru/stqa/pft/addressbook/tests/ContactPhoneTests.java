package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (app.group().allCont().size()==0){
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("1111").withPhonemobile("22222").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2(null).withTestphone2(null).withGroup("test1").withNotes(null), true);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactPhones(){
    app.goTo().gotoHomePage();
    GroupDataContacts contact = app.group().allCont().iterator().next();
    GroupDataContacts contactInfoFromEditForm = app.group().infoFromEditForm(contact);
  }
}
