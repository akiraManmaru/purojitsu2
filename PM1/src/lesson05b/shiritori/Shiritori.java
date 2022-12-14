package lesson05b.shiritori;

public class Shiritori extends Game {
	public Shiritori(String[] names, String[][] vocabulary) {

		super(new NtoriRule(1), "しりとり");
		int i = 0;
		for (String name : names) {
			players.add(new NtoriPlayer(name, vocabulary[i], 1));
			i++;
		}

	}

}
