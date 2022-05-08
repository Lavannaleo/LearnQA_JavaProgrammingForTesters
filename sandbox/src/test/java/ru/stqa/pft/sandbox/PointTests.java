package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {
  @Test
  //All coordinates are equal to zero
  public void testDistance_ZeroValues(){
    Point p1 = new Point(0, 0);
    Point p2 = new Point(0, 0);

    Assert.assertEquals(p2.distance(p1), 0);
  }

  @Test
  //Different coordinate values
  public void testDistance_DifferentValues(){
    Point p1 = new Point(0.15, -89.25);
    Point p2 = new Point(-55.89, 400);

    Assert.assertEquals(p2.distance(p1), 492.4490269053235);
  }
}
