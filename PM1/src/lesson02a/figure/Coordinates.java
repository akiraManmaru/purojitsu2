package lesson02a.figure;

public class Coordinates {
	private int xPosition;
	private int yPosition;

	public Coordinates(int xPosition, int yPosition) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
	}

	public void move(int xMove, int yMove) {
		this.xPosition = this.xPosition + xMove;
		this.yPosition = this.yPosition + yMove;
	}

	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

}
