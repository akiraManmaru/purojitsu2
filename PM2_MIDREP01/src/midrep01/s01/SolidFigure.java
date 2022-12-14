package midrep01.s01;

/**
 * 高さを持つ立体を表す抽象クラス
 */
public abstract class SolidFigure {
	/**
	 * 高さ
	 */
	protected double height;
	//protected PlaneFigure bottom;

	/**
	 * コンストラクタ
	 * @param height 高さ
	 */
	protected SolidFigure(double height) {
		this.height = height;
	}

	/**
	 * 体積を求める抽象メソッド
	 * @return 体積
	 */
	public abstract double getVolume();

	protected abstract double getBottomArea();
}
