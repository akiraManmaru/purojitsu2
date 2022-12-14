package lesson03.figure;

public class Figure {
	protected Coordinates coordinates;

	public Figure(int xPosition, int yPosition) {
		this.coordinates = new Coordinates(xPosition, yPosition);
	}

	/**
	 * xPositionのゲッター
	 */
	public int getXPosition() {
		return coordinates.getXPosition();
	}

	/**
	 * yPositionのゲッター
	 */
	public int getYPosition() {
		return coordinates.getYPosition();
	}

	/**
	 * 指定された距離だけ移動
	 * @param xMove
	 * @param yMove
	 */
	public void move(int xMove, int yMove) {

		coordinates.move(xMove, yMove);
	}

	public void showState() {
		System.out.printf("x座標：%d y座標：%d", coordinates.getXPosition(), coordinates.getYPosition());
	}

	public void flip() {
		int a = coordinates.getXPosition();
		coordinates.setXPosition(getYPosition());
		coordinates.setYPosition(a);
	}

}
