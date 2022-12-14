package lesson09b.s02;

public class RectangularPyramid extends Pyramid {

	/**
	 *
	 * @param height
	 * @param width
	 * @param depth
	 */
	public RectangularPyramid(double height, double width, double depth) {
		super(height);
		f2 = new Rectangle(width, depth);
	}

}
