package lesson03b.fgo;

import java.util.ArrayList;

public class Master {
	private String name;
	private ServantSystem servantSystem;
	private ArrayList<Servant> listOfServants;

	public Master(String name) {
		this.name = name;
		listOfServants = new ArrayList<>();
	}

	public void showName() {
		System.out.println(name + "です.");
	}

	public void summonServant(String name, String servantClass) {
		servantSystem = new ServantSystem(name, servantClass);
		if (servantSystem.summonServant() != null) {
			listOfServants.add(servantSystem.summonServant());
		}
	}

	public void showServant() {
		if (listOfServants.isEmpty()) {
			System.out.println("保有しているサーヴァントはいません.");
		} else {
			System.out.println("保有しているサーヴァントの一覧です.");

			for (Servant servant : listOfServants) {
				servant.showState();
			}
		}

	}

}
