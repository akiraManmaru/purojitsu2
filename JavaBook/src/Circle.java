/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 6-3
 * 提出日 2021/10/22
 */

/**
 * 座標平面上の円を表すクラス
 */
public class Circle {

	private int xPosition;
	private int yPosition;
	private int radius;

	/**
	 * 指定された位置と大きさの円を作成
	 * @param xPosition x座標
	 * @param yPosition y座標
	 * @param radius 半径
	 */
	public Circle(int xPosition, int yPosition, int radius) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.radius = radius;
	}

	/**
	 * 円の中心のx座標を得ます
	 */
	// ここにゲッターを記述してください
	public int getXPosition() {
		return xPosition;
	}

	/**
	 * 円の中心のy座標を得ます
	 */
	// ここにゲッターを記述してください
	public int getYPosition() {
		return yPosition;
	}

	/**
	 * 円の半径を得ます
	 */
	// ここにゲッターを記述してください
	public int getRadius() {
		return radius;
	}

	/**
	 * 円の中心を指定された距離だけ移動させます
	 * 
	 * @param xMove
	 * @param yMove
	 */
	public void move(int xMove, int yMove) {
		xPosition += xMove;
		yPosition += yMove;
	}

	/**
	 * 各フィールドの状態を表示します
	 */
	public void showState() {
		System.out.printf("x座標：%d, y座標：%d, 半径：%d\n", xPosition, yPosition, radius);
	}
}