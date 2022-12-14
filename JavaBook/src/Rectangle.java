/*
 * 提出者 21-1-037-0034 池上開世
 * 予習課題 4.6
 * 提出日 2021/10/12
 */
/*
 * 座標平面上の長方形を表し、移動させることができるメソッドを持つクラス
 * 面積の計算のメソッドも追加
 * Moveメソッドを変更
 */
public class Rectangle {
	private int xPosition;
	private int yPosition;
	private int width;
	private int height;

	//コンストラクタ
	public Rectangle(int xPosition, int yPosition, int width, int height) {
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
	}

	//移動するメソッド
	public boolean move(int xMove, int yMove) {
		boolean success;
		int newXPosition = xPosition + xMove;
		int newYPosition = yPosition + yMove;
		if (newXPosition >= 0 && newYPosition >= 0) {
			xPosition = newXPosition;
			yPosition = newYPosition;
			success = true;
		} else
			success = false;
		return success;
	}

	//座標表示するメソッド
	public void showState() {
		System.out.print("x座標:" + xPosition + ",y座標:" + yPosition);
		System.out.println(",幅:" + width + ",高さ:" + height);
	}

	//面積を計算するメソッド
	public int calcArea() {
		int area;
		area = width * height;
		return area;
	}

	//セッター
	public void setXPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public void setYPosition(int yPosition) {
		this.yPosition = yPosition;
	}

	public void setWidth(int width) {
		this.width = width;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	//ゲッター
	public int getXPosition() {
		return xPosition;
	}

	public int getYPosition() {
		return yPosition;
	}

	public int getWidth() {
		return width;
	}

	public int getHeight() {
		return height;
	}

	//大きさを変更するメソッド
	public void resize(double ratio) {
		width = (int) (ratio * width); //縮小変換
		height = (int) (ratio * height);
	}

	//四角形を視覚的に表示するメソッド
	public void show() {
		int line, column;
		line = 0;
		while (line < height) {
			column = 0;

			while (column < width) {

				System.out.print("■");
				column++;
			}
			System.out.println();
			line++;
		}
	}

	//メインメソッド

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Rectangle rectangle1 = new Rectangle(2, 1, 5, 6);
		Rectangle rectangle2 = new Rectangle(5, 3, 3, 1);
		rectangle1.showState();
		rectangle1.move(2, 2);
		rectangle1.showState();
		rectangle2.showState();
		rectangle2.move(1, 4);
		rectangle2.showState();
	}

}
