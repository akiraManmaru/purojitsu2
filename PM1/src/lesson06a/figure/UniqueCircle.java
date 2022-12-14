package lesson06a.figure;

public class UniqueCircle extends Circle {
	private static UniqueCircle instance = null;

	private UniqueCircle() {
		super(0, 0, 2);

	}

	public static UniqueCircle getInstance() {
		if (instance == null) {
			instance = new UniqueCircle();
		}

		return instance;

	}

}
