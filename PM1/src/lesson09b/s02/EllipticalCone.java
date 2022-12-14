package lesson09b.s02;

public class EllipticalCone extends Pyramid {

	/**
	 *
	 * @param height
	 * @param radius
	 */
	public EllipticalCone(double height, double majorRadius, double minorRadius) {
		super(height);
		f2 = new Ellipse(majorRadius, minorRadius);
	}

}
