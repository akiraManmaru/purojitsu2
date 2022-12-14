package lesson03.exam3_4;

public class PasserineAdapter implements Turkey {
	private Passerine passerine;

	public PasserineAdapter(Passerine passerine) {
		//super();
		this.passerine = passerine;
	}

	public void fly() {
		passerine.fly();
	}

	public void gobble() {
		passerine.scream();
	}

}
