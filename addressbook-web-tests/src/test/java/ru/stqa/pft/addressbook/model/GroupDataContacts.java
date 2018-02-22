package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDataContacts {

  private int id = Integer.MAX_VALUE;
  private String name;
  private String middle;
  private String lastname;
  private String nickname;
  private String company;
  private String address;
  private String phone;
  private String phonemobile;
  private String workphone;
  private String email;
  private String testemail;
  private String homepagetest;
  private String address2;
  private String testphone2;
  private String group;
  private String notes;

  public GroupDataContacts withId(int id) {
    this.id = id;
    return this;
  }

  public GroupDataContacts withName(String name) {
    this.name = name;
    return this;
  }

  public GroupDataContacts withMiddle(String middle) {
    this.middle = middle;
    return this;
  }

  public GroupDataContacts withLastname(String lastname) {
    this.lastname = lastname;
    return this;
  }

  public GroupDataContacts withNickname(String nickname) {
    this.nickname = nickname;
    return this;
  }

  public GroupDataContacts withCompany(String company) {
    this.company = company;
    return this;
  }

  public GroupDataContacts withAddress(String address) {
    this.address = address;
    return this;
  }

  public GroupDataContacts withPhone(String phone) {
    this.phone = phone;
    return this;
  }

  public GroupDataContacts withPhonemobile(String phonemobile) {
    this.phonemobile = phonemobile;
    return this;
  }

  public GroupDataContacts withWorkphone(String workphone) {
    this.workphone = workphone;
    return this;
  }

  public GroupDataContacts withEmail(String email) {
    this.email = email;
    return this;
  }

  public GroupDataContacts withTestemail(String testemail) {
    this.testemail = testemail;
    return this;
  }

  public GroupDataContacts withHomepagetest(String homepagetest) {
    this.homepagetest = homepagetest;
    return this;
  }

  public GroupDataContacts withAddress2(String address2) {
    this.address2 = address2;
    return this;
  }

  public GroupDataContacts withTestphone2(String testphone2) {
    this.testphone2 = testphone2;
    return this;
  }

  public GroupDataContacts withGroup(String group) {
    this.group = group;
    return this;
  }

  public GroupDataContacts withNotes(String notes) {
    this.notes = notes;
    return this;
  }

//  public GroupDataContacts(String name, String middle, String lastname, String nickname, String company, String address, String phone, String phonemobile, String email, String testemail, String homepagetest, String address2, String testphone2, String group, String notes) {
//    this.id = Integer.MAX_VALUE;
//    this.name = name;
//    this.middle = middle;
//    this.lastname = lastname;
//    this.nickname = nickname;
//    this.company = company;
//    this.address = address;
//    this.phone = phone;
//    this.phonemobile = phonemobile;
//    this.email = email;
//    this.testemail = testemail;
//    this.homepagetest = homepagetest;
//    this.address2 = address2;
//    this.testphone2 = testphone2;
//    this.group = group;
//    this.notes = notes;
//  }
//
//  public GroupDataContacts(int id, String name, String middle, String lastname, String nickname, String company, String address, String phone, String phonemobile, String email, String testemail, String homepagetest, String address2, String testphone2, String group, String notes) {
//    this.id = id;
//    this.name = name;
//    this.middle = middle;
//    this.lastname = lastname;
//    this.nickname = nickname;
//    this.company = company;
//    this.address = address;
//    this.phone = phone;
//    this.phonemobile = phonemobile;
//    this.email = email;
//    this.testemail = testemail;
//    this.homepagetest = homepagetest;
//    this.address2 = address2;
//    this.testphone2 = testphone2;
//    this.group = group;
//    this.notes = notes;
//  }

  public int getId() { return id; }

  public String getName() {
    return name;
  }

  public String getMiddle() {
    return middle;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getCompany() {
    return company;
  }

  public String getAddress() {
    return address;
  }

  public String getPhone() {
    return phone;
  }

  public String getPhonemobile() {
    return phonemobile;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDataContacts that = (GroupDataContacts) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(lastname, that.lastname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, lastname);
  }

  @Override
  public String toString() {
    return "GroupDataContacts{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getWorkphone() { return workphone; }

  public String getEmail() {
    return email;
  }

  public String getTestemail() {
    return testemail;
  }

  public String getHomepagetest() {
    return homepagetest;
  }

  public String getAddress2() {
    return address2;
  }

  public String getTestphone2() {
    return testphone2;
  }

  public String getGroup() { return group; }

  public String getNotes() {
    return notes;
  }

}
