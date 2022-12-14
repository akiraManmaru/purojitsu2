package uml08.source;

public class Designer extends Worker {
	public Designer(String name) {
		super(name);
		identityCard = new IdentityCard("デザイナ社員証");

	}

	public void work() {
		System.out.println("Webデザインします。");
	}

}
