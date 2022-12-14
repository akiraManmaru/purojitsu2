package lesson09b.s01;

public abstract class Figure3D {
	protected double height;

	protected Figure3D(double height) {
		this.height = height;
	}

	public abstract double getVolume();

	protected abstract double getBottom();

}
