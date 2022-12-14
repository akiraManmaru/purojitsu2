package lesson09b.s02;

public abstract class Figure3D {
	protected double height;
	protected Figure2D f2;

	protected Figure3D(double height) {
		this.height = height;
	}

	public abstract double getVolume();

}
