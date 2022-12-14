package lesson04a.figure;

public class Circle extends Figure {
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
		// this.xPosition = xPosition;
		// this.yPosition = yPosition;
		super(xPosition, yPosition);
		this.radius = radius;
	}

	public int getArea() {
		return 3 * radius * radius;
	}

	public void twice() {
		radius *= 2;
	}

	/**
	 * 各フィールドの状態を表示
	 */
	public void showState() {
		super.showState();
		//		System.out.printf("x座標：%d, y座標：%d, 半径：%d\n", xPosition, yPosition,
		//				radius);
		System.out.printf("半径：%d\n", radius);
	}

}