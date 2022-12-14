package midrep01.s02;

public class Circle extends PlaneFigure {
	private double radius;

	public Circle(double radius) {
		//super();
		this.radius = radius;
	}

	public double getArea() {
		return radius * radius * Math.PI;
	}

}
