package midrep01.s02;

/**
 * 円柱を表すクラス
 */
public class Cylinder extends Prism {
	// 底の半径
	//private double radius;

	/**
	 * コンストラクタ
	 * @param height 高さ
	 * @param radius 底の半径
	 */
	public Cylinder(double height, double radius) {
		super(height);
		bottom = new Circle(radius);
	}

	/**
	 * 体積を求める
	 * @return 体積
	 */
	//	public double getBottomArea() {
	//		return radius * radius * Math.PI;
	//	}
}
