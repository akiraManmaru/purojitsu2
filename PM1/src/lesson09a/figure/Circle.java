package lesson09a.figure;

import java.util.ArrayList;
import java.util.List;

public class Circle extends Figure {

	private int radius;
	private List<Circle> CList = new ArrayList<>();

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
		CList.add(this);
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

	/*
	 * 第４回実習
	 * 面積を計算
	 */
	@Override
	public int getArea() {
		return 3 * radius * radius;
	}

	/*
	 * 第４回実習
	 * 縦横に２倍
	 */
	@Override
	public void twice() {
		radius *= 2;
	}

	public Circle clone() {

		return new Circle(coordinates.getXPosition(), coordinates.getYPosition(), 2);

	}

	public static Circle copyOf(Circle circle, int xPosition, int yPosition) {
		return new Circle(xPosition, yPosition, circle.radius);
	}

}
