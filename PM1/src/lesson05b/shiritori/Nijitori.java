package lesson05b.shiritori;

public class Nijitori extends Game {
	public Nijitori(String[] names, String[][] vocabulary) {

		super(new NtoriRule(2), "にじとり");
		int i = 0;
		for (String name : names) {
			players.add(new NtoriPlayer(name, vocabulary[i], 2));
			i++;
		}

	}

}
