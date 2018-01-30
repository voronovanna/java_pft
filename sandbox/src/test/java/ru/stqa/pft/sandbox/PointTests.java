package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p1 = new Point(1, 3);
    Point p2 = new Point(10, 15);
    Assert.assertEquals (p1.distance(p2),15.0);
  }

  @Test
  public void testDistance2(){
    Point p1 = new Point(10, 10);
    Point p2 = new Point(10, 10);
    Assert.assertEquals (p1.distance(p2),0.0);
  }

  @Test
  public void testDistance3(){
    Point p1 = new Point(0, 0.5);
    Point p2 = new Point(2, 2);
    Assert.assertEquals (p1.distance(p2),2.5);
  }

  }