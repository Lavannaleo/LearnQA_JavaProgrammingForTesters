package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;
import java.util.Set;

public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensureContact() {
    app.contact().returnToContactsList();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress2("Moscow, Red Square, 3").withPhone2("+79998887766"));
    }
    app.contact().returnToContactsList();
  }

  @Test (enabled = true)
  public void testContactModification() {
    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();
    ContactData contact = new ContactData().withId(modifiedContact.getId()).withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress2("Moscow, Red Square, 3").withPhone2("+79998887766");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();
    Assert.assertEquals(after.size(), before.size());
    before.remove(modifiedContact);
    before.add(contact);
    Assert.assertEquals(after, before);
  }
}
