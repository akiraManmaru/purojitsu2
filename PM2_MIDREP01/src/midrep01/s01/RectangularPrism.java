package midrep01.s01;

/**
 * 長方柱(直方体または底が長方形の斜柱)を表すクラス
 */
public class RectangularPrism extends Prism {
	// 底の幅と奥行き(底の長方形の横と縦)
	private double width;
	private double depth;

	/**
	 * コンストラクタ
	 * @param height 高さ
	 * @param width 底の幅
	 * @param depth 底の奥行き
	 */
	public RectangularPrism(double height, double width, double depth) {
		super(height);
		this.depth = depth;
		this.width = width;
	}

	/**
	 * 体積を求める
	 * @return 体積
	 */
	protected double getBottomArea() {
		return width * depth;
	}
}
