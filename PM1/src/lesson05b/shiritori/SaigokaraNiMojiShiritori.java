package lesson05b.shiritori;

public class SaigokaraNiMojiShiritori extends Game {
	public SaigokaraNiMojiShiritori(String[] names, String[][] words) {

		super(new NMojiShiritoriRule(2), "最後から２文字しりとり");
		int i = 0;
		for (String name : names) {
			players.add(new NMojiShiritoriPlayer(name, words[i], 2));
			i++;
		}

	}

}
