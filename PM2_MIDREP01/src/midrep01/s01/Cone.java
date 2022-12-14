package midrep01.s01;

/**
 * 円錐を表すクラス
 */
public class Cone extends Pyramid {
	// 底の半径
	private double radius;

	/**
	 * コンストラクタ
	 * @param height 高さ
	 * @param radius 底の半径
	 */
	public Cone(double height, double radius) {
		super(height);
		this.radius = radius;
	}

	/**
	 * 体積を求める
	 * @return 体積
	 */
	protected double getBottomArea() {
		return radius * radius * Math.PI;
	}
}
