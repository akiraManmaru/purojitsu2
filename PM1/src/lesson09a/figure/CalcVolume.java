package lesson09a.figure;

public class CalcVolume {
	private Figure bottom;
	private int height;
	private double coefficent = 1.0;

	// クラス変数を使う例
	/**public static final String RECTANGLE = "Rectangle"; // 長方形
	public static final String CIRCLE = "Circle"; // 円
	public static final String PYRAMIDAL = "Pyramidal"; // 錐体
	public static final String PRISM = "Prism"; // 柱体*/

	public CalcVolume(BottomType bottomType, BodyType bodyType, int height, int xPosition, int yPosition, int param1,
			int param2) {
		switch (bottomType) {
		case RECTANGLE:
			bottom = new Rectangle(xPosition, yPosition, param1, param2);
			break;
		case CIRCLE:
			bottom = new Circle(xPosition, yPosition, param1);
			break;
		}
		this.height = height;
		/*if (bodyType.equals(PYRAMIDAL)) {
			coefficent = 1.0 / 3;
		}*/
		this.coefficent = bodyType.getCoefficent();
	}

	public int calculation() {
		return (int) (bottom.getArea() * height * coefficent);
	}

}
