package lesson05.exam1.factory;

public enum Type {
	SEDAN("セダン"),
	SUV("スポーツ車"),
	MINIVAN("ミニバン"),
	TRUCK("トラック");

	private String name;

	private Type(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
