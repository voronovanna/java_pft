package ru.stqa.pft.sandbox;

public class MyFirstProgram {
  public static void main(String[] args) {
    hello("User");

    Square s = new Square(7);
    System.out.println("Площадь квадрата = " + s.area());

    Rectangle r = new Rectangle(4, 6);
    System.out.println("Площадь прямоугольника=" + r.area());

    Point p1 = new Point(1, 3);
    Point p2 = new Point(10, 15);
    System.out.println("Расстояние между точками " + p1.x +","+ p1.y + "  и  " + p2.x+","+p2.y + " = " + p1.distance(p2));
  }

  public static void hello(String somebody) {
    System.out.println("Hello," + somebody);
  }

}