package ru.stqa.pft.addressbook.tests;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class ContactEmailTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions(){
    app.goTo().gotoHomePage();
    if (app.group().allCont().size()==0){
      app.group().createContacts(new GroupDataContacts().withName("TName3").withMiddle("TestMiddleName3").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("1111").withPhonemobile("222").withWorkphone("333").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2(null).withTestphone2(null).withNotes(null), true);
      app.goTo().gotoHomePage();
    }
  }

  @Test
  public void testContactEmail(){
    app.goTo().gotoHomePage();
    GroupDataContacts contact = app.group().allContTests().iterator().next();
    GroupDataContacts contactInfoFromEditForm = app.group().infoFromEditForm(contact);
    assertThat(contact.getEmail(), equalTo(cleaned(contactInfoFromEditForm.getEmail())));

  }

  public static String cleaned(String email){
    return email.replaceAll("\\s","");
  }
}