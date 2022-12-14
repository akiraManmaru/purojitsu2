package lesson04a.testdrive;

import lesson04a.figure.Circle;
import lesson04a.figure.Rectangle;

public class TestFigures {
	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(2, 1, 5, 6);
		rectangle.showState();
		System.out.printf("面積は%d\n", rectangle.getArea());

		rectangle.twice();
		rectangle.showState();
		System.out.printf("面積は%d\n", rectangle.getArea());

		Circle circle = new Circle(4, 2, 2);
		circle.showState();
		System.out.printf("面積は%d\n", circle.getArea());
		circle.twice();
		circle.showState();
		System.out.printf("面積は%d\n", circle.getArea());
	}
}