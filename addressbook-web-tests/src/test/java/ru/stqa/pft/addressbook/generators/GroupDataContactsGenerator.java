package ru.stqa.pft.addressbook.generators;
import ru.stqa.pft.addressbook.model.GroupDataContacts;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class GroupDataContactsGenerator {

  public static void main(String[] args) throws IOException {
    int count = Integer.parseInt(args [0]);
    File file = new File(args[1]);

    List<GroupDataContacts> contacts = generateContacts(count);
    save (contacts, file);
  }

  private static void save(List<GroupDataContacts> contacts, File file) throws IOException {
    System.out.println(new File(".").getAbsolutePath());
    Writer writer = new FileWriter(file);
    for (GroupDataContacts contact : contacts){
      writer.write(String.format("%s;%s;%s\n", contact.getName(), contact.getLastname(), contact.getAddress()));
    }
    writer.close();
  }

  private static List<GroupDataContacts> generateContacts(int count) {
    List<GroupDataContacts> contacts = new ArrayList<GroupDataContacts>();
    for (int i = 0; i < count; i++){
      contacts.add(new GroupDataContacts().withName(String.format("testName %s", i))
              .withLastname(String.format("testLastname %s", i)).withAddress(String.format("testAddress %s", i)));
    }
    return contacts;
  }
}
