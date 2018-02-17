package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.util.List;

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
    List<GroupDataContacts> before = app.group().getContactsList();
    int index = before.size() - 1;
    app.group().deleteCont(index);
    List<GroupDataContacts> after = app.group().getContactsList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(index);
    Assert.assertEquals(before, after);
  }

}
