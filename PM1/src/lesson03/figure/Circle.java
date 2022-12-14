package lesson03.figure;

public class Circle extends Figure {
	private Coordinates coordinates;
	private int radius;

	/**
	 * 指定された位置と大きさの円を作成
	 *
	 * @param xPosition
	 *            x座標
	 * @param yPosition
	 *            y座標
	 * @param radius
	 *            半径
	 */
	public Circle(int xPosition, int yPosition, int radius) {

		super(xPosition, yPosition);
		this.radius = radius;
	}

	/**
	 * radiusのゲッター
	 */
	public int getRadius() {
		return radius;
	}

	/**
	 * 入力値が自然数かどうかチェック
	 * @param i
	 *		入力値
	 * @return
	 * 		入力値が自然数であればtrue，そうでなければfalse
	 */
	private boolean isNatural(int i) {
		boolean ret;
		if (i >= 0)
			ret = true;
		else
			ret = false;
		return ret;
	}

	/**
	 * radiusのセッター
	 */
	public void setRadius(int radius) {
		if (isNatural(radius))
			this.radius = radius;
	}

	/**
	 * 指定された距離だけ移動
	 *
	 * @param xMove
	 * @param yMove
	 */
	public void move(int xMove, int yMove) {

		coordinates.move(xMove, yMove);
	}

	/**
	 * 各フィールドの状態を表示
	 */
	public void showState() {
		super.showState();
		System.out.printf(", 半径：%d\n", radius);
	}

	public void flip() {
		super.flip();
	}
}