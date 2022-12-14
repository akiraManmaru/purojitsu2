package lesson1;

public class Circle {

	private int xPosition;
	private int yPosition;
	private int radius;

	public Circle(int xPosition, int yPosition, int radius) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.radius = radius;
	}

	public void move(int xMove, int yMove) {
		xPosition = xPosition + xMove;
		yPosition = yPosition + yMove;
	}

	public void showState() {
		System.out.print("x座標:" + xPosition + ", y座標:" + yPosition);
		System.out.println(", 半径:" + radius);
	}

}
