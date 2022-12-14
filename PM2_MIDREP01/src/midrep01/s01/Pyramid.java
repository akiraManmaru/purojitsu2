package midrep01.s01;

public abstract class Pyramid extends SolidFigure {

	protected Pyramid(double height) {
		super(height);
	}

	public double getVolume() {
		return height * getBottomArea() / 3;
	}

}
