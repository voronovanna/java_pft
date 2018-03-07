package ru.stqa.pft.rest;

import org.testng.annotations.Test;
import java.io.IOException;

public class ExampleTest extends TestBase{

  @Test
  public void testExample() throws IOException {
    skipIfNotFixed(35);
    System.out.println("Test Example");
  }
}