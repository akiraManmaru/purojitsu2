package lesson07a.figure;

public enum BodyType {
	PYRAMIDAL("錐体", 1.0 / 3), PRISM("柱体", 1.0);

	String name;
	double coefficent;

	BodyType(String name, double coefficent) {

		this.name = name;
		this.coefficent = coefficent;

	}

	public String toString() {
		return name;

	}

	public double getCoefficent() {

		return coefficent;

	}

}
