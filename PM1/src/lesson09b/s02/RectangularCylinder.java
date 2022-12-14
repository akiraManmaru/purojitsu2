package lesson09b.s02;

public class RectangularCylinder extends Cylinder {

	public RectangularCylinder(double height, double width, double depth) {
		super(height);
		f2 = new Rectangle(width, depth);
	}

}
