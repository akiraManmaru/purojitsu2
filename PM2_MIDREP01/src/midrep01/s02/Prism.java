package midrep01.s02;

public abstract class Prism extends SolidFigure {
	protected Prism(double height) {
		super(height);
	}

	public double getVolume() {
		return bottom.getArea() * height;
	}

}
