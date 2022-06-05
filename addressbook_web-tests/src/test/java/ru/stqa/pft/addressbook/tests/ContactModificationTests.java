package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

public class ContactModificationTests extends TestBase{

  @Test
  public void testContactModification() {
    app.getContactHelper().returnToContactsList();
    app.getContactHelper().selectContact();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Annabella", "", "Leonova", "Leo", "lllwww@mail.ru", "1", "January", "1989", "Moscow, Red Square, 3", "+79998887476"));
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToContactsList();
    app.logout();

  }
}
