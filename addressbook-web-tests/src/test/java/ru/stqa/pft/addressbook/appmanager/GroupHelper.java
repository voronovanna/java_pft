package ru.stqa.pft.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.pft.addressbook.model.Contacts;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.GroupDataContacts;
import ru.stqa.pft.addressbook.model.Groups;

import java.util.ArrayList;
import java.util.List;

public class GroupHelper extends HelperBase {

  public GroupHelper(WebDriver wd) {
    super(wd);
  }

  public void returnToGroupPage() {
    click(By.linkText("group page"));
  }

  public void submitGroupCreation() {
    click(By.name("submit"));
  }

  public void fillGroupForm(GroupData groupData) {
    type(By.name("group_name"), groupData.getName());
    type(By.name("group_header"), groupData.getHeader());
    type(By.name("group_footer"), groupData.getFooter());
  }

  public void initGroupCreation() {
    click(By.name("new"));
  }

  public void deleteSelectedGroups() {
    click(By.name("delete"));
  }

  public void selectGroupById(int id) {
    wd.findElement(By.cssSelector("input[value='"+ id +"']")).click();
  }

  public void submitContactsCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void fillContactsForm(GroupDataContacts groupDataContacts, boolean creation) {
    field(By.name("firstname"), groupDataContacts.getName());
    field(By.name("middlename"), groupDataContacts.getMiddle());
    field(By.name("lastname"), groupDataContacts.getLastname());
    field(By.name("nickname"), groupDataContacts.getNickname());
    attach(By.name("photo"), groupDataContacts.getPhoto());
    field(By.name("company"), groupDataContacts.getCompany());
    field(By.name("address"), groupDataContacts.getAddress());
    field(By.name("home"), groupDataContacts.getPhone());
    field(By.name("mobile"), groupDataContacts.getPhonemobile());
    field(By.name("email"), groupDataContacts.getEmail());
    field(By.name("email"), groupDataContacts.getTestemail());
    field(By.name("homepage"), groupDataContacts.getHomepagetest());
    field(By.name("address2"), groupDataContacts.getAddress2());
//  field(By.name("phone2"), groupDataContacts.getTestphone2());
    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(groupDataContacts.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }
    field(By.name("notes"), groupDataContacts.getNotes());
  }

  public void submitGroupModification() {
    click(By.name("update"));
  }

  public void initGroupModification() { click(By.name("edit")); }

  public void getIndexContact(int index) {
    wd.findElements(By.name("selected[]")).get(index);
  }

  public void selectContact(int index) {
    wd.findElements(By.name("selected[]")).get(index).click();
   }

  public void selectContactById(int id) { wd.findElement(By.cssSelector("input[value='"+ id +"']")).click(); }

  public void acceptAlert() {
    wd.switchTo().alert().accept();
  }

  public void deleteSelectedContacts() {
    click(By.xpath("//div[@id='content']/form[2]/div[2]/input"));
  }

  public void initContactsModification(int id) {
    wd.findElement(By.cssSelector("[href=\"edit.php?id="+ id +"\"]")).click();
  }

  public void submitContactsModification() {
    click(By.name("update"));
  }

  public void returnToHomePage() {
    click(By.linkText("home"));
  }

  public void create(GroupData group) {
    initGroupCreation();
    fillGroupForm(group);
    submitGroupCreation();
    groupCache = null;
    returnToGroupPage();
  }

  public void modify(GroupData group) {
    selectGroupById(group.getId());
    initGroupModification();
    fillGroupForm(group);
    submitGroupModification();
    groupCache = null;
    returnToGroupPage();
  }

  public boolean isThereAGroup() {
    return isElementPresent(By.name("selected[]"));
  }

  public void createContacts(GroupDataContacts groupContacts, boolean b) {
    initContactCreation();
    fillContactsForm(groupContacts, true);
    submitContactsCreation();
    returnToHomePage();
  }

  public void modifyContact(GroupDataContacts contact) {
    initContactsModification(contact.getId());
    fillContactsForm(contact,false);
    submitContactsModification();
    returnToHomePage();
  }

  public void deleteCont(int index) {
    selectContact(index);
    deleteSelectedContacts();
    acceptAlert();
    returnToHomePage();
  }

  public void deleteCont(GroupDataContacts contact) {
    selectContactById(contact.getId());
    deleteSelectedContacts();
    acceptAlert();
    returnToHomePage();
  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));
  }

  public int count() {
    return wd.findElements(By.name("selected[]")).size();
  }

  private Groups groupCache = null;

  public Groups all() {
    if (groupCache != null){
      return new Groups(groupCache);
    }
    groupCache = new Groups();
    List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
    for (WebElement element: elements){
      String name = element.getText();
      int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
      groupCache.add(new GroupData().withId(id).withName(name));
    }
    return new Groups (groupCache);
  }

  public List<GroupDataContacts> getContactsList() {
    List<GroupDataContacts> contacts = new ArrayList<GroupDataContacts>();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element:elements){
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      contacts.add(new GroupDataContacts().withId(id).withName(name).withLastname(lastname));
    }
    return contacts;
  }

  public Contacts allCont() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element:elements){
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      contacts.add(new GroupDataContacts().withId(id).withName(name).withLastname(lastname));
    }
    return contacts;
  }

  public Contacts allContTests() {
    Contacts contacts = new Contacts();
    List<WebElement> elements = wd.findElements(By.name("entry"));
    for (WebElement element:elements){
      String name = element.findElement(By.cssSelector("td:nth-child(3)")).getText();
      String lastname = element.findElement(By.cssSelector("td:nth-child(2)")).getText();
      String address = element.findElement(By.cssSelector("td:nth-child(4)")).getText();
//    String phone = element.findElement(By.name("phone")).getText();
//    String mobilephone = element.findElement(By.name("mobilephone")).getText();
//    String workphone = element.findElement(By.name("workphone")).getText();
      String email = element.findElement(By.cssSelector("td:nth-child(5)")).getText();
      String allPhones = element.findElement(By.cssSelector("td:nth-child(6)")).getText();
      int id = Integer.parseInt(element.findElement(By.name("selected[]")).getAttribute("value"));
      contacts.add(new GroupDataContacts().withId(id).withName(name).withLastname(lastname)
              .withAddress(address).withEmail(email).withAllPhones(allPhones));
    }
    return contacts;
  }

  /**public Contacts allCont2() {
    Contacts contacts = new Contacts();
    List<WebElement> rows = wd.findElements(By.name("entry"));
    for (WebElement row : rows){
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.name("input")).getAttribute("value"));
      String name = cells.get(1).getText();
      String lastname = cells.get(2).getText();
      String address = cells.get(3).getText();
      String email = cells.get(4).getText();
      String[] phones = cells.get(5).getText().split("\n");
      contacts.add(new GroupDataContacts().withId(id).withName(name).withLastname(lastname).withAddress(address)
              .withEmail(email).withPhone(phones[0]).withPhonemobile(phones[1]).withWorkphone(phones[2]));
    }
    return contacts;
  }**/

  public int getContactsCount() {
    return wd.findElements(By.name("selected[]")).size();
  }

  public void delete(GroupData group) {
    selectGroupById(group.getId());
    deleteSelectedGroups();
    groupCache = null;
    returnToGroupPage();
  }

  public GroupDataContacts infoFromEditForm(GroupDataContacts contact) {
    initContactModificationById(contact.getId());
    String name = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String workphone = wd.findElement(By.name("work")).getAttribute("value");
    String email = wd.findElement(By.name("email")).getAttribute("value");
    wd.navigate().back();
    return new GroupDataContacts().withId(contact.getId()).withName(name).withLastname(lastname)
    .withAddress(address).withPhone(home).withPhonemobile(mobile).withWorkphone(workphone).withEmail(email);
  }

  private void initContactModificationById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']",id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();
  }

}
