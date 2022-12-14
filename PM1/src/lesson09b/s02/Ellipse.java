package lesson09b.s02;

public class Ellipse extends Figure2D {
	private double majorRadius;
	private double minorRadius;

	public Ellipse(double majorRadius, double minorRadius) {
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public double getArea() {
		return majorRadius * minorRadius * Math.PI;
	}
}
