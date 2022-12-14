
package lesson05a.testdrive;

import lesson05a.figure.Circle;
import lesson05a.figure.Printable;
import lesson05a.figure.Rectangle;

public class TestDrive {
	public static void main(String[] args) {
		Printable printable = new Rectangle(3, 2, 4, 5);
		printable.showState();
		printable = new Circle(3, 5, 6);
		printable.showState();
	}
}
