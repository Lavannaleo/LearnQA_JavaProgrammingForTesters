package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(0.15, -89.25);
    Point p2 = new Point(-55.89, 400);

    Assert.assertEquals(p2.distance(p1), 492.4490269053235);
  }
}
