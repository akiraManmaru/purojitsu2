package lesson05b.shiritori;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Player {
	private Map<String, List<String>> dictionary;
	protected String keyChars;
	private String name;
	private String[] vocabulary;

	public Player(String name, String[] vocabulary) {

		this.name = name;
		this.vocabulary = vocabulary;

	}

	public String getName() {
		return name;
	}

	public String getWord() {
		if (!dictionary.containsKey(keyChars)) {
			return null;
		}
		String a = dictionary.get(keyChars).get(0);
		dictionary.get(keyChars).remove(0);
		if (dictionary.get(keyChars).isEmpty()) {
			dictionary.remove(keyChars);
		}
		//System.out.println(dictionary);

		return a;
	}

	protected void makeDictionary(int length) {

		dictionary = new HashMap<>();
		//	HashMap<String, String> vocaHead = new HashMap<>();
		for (int i = 0; i < vocabulary.length; i++) {

			keyChars = vocabulary[i].substring(0, length);

			if (dictionary.containsKey(keyChars)) {
				dictionary.get(keyChars).add(vocabulary[i]);
			} else {

				List<String> chars2 = new ArrayList<>();
				chars2.add(vocabulary[i]);
				dictionary.put(keyChars, chars2);
			}
			//System.out.println(dictionary);
			keyChars = null;

		}

	}

	public abstract void update(String message);

}
