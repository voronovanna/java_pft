package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class GroupDataContacts {
  private final String id;
  private final String name;
  private final String middle;
  private final String lastname;
  private final String nickname;
  private final String company;
  private final String address;
  private final String phone;
  private final String phonemobile;
  private final String email;
  private final String testemail;

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDataContacts that = (GroupDataContacts) o;
    return Objects.equals(id, that.id) &&
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
            "id='" + id + '\'' +
            ", name='" + name + '\'' +
            ", lastname='" + lastname + '\'' +
            '}';
  }

  public String getId() {
    return id;
  }

  private final String homepagetest;
  private final String address2;
  private final String testphone2;
  private String group;
  private final String notes;

  public GroupDataContacts(String name, String middle, String lastname, String nickname, String company, String address, String phone, String phonemobile, String email, String testemail, String homepagetest, String address2, String testphone2, String group, String notes) {
    this.id = null;
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.phonemobile = phonemobile;
    this.email = email;
    this.testemail = testemail;
    this.homepagetest = homepagetest;
    this.address2 = address2;
    this.testphone2 = testphone2;
    this.group = group;
    this.notes = notes;
  }

  public GroupDataContacts(String id, String name, String middle, String lastname, String nickname, String company, String address, String phone, String phonemobile, String email, String testemail, String homepagetest, String address2, String testphone2, String group, String notes) {
    this.id = id;
    this.name = name;
    this.middle = middle;
    this.lastname = lastname;
    this.nickname = nickname;
    this.company = company;
    this.address = address;
    this.phone = phone;
    this.phonemobile = phonemobile;
    this.email = email;
    this.testemail = testemail;
    this.homepagetest = homepagetest;
    this.address2 = address2;
    this.testphone2 = testphone2;
    this.group = group;
    this.notes = notes;
  }

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
