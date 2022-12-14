package lesson09a.testdrive;

import lesson09a.figure.Circle;
import lesson09a.figure.Rectangle;
import lesson09a.figure.Square;

public class TestFigures9 {

	public static void main(String[] args) {

		Rectangle rectangle = new Rectangle(2, 1, 5, 6);
		rectangle.showState();
		System.out.printf("面積は%d\n", rectangle.getArea());

		Circle circle = new Circle(4, 2, 2);
		circle.showState();
		System.out.printf("面積は%d\n", circle.getArea());

		/*
		 * 課題9-1(1)を確認
		 */
		Square square = new Square(5, 2, 3);
		square.showState();
		System.out.printf("面積は%d\n", square.getArea());
		square.twice();
		square.showState();
		System.out.printf("面積は%d\n", square.getArea());

		System.out.println();

		/*
		 * 課題9-1(2)を確認
		 */
		Rectangle rectangle2 = rectangle.clone();
		rectangle2.showState();
		System.out.printf("面積は%d\n", rectangle2.getArea());
		Circle circle2 = circle.clone();
		circle2.showState();
		System.out.printf("面積は%d\n", circle2.getArea());
		System.out.println("半径を２倍にする．");
		circle2.twice();
		circle2.showState();
		System.out.printf("面積は%d\n", circle2.getArea());
		Square square2 = square.clone();
		square2.showState();
		System.out.println("元の正方形の辺の長さ２倍にする．"); // square2の面積は変わらない
		square.twice();
		square2.showState();
		System.out.printf("面積は%d\n", square2.getArea());

		System.out.println();

		/*
		 * 課題9-1(3)を確認
		 */
		Square square3 = Square.copyOf(square, 4, 6);
		square3.showState();
		System.out.printf("面積は%d\n", square3.getArea());
		Rectangle rectangle3 = Rectangle.copyOf(rectangle, 7, 2);
		rectangle3.showState();
		System.out.printf("面積は%d\n", rectangle3.getArea());
		System.out.println("たて横の長さを２倍にする．");
		rectangle3.twice();
		rectangle3.showState();
		System.out.printf("面積は%d\n", rectangle3.getArea());
		Circle circle3 = Circle.copyOf(circle, 2, 5);
		circle3.showState();
		System.out.println("元の円の半径を２倍にする．"); // circle3の面積は変わらない
		circle.twice();
		circle3.showState();
		System.out.printf("面積は%d\n", circle3.getArea());

	}
}