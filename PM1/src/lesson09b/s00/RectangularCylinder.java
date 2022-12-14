package lesson09b.s00;


/**
 * 四角柱クラス
 * @author yamamoto
 *
 */
public class RectangularCylinder {
	/**
	 * 四角柱の高さ
	 */
	private double height;
	/**
	 * 四角柱の幅
	 */
	private double width;
	/**
	 * 四角柱の奥行き
	 */
	private double depth;

	/**
	 * 
	 * @param height
	 * @param width
	 * @param depth
	 */
	public RectangularCylinder(double height, double width, double depth) {
		this.height = height;
		this.width = width;
		this.depth = depth;
	}

	/**
	 * 体積の計算
	 * @return　体積
	 */
	public double getVolume() {
		return height * width * depth;
	}
}
