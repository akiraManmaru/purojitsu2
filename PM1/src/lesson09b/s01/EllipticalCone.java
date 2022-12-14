package lesson09b.s01;

public class EllipticalCone extends Pyramid {

	/*
	 * 楕円錐の長半径
	 */
	private double majorRadius;
	/*
	 * 楕円錐の短半径
	 */
	private double minorRadius;

	/**
	 *
	 * @param height
	 * @param radius
	 */
	public EllipticalCone(double height, double majorRadius, double minorRadius) {
		super(height);
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	public double getBottom() {
		return majorRadius * minorRadius * Math.PI;
	}

}
