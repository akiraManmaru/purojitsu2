package lesson09b.s00;


/**
 * 四角錐クラス
 * @author yamamoto
 *
 */
public class RectangularPyramid {
	/**
	 * 四角錐の高さ
	 */
	private double height;
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
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * 体積の計算
	 * @return　体積
	 */
	public double getVolume() {
		return height * width * depth / 3.0;
	}
}
