package lesson03b.fgo;

public class Servant {
	private String name;
	private String summonedClass;
	private String alignment;

	public Servant(String name, String summonedClass) {
		super();
		this.name = name;
		this.summonedClass = summonedClass;
		alignment = "中立";
	}

	public void showInfo() {
		System.out.println("通常のサーヴァントです.");
	}

	public void showState() {
		System.out.println(name + "役割:" + summonedClass + "属性は" + alignment + "です.");

	}

	public void setName(String name) {
		this.name = name;
	}

	public void setalignment(String alignment) {
		this.alignment = alignment;
	}

}
