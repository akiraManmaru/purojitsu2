package lesson02b.testdrive;

import lesson02a.figure.Circle;
import lesson02a.figure.Rectangle;

public class TestFigures {
	public static void main(String[] args) {

		Rectangle rectangle1 = new Rectangle(2, 1, 5, 6);
		rectangle1.showState();
		rectangle1.move(2, 2);
		rectangle1.showState();

		Rectangle rectangle2 = new Rectangle(5, 6, 7, 8);
		rectangle2.showState();
		rectangle2.move(10, 10);
		rectangle2.showState();

		Circle circle1 = new Circle(2, 1, 5);
		circle1.showState();
		circle1.move(2, 2);
		circle1.showState();

		Circle circle2 = new Circle(5, 6, 7);
		circle2.showState();
		circle2.move(10, 10);
		circle2.showState();
		circle2.setRadius(-8);
		circle2.showState();

	}
}