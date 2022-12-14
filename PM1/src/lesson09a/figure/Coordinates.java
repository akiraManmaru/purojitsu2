package lesson09a.figure;

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

	/**
	 * y=xに関して反転
	 *
	 */
	public void flip() {

		int tmp = xPosition;
		xPosition = yPosition;
		yPosition = tmp;
	}

	/**
	 * x座標,y座標を表示
	 */
	public void showState() {

		System.out.printf("x座標: %d, y座標: %d", xPosition, yPosition);
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}
}
