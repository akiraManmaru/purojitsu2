package lesson09a.figure;

public abstract class Figure {

	// protected int xPosition;
	// protected int yPosition;
	protected Coordinates coordinates;

	/**
	 * 指定された位置と大きさの長方形を作成
	 *
	 * @param xPosition
	 *            x座標
	 * @param yPosition
	 *            y座標
	 */
	public Figure(int xPosition, int yPosition) {
		// this.xPosition = xPosition;
		// this.yPosition = yPosition;
		this.coordinates = new Coordinates(xPosition, yPosition);
	}

	/**
	 * 指定された距離だけ移動
	 *
	 * @param xMove
	 * @param yMove
	 */
	public void move(int xMove, int yMove) {
		// xPosition += xMove;
		// yPosition += yMove;
		coordinates.move(xMove, yMove);
	}

	/**
	 * y=xに関して反転
	 *
	 */
	public void flip() {
		coordinates.flip();
	}

	/**
	 * 各フィールドの状態を表示
	 */
	public void showState() {
		// System.out.printf("x座標：%d, y座標：%d, ", xPosition, yPosition);
		coordinates.showState();
		System.out.print(", ");

	}

	/*
	 * 第４回実習
	 * 抽象メソッド：
	 * 面積を計算
	 */
	public abstract int getArea();

	/*
	 * 第４回実習
	 * 抽象メソッド：
	 * 縦横に２倍
	 */
	public abstract void twice();

}