package lesson09a.figure;

import java.util.ArrayList;
import java.util.List;

public class Square extends Rectangle {

	private int length;
	//private List<Square> SquareList;
	private static List<Square> SList = new ArrayList<>();

	public Square(int xPosition, int yPosition, int length) {
		super(xPosition, yPosition, length, length);
		this.length = length;
		SList.add(this);

	}

	public int getLength() {
		return length;
	}

	public Square clone() {
		return new Square(coordinates.getXPosition(), coordinates.getYPosition(), 6);
	}

	public static Square copyOf(Square square, int xPosition, int yPosition) {
		return new Square(xPosition, yPosition, square.length);
	}

	public void showState() {
		super.showState();
		System.out.printf("一辺の長さ：%d\n", length);
	}

}
