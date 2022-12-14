package lesson05b.shiritori;

public class NtoriPlayer extends Player {
	private int length;

	public NtoriPlayer(String name, String[] vocabulary, int length) {
		super(name, vocabulary);
		this.length = length;
		super.makeDictionary(length);
	}

	public void update(String message) {
		keyChars = message.substring(message.length() - length, message.length());
		//System.out.println(keyChars);
	}

}
