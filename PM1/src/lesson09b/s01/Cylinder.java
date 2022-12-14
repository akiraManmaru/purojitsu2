package lesson09b.s01;

public abstract class Cylinder extends Figure3D {
	protected Cylinder(double height) {
		super(height);
	}

	public double getVolume() {
		return getBottom() * height;
	}

	//	public double getBottom() {
	//		return 0;
	//	}

}
