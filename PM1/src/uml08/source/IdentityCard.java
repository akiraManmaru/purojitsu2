package uml08.source;

public class IdentityCard {
	private String type;

	public IdentityCard(String type) {
		this.type = type;

	}

	public void printType() {
		System.out.println("IDカードの種類は" + type + "です。");

	}

}
