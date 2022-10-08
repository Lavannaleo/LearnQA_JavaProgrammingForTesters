package ru.stqa.pft.addressbook.tests;

import com.google.common.base.Strings;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactPhoneAddressEmailTests extends TestBase {
  @BeforeMethod
  public void ensureContact() {
    app.contact().returnToContactsList();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withFirstname("Anna").withMiddlename("Maria").withLastname("Leonidova").withNickname("Leo").withEmail("lll@mail.ru").withBday("1").withBmonth("January").withByear("1990").withAddress("Moscow, Red Square, 3"));
    }
    app.contact().returnToContactsList();
  }

  @Test
  public void testContactPhones() {
    app.contact().returnToContactsList();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAddress(), equalTo(Strings.nullToEmpty(contactInfoFromEditForm.getAddress())));
    assertThat(contact.getAllPhones(), equalTo(mergePhones(contactInfoFromEditForm)));
    assertThat(contact.getAllEmails(), equalTo(mergeEmails(contactInfoFromEditForm)));
  }

  private String mergePhones(ContactData contact) {
    return Arrays.asList(contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactPhoneAddressEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleaned(String s) {
    return s.replaceAll("\\s", "").replaceAll("[-()]", "");
  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
            .stream().filter((s) -> ! s.equals(""))
//            .map(ContactPhoneAddressEmailTests::cleaned)
            .collect(Collectors.joining("\n"));
  }

  public static String cleanedEnter(String s) {
    return s.replaceAll("\n", "");
  }
}
