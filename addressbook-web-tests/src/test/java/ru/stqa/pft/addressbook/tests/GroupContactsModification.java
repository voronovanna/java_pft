package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupContactsModification extends TestBase{

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
//  if (! app.group().isThereAContact()){
//  if (app.group().allCont().size()==0){
    if (app.db().contacts().size()== 0){
      app.group().createContacts(new GroupDataContacts().withName("Name").withMiddle("MiddleName").withLastname("LastName").withNickname(null).withCompany("Company").withAddress("Address").withPhone("testPhoneHome").withPhonemobile(null).withEmail("testemail.com").withTestemail(null).withHomepagetest(null).withAddress2(null).withTestphone2(null).withGroup(null).withNotes(null), false);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactsModification () {
    Contacts before = app.db().contacts();
//  Contacts before = app.group().allCont();
    GroupDataContacts modifiedContact = before.iterator().next();
    GroupDataContacts contact = new GroupDataContacts()
            .withId(modifiedContact.getId()).withName("Name").withMiddle("MiddleName").withLastname("LastName").withNickname(null).withCompany("Company").withAddress("Address").withPhone("testPhoneHome").withPhonemobile(null).withEmail("testemail.com").withTestemail(null).withHomepagetest(null).withAddress2(null).withTestphone2(null).withGroup(null).withNotes(null);
    app.goTo().gotoHomePage();
    app.group().modifyContact(contact);
    Contacts after = app.db().contacts();
//  Contacts after = app.group().allCont();
    assertEquals(after.size(),before.size());
    assertThat(after, equalTo(before.without(modifiedContact).withAdded(contact)));
    }

}
