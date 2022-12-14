package lesson03.exam2;

public class PasserineAdapter extends WildTurkey {
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
