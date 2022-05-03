package ru.stqa.pft.sandbox;

public class MyFirstProgram {

	public static void main(String[] args) {
		hello("world");
		hello("user");
		hello("Anna");

		Square s = new Square(5);
		System.out.println("Площадь квадрата со стороной " + s.l + " = " + s.area());

		Rectangle r = new Rectangle(4,6);
		System.out.println("Площадь прямоугольника со сторонами " + r.a + " и " + r.b + " = " +r.area());

		Point p1 = new Point(0.15, -89.25);
		Point p2 = new Point(-55.89, 400);
		System.out.println("Расстояние между точками А(" + p1.x + ", " + p1.y + ") и В(" + p2.x + ", " + p2.y + ") равно " + Math.sqrt(Math.pow((p2.getX() - p1.getX()), 2) + Math.pow((p2.getY() - p1.getY()), 2)));

	}

	public static void hello(String somebody) {
		System.out.println("Hello, " + somebody + "!");
	}
}