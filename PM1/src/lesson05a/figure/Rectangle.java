package lesson05a.figure;

public class Rectangle extends Figure implements Printable {

	private int width;
	private int height;

	/**
	 * 指定された位置と大きさの長方形を作成
	 *
	 * @param xPosition
	 *            x座標
	 * @param yPosition
	 *            y座標
	 * @param width
	 *            幅
	 * @param height
	 *            高さ
	 */
	public Rectangle(int xPosition, int yPosition, int width, int height) {
		// this.xPosition = xPosition;
		// this.yPosition = yPosition;
		super(xPosition, yPosition);
		this.width = width;
		this.height = height;
		typePrinter = new RectanglePrinter();
	}

	public int getArea() {
		return width * height;
	}

	public void twice() {
		height *= 2;
		width *= 2;
	}

	/**
	 * y=xに関して反転
	 *
	 */
	public void flip() {

		super.flip();
		int tmp = width;
		width = height;
		height = tmp;
	}

	/**
	 * 各フィールドの状態を表示
	 */
	public void showState() {
		super.showState();
		//		System.out.printf("x座標：%d, y座標：%d, 幅：%d, 高さ：%d\n", xPosition, yPosition, width, height);
		System.out.printf("幅：%d, 高さ：%d\n", width, height);
	}

}
