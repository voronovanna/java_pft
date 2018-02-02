package ru.stqa.pft.sandbox;

import org.testng.Assert;
import org.testng.annotations.Test;

public class PointTests {

  @Test
  public void testDistance(){
    Point p = new Point(1, 10, 3, 15);
    Assert.assertEquals (p.distance(),15.0);
  }

  @Test
  public void testDistance2(){
    Point p = new Point(10, 10, 10, 10);
    Assert.assertEquals (p.distance(),0.0);
  }

  @Test
  public void testDistance3(){
    Point p = new Point(0, 2, 0.5, 2);
    Assert.assertEquals (p.distance(),2.5);
  }

  }