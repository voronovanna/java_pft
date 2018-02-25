package ru.stqa.pft.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class GroupContactsCreation extends TestBase{

  @DataProvider
  public Iterator<Object[]> validContacts() throws IOException {
    try(BufferedReader reader = new BufferedReader(new FileReader(new File(app.properties.getProperty("web.resourcesContactsUrl"))))){
    String xml = "";
    String line = reader.readLine();
    while (line != null){
      xml += line;
      line = reader.readLine(); }
    XStream xstream = new XStream();
    xstream.processAnnotations(GroupDataContacts.class);
    List<GroupDataContacts> contacts = (List<GroupDataContacts>) xstream.fromXML(xml);
    return contacts.stream().map((d) -> new Object[] {d}).collect(Collectors.toList()).iterator();
  }}

  @Test (dataProvider = "validContacts")
  public void testGroupContactsCreation (GroupDataContacts contact) {
    app.goTo().gotoHomePage();
    Contacts before = app.group().allCont();
//  File photo = new File("src/test/resources/stru.jpg");
//  GroupDataContacts contact = new GroupDataContacts().withName("TName3").withMiddle("Middle").withLastname("TestLastName1").withNickname("testNickname1").withCompany("testCompany1").withAddress("testAddress").withPhone("444").withPhonemobile("555").withEmail("testemail.com").withTestemail("testemail@i.com").withHomepagetest("testHomepage").withAddress2("testAddress2").withPhoto(photo).withGroup("test1").withNotes("testNotes");
    app.gotoContactsCreationPage();
    app.group().createContacts(contact, false);
    Contacts after = app.group().allCont();
    assertThat(after.size(), equalTo(before.size() + 1));

    assertThat(after, equalTo(
            before.withAdded(contact.withId(after.stream().mapToInt((g)->g.getId()).max().getAsInt()))));
  }

/**  @Test
  public void testCurrentDir(){
    File currentDir = new File(".");
    System.out.println(currentDir.getAbsolutePath());
    File photo = new File("src/test/resources/stru.jpg");
    System.out.println(photo.getAbsolutePath());
    System.out.println(photo.exists());
  }**/
}
