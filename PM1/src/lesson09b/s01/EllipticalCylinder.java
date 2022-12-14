package lesson09b.s01;

public class EllipticalCylinder extends Cylinder {

	private double majorRadius;
	private double minorRadius;

	public EllipticalCylinder(double height, double majorRadius, double minorRadius) {
		super(height);
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;

	}

	public double getBottom() {
		return majorRadius * minorRadius * Math.PI;
	}

}
