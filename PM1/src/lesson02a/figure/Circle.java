package lesson02a.figure;

public class Circle {

	private Coordinates coordinates;
	private int radius;

	public Circle(int xPosition, int yPosition, int radius) {
		coordinates = new Coordinates(xPosition, yPosition);
		this.radius = radius;
	}

	public void move(int xMove, int yMove) {
		coordinates.move(xMove, yMove);
	}

	public void showState() {
		System.out.print("x座標:" + coordinates.getXPosition() + ", y座標:" + coordinates.getYPosition());
		System.out.println(", 半径:" + radius);
	}

	private boolean isNatural(int i) {
		boolean ret;
		if (i > 0)
			ret = true;
		else
			ret = false;
		return ret;
	}

	public void setRadius(int radius) {
		if (isNatural(radius))
			this.radius = radius;
	}

	/**
	
	public int getXPosition() {
		return xPosition;
	}
	
	public int getYPosition() {
		return yPosition;
	}
	*/

	public int getRadius() {
		return radius;
	}

}
