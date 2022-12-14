package uml08.source;

public class Programmer extends Worker {
	public Programmer(String name) {
		super(name);
		identityCard = new IdentityCard("プログラマ社員証");

	}

	public void work() {
		System.out.println("Webプログラムします。");

	}

}
