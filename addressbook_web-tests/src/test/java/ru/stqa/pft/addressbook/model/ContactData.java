package ru.stqa.pft.addressbook.model;

public class ContactData {
  private int id;
  private final String lastname;
  private final String firstname;
  private final String middlename;
  private final String nickname;
  private final String email;
  private final String bday;
  private final String bmonth;
  private final String byear;
  private final String address2;
  private final String phone2;

  public ContactData(String lastname, String firstname, String middlename, String nickname, String email, String bday, String bmonth, String byear, String address2, String phone2) {
    this.id = Integer.MAX_VALUE;
    this.lastname = lastname;
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.address2 = address2;
    this.phone2 = phone2;
  }
  public ContactData(int id, String lastname, String firstname, String middlename, String nickname, String email, String bday, String bmonth, String byear, String address2, String phone2) {
    this.id = id;
    this.lastname = lastname;
    this.firstname = firstname;
    this.middlename = middlename;
    this.nickname = nickname;
    this.email = email;
    this.bday = bday;
    this.bmonth = bmonth;
    this.byear = byear;
    this.address2 = address2;
    this.phone2 = phone2;
  }

  public int getId() { return id;  }

  public void setId(int id) {    this.id = id;  }

  public String getFirstname() {
    return firstname;
  }

  public String getMiddlename() {
    return middlename;
  }

  public String getLastname() {
    return lastname;
  }

  public String getNickname() {
    return nickname;
  }

  public String getEmail() {
    return email;
  }

  public String getBday() {
    return bday;
  }

  public String getBmonth() {
    return bmonth;
  }

  public String getByear() {
    return byear;
  }

  public String getAddress2() {
    return address2;
  }

  public String getPhone2() {
    return phone2;
  }

  @Override
  public String toString() {
    return "ContactData{" +
            "lastname='" + lastname + '\'' +
            ", firstname='" + firstname + '\'' +
   '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;

    ContactData that = (ContactData) o;

    if (firstname != null ? !firstname.equals(that.firstname) : that.firstname != null) return false;
    return lastname != null ? lastname.equals(that.lastname) : that.lastname == null;
  }

  @Override
  public int hashCode() {
    int result = firstname != null ? firstname.hashCode() : 0;
    result = 31 * result + (lastname != null ? lastname.hashCode() : 0);
    return result;
  }
}
