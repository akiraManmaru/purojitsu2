package lesson09b.s00;


/**
 * 楕円柱クラス
 * @author yamamoto
 *
 */
public class EllipticalCylinder {
	/**
	 * 円柱の高さ
	 */
	private double height;
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
	public EllipticalCylinder(double height, double majorRadius, double minorRadius) {
		this.height = height;
		this.majorRadius = majorRadius;
		this.minorRadius = minorRadius;
	}

	/**
	 * 体積の計算
	 * @return　体積
	 */
	public double getVolume() {
		return height * majorRadius * minorRadius * Math.PI;
	}
}
