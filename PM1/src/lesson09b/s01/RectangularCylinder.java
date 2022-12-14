package lesson09b.s01;

public class RectangularCylinder extends Cylinder {

	private double width;
	private double depth;

	public RectangularCylinder(double height, double width, double depth) {
		super(height);
		this.width = width;
		this.depth = depth;
	}

	public double getBottom() {
		return width * depth;
	}

}
