package lesson09b.s01;

public abstract class Pyramid extends Figure3D {
	protected Pyramid(double height) {
		super(height);
	}

	public double getVolume() {
		return (height * getBottom()) / 3;
	}

	//	public double getBottom() {
	//		return 0;
	//	}

}
