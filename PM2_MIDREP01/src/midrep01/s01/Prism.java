package midrep01.s01;

public abstract class Prism extends SolidFigure {
	protected Prism(double height) {
		super(height);
	}

	public double getVolume() {
		return getBottomArea() * height;
	}

}
