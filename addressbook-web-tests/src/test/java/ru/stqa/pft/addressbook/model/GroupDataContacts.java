package ru.stqa.pft.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")
@Entity
@Table(name = "addressbook")
public class GroupDataContacts {
  @XStreamOmitField

  @Id
  @Column(name = "id")
  private int id = Integer.MAX_VALUE;

  @Column(name = "firstname")
  private String name;

  @Column(name = "middlename")
  private String middle;

  @Column(name = "lastname")
  private String lastname;

  @Column(name = "nickname")
  private String nickname;

  @Column(name = "company")
  private String company;

  @Column(name = "address")
  @Type(type = "text")
  private String address;

  @Column(name = "home")
  @Type(type = "text")
  private String phone;

  @Column(name = "mobile")
  @Type(type = "text")
  private String phonemobile;

  @Column(name = "work")
  @Type(type = "text")
  private String workphone;

  @Column(name = "email")
  @Type(type = "text")
  private String email;

  @Column(name = "email2")
  @Type(type = "text")
  private String testemail;

  @Column(name = "homepage")
  @Type(type = "text")
  private String homepagetest;

  @Column(name = "address2")
  @Type(type = "text")
  private String address2;

  @Column(name = "phone2")
  @Type(type = "text")
  private String testphone2;

  @Transient
  private String group;

  @Column(name = "notes")
  @Type(type = "text")
  private String notes;

  @Transient
  private String allPhones;

  @Column(name = "photo")
  @Type(type = "text")
  private String photo;

  public GroupDataContacts withPhoto(File photo) {
    this.photo = photo.getPath();
    return this;
  }

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

  public GroupDataContacts withAllPhones(String allPhones) {
    this.allPhones = allPhones;
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

  public int getId() {
    return id;
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

  public String getAllPhones() {
    return allPhones;
  }

  public File getPhoto() {
    return new File(photo);
  }

  public String getWorkphone() {
    return workphone;
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

  public String getGroup() {
    return group;
  }

  public String getNotes() {
    return notes;
  }

  @Override
  public String toString() {
    return "GroupDataContacts{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", middle='" + middle + '\'' +
            ", lastname='" + lastname + '\'' +
            ", company='" + company + '\'' +
            ", address='" + address + '\'' +
            ", phone='" + phone + '\'' +
            ", email='" + email + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    GroupDataContacts that = (GroupDataContacts) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(middle, that.middle) &&
            Objects.equals(lastname, that.lastname) &&
            Objects.equals(company, that.company) &&
            Objects.equals(address, that.address) &&
            Objects.equals(phone, that.phone) &&
            Objects.equals(email, that.email);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, middle, lastname, company, address, phone, email);
  }

}
