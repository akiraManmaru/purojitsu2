package lesson05b.shiritori;

public class NMojiShiritoriPlayer extends Player {
	private int position;

	public NMojiShiritoriPlayer(String name, String[] words, int position) {
		super(name, words);
		this.position = position;
		super.makeDictionary(1);
	}

	public void update(String message) {
		keyChars = message.substring(message.length() - position, message.length() - position + 1);
		//System.out.println(keyChars);
	}

}
