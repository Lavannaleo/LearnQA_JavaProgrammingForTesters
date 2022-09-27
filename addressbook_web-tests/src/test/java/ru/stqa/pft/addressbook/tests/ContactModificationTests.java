package ru.stqa.pft.addressbook.tests;

import org.openqa.selenium.By;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTests extends TestBase{
  @BeforeMethod
  public void ensureContact() {
    app.getContactHelper().returnToContactsList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Anna", "Maria", "Leonidova", "Leo", "lll@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887766"));
    }
    app.getContactHelper().returnToContactsList();
  }

  @Test (enabled = true)
  public void testContactModification() {
    List<ContactData> before = app.getContactHelper().getContactList();
    int index = before.size()-1;
    ContactData contact = new ContactData("Annabella", "", "Leonova", "Leo", "lllwww@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887476");
    app.getContactHelper().selectContact(index);
    app.getContactHelper().initContactModification(index);
    app.getContactHelper().fillContactForm(contact);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactsList();
    List<ContactData> after = app.getContactHelper().getContactList();

    int id = Integer.parseInt(String.valueOf(before.get(index).getId()));
    contact.setId(id);
    before.remove(index);
    before.add(contact);
    Comparator<? super ContactData> byId = (c1, c2) -> Integer.compare(c1.getId(), c2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(after, before);
 //   app.logout();

  }
}
