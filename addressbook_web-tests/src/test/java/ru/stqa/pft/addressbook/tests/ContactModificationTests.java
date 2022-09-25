package ru.stqa.pft.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test (enabled = false)
  public void testContactModification() {
    app.getContactHelper().returnToContactsList();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Anna", "Maria", "Leonidova", "Leo", "lll@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887766"));
    }
    app.getContactHelper().returnToContactsList();
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().selectContact(before - 1);
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Annabella", "", "Leonova", "Leo", "lllwww@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887476"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactsList();
    int after = app.getContactHelper().getContactCount();

    Assert.assertEquals(after, before);
    app.logout();

  }
}
