package lesson1;

public class Rectangle {
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;

	public Rectangle(int xPosition, int yPosition, int width, int height) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
	}

	public void move(int xMove, int yMove) {
		xPosition = xPosition + xMove;
		yPosition = yPosition + yMove;
	}

	public void showState() {
		System.out.print("x座標:" + xPosition + ", y座標:" + yPosition);
		System.out.println(", 幅:" + width + ", 高さ:" + height);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Rectangle rectangle1 = new Rectangle(2, 1, 5, 6);
		rectangle1.showState();
		rectangle1.move(2, 2);
		rectangle1.showState();

	}

}
