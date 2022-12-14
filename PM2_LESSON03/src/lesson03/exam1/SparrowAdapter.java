package lesson03.exam1;

public class SparrowAdapter implements Turkey {

	private Sparrow sparrow;

	public SparrowAdapter(Sparrow sparrow) {
		//super();
		this.sparrow = sparrow;
	}

	public void gobble() {
		sparrow.scream();
	}

	public void fly() {
		sparrow.fly();
	}

}
