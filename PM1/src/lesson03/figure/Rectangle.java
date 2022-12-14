package lesson03.figure;

public class Rectangle extends Figure {
	private int width;
	private int height;

	public Rectangle(int xPosition, int yPosition, int width, int height) {
		super(xPosition, yPosition);
		this.width = width;
		this.height = height;
	}

	public void showState() {
		super.showState();
		System.out.printf(", 幅：%d, 高さ：%d\n", width, height);
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

	public void flip() {
		super.flip();
	}

}
