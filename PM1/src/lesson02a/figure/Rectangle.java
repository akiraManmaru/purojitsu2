package lesson02a.figure;

public class Rectangle {
	private Coordinates coordinates;
	private int width;
	private int height;

	public Rectangle(int xPosition, int yPosition, int width, int height) {
		coordinates = new Coordinates(xPosition, yPosition);
		this.width = width;
		this.height = height;
	}

	public void move(int xMove, int yMove) {
		coordinates.move(xMove, yMove);
	}

	public void showState() {
		System.out.print("x座標:" + coordinates.getXPosition() + ", y座標:" + coordinates.getYPosition());
		System.out.println(", 幅:" + width + ", 高さ:" + height);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Rectangle rectangle1 = new Rectangle(2, 1, 5, 6);
		rectangle1.showState();
		rectangle1.move(2, 2);
		rectangle1.showState();

	}

	/**
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	*/

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

}
