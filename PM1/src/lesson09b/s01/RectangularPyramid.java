package lesson09b.s01;

public class RectangularPyramid extends Pyramid {

	/**
	 * 四角錐の幅
	 */
	private double width;
	/**
	 * 四角錐の奥行き
	 */
	private double depth;

	/**
	 *
	 * @param height
	 * @param width
	 * @param depth
	 */
	public RectangularPyramid(double height, double width, double depth) {
		super(height);
		this.width = width;
		this.depth = depth;
	}

	public double getBottom() {
		return width * depth;
	}
}
