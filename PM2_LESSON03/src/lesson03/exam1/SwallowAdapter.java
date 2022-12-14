package lesson03.exam1;

public class SwallowAdapter implements Turkey {
	private Swallow swallow;

	public SwallowAdapter(Swallow swallow) {
		//super();
		this.swallow = swallow;
	}

	public void gobble() {
		swallow.scream();
	}

	public void fly() {
		swallow.fly();
	}

}
