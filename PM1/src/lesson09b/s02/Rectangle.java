package lesson09b.s02;

public class Rectangle extends Figure2D {
	private double width;
	private double depth;

	public Rectangle(double width, double depth) {
		this.width = width;
		this.depth = depth;
	}

	public double getArea() {
		return width * depth;
	}
}
