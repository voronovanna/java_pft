package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("user");

        Square s = new Square(7);
        System.out.println("Площадь квадрата = " + s.area());

        Rectangle r = new Rectangle(4, 6);
        System.out.println("Площадь прямоугольника=" + r.area());

        dictance (1, 10, 3, 15);

    }


    public static void hello(String somebody) {
        System.out.println("Hello," + somebody);
    }

    public static void dictance(double x1, double x2, double y1, double y2){
        System.out.println("Pасстояние между двумя точками = " + Math.sqrt((Math.pow(x2-x1,2)+Math.pow(y2-y1,2))));
    }

}