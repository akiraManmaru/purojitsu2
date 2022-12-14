package lesson05.exam4.factory;

public enum Type {
	SEDAN("セダン"),
	SUV("スポーツ車"),
	MINIVAN("ミニバン"),
	MICRO("軽自動車"),
	TRUCK("トラック");

	private String name;

	private Type(String name) {
		this.name = name;
	}

	public String toString() {
		return name;
	}
}
