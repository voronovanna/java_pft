package ru.stqa.pft.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.List;
import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class GroupContactsDeletion extends TestBase{

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
  public void testContactsDeletion () {
    Contacts before = app.group().allCont();
    GroupDataContacts deletedContact = before.iterator().next();
//  int index = before.size() - 1;
    app.group().deleteCont(deletedContact);
    Contacts after = app.group().allCont();
    assertEquals(after.size(), before.size() - 1);

//  before.remove(deletedContact);
//  Assert.assertEquals(before, after);
    assertThat(after, equalTo(before.without(deletedContact)));
  }

}
