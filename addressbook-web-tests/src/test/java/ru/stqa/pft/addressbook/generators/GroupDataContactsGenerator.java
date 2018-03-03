package ru.stqa.pft.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataContactsGenerator {

  @Parameter(names = "-c", description = "Contact count")
  public int count;

  @Parameter (names = "-f", description = "Target file")
  public String file;

  @Parameter (names = "-d", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    GroupDataContactsGenerator generator = new GroupDataContactsGenerator();
    JCommander JCommander = new JCommander (generator);
    try {
      JCommander.parse(args);
    } catch (ParameterException ex) {
      JCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<GroupDataContacts> contacts = generateContacts(count);
    if (format.equals("csv")){
      saveAsCsv (contacts, new File(file));
    }else if (format.equals("xml")) {
      saveAsXml (contacts, new File(file));
    }else{
      System.out.println("Unrecognized format " + format);
    }
  }

  private void saveAsXml(List<GroupDataContacts> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.alias("contact", GroupDataContacts.class);
    xstream.processAnnotations(GroupDataContacts.class);
    String xml = xstream.toXML(contacts);
    try (Writer writer = new FileWriter(file)){
      writer.write(xml);
    }
  }

  private void saveAsCsv(List<GroupDataContacts> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupDataContacts contact : contacts){
      writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getLastname(),
              contact.getMiddle(), contact.getCompany(), contact.getAddress(),
              contact.getEmail(), contact.getPhone()));
    }
    writer.close();
  }

  private List<GroupDataContacts> generateContacts(int count) {
    List<GroupDataContacts> contacts = new ArrayList<GroupDataContacts>();
    for (int i = 0; i < count; i++){
      contacts.add(new GroupDataContacts().withName(String.format("testName %s", i))
              .withMiddle(String.format("testMiddle %s", i))
              .withLastname(String.format("testLastname %s", i))
              .withCompany(String.format("testCompany %s", i))
              .withAddress(String.format("testAddress %s", i))
              .withEmail(String.format("test@gmail.com %s", i))
              .withPhone(String.format("11111 %s", i)));
    }
    return contacts;
  }
}
