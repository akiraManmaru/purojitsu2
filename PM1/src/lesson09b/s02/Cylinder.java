package lesson09b.s02;

public abstract class Cylinder extends Figure3D {
	protected Cylinder(double height) {
		super(height);
	}

	public double getVolume() {
		return f2.getArea() * height;
	}

}
