package midrep01.s02;

public class Rectangle extends PlaneFigure {
	private double width;
	private double depth;

	public Rectangle(double width, double depth) {
		//super();
		this.width = width;
		this.depth = depth;
	}

	public double getArea() {
		return width * depth;
	}

}
