package lesson03b.fgo;

public class ServantAlter extends Servant {
	public ServantAlter(String name, String summonedClass) {
		super(name, summonedClass);
		//setName(name + "Alter");

		setalignment("混沌");
	}

	public void showInfo() {
		System.out.println("オルタ化したサーヴァントです.");
	}

}
