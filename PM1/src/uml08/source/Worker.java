package uml08.source;

public abstract class Worker {
	private String name;
	protected IdentityCard identityCard;

	public Worker(String name) {
		this.name = name;
	}

	public void printName() {
		System.out.println("名前は" + name + "です。");

	}

	public IdentityCard getIdentityCard() {
		return identityCard;
	}

	public abstract void work();

}
