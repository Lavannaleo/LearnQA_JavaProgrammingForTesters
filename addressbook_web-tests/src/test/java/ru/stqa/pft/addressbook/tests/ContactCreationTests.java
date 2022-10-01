package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;


public class ContactCreationTests extends TestBase{

  @Test (enabled = true)
  public void testContactCreation() {
    app.contact().returnToContactsList();
    Set<ContactData> before = app.contact().all();
    ContactData contact = new ContactData().withFirstname("Anna").withLastname("Maria").withMiddlename("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1989").withAddress2("Moscow, Red Square, 3").withPhone2("+79998887766");
    app.contact().create(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size() +1);
    before.add(contact);
    contact.withId(after.stream().mapToInt((g) ->g.getId()).max().getAsInt());
    Assert.assertEquals(after, before);
  }
}
