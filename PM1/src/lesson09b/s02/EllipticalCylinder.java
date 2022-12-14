package lesson09b.s02;

public class EllipticalCylinder extends Cylinder {

	public EllipticalCylinder(double height, double majorRadius, double minorRadius) {
		super(height);
		f2 = new Ellipse(majorRadius, minorRadius);

	}

}
