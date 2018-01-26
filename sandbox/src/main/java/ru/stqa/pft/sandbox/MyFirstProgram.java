package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("user");

        Square s = new Square(7);
        System.out.println("Площадь квадрата = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника=" + r.area());
        
        double p1 = 9;
        double p2 = 12;
        System.out.println("Pасстояние между двумя точками = " + Math.sqrt((p1*p1)+(p2*p2)));
    }

    public static void hello(String somebody) {
        System.out.println("Hello," + somebody);
    }

    //public static double distance(Point p1, Point p2){
    //}
}