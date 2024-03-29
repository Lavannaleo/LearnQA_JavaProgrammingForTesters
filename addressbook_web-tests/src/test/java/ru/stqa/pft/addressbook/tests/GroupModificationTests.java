package ru.stqa.pft.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.pft.addressbook.model.GroupData;
import ru.stqa.pft.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.assertEquals;


public class GroupModificationTests extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().groups().size() == 0) {
      app.goTo().groupPage();
      app.group().create(new GroupData().withName("test1"));
    }
  }

  @Test
  public void testGroupModification() {
    Groups before = app.db().groups();
    GroupData modifiedGroup = before.iterator().next();
    GroupData group = new GroupData().withId(modifiedGroup.getId()).withName("TestGroup").withHeader("TestHeader").withFooter("TestFooter");
    app.goTo().groupPage();
    app.group().modify(group);
    assertThat(app.group().count(),equalTo( before.size()));
    Groups after = app.db().groups();
    assertThat(after, equalTo(before.withOut(modifiedGroup).withAdded(group)));
    verifyGroupListInUi();
  }


}
