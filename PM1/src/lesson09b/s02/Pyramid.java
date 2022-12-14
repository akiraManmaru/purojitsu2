package lesson09b.s02;

public abstract class Pyramid extends Figure3D {
	protected Pyramid(double height) {
		super(height);
	}

	public double getVolume() {
		return (height * f2.getArea()) / 3;
	}

}
