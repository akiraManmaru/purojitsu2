package lesson03.figure;

public class Coordinates {
	private int xPosition;
	private int yPosition;

	/**
	 * 指定された位置と大きさの長方形を作成
	 *
	 * @param xPosition
	 *            x座標
	 * @param yPosition
	 *            y座標
	 */
	public Coordinates(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	/**
	 * 指定された距離だけ移動
	 *
	 * @param xMove
	 * @param yMove
	 */
	public void move(int xMove, int yMove) {
		xPosition += xMove;
		yPosition += yMove;
	}

	public int getXPosition() {
		return xPosition;
	}

	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	/**
	 * 各フィールドの状態を表示
	 */
	public void showState() {
		System.out.printf("x座標：%d y座標：%d", xPosition, yPosition);
	}

	public void flip() {
		int a = xPosition;
		xPosition = yPosition;
		yPosition = a;
	}
}