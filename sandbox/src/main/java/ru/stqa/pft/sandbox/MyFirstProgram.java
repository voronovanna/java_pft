package ru.stqa.pft.sandbox;

public class MyFirstProgram {
    public static void main(String[] args) {
        hello("user");

        double l=5;
        System.out.println("Площадь квадрата = "+area(l));

        double a=6;
        double b=7;
        System.out.println("Площадь прямоугольника="+area(a,b));
    }

    public static void hello (String somebody){
        System.out.println("Hello,"+somebody);

    }

    public static double area(double len){
        return len*len;
    }

    public static double area (double a, double b){
        return a*b;
    }
}