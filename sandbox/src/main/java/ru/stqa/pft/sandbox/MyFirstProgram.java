package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("user");

        Square s = new Square(7);
        System.out.println("Площадь квадрата = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника=" + r.area());

        Point p = new Point (1, 10, 3, 15);
        System.out.println("Pасстояние между двумя точками "+p.x1+","+p.y1+"  и  "+p.x2+","+p.y2+" = "+ p.distance());
    }


    public static void hello(String somebody) {
        System.out.println("Hello," + somebody);
    }

}