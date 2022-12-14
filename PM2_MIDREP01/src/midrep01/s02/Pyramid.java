package midrep01.s02;

public abstract class Pyramid extends SolidFigure {

	protected Pyramid(double height) {
		super(height);
	}

	public double getVolume() {
		return height * bottom.getArea() / 3;
	}

}
