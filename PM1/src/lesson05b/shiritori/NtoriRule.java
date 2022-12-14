package lesson05b.shiritori;

import java.util.List;

public class NtoriRule implements Rule {
	private int length;

	public NtoriRule(int length) {
		this.length = length;

	}

	public boolean checkCurrentWord(List<String> prevWords, String currWord) {
		boolean flag = false;
		String a = currWord.substring(0, length);
		String b = prevWords.get(prevWords.size() - 1);

		if (a.equals(b.substring(b.length() - length, b.length()))) {
			flag = true;
		}
		if (currWord.substring(currWord.length() - length, currWord.length() - length + 1).equals("ん")) {
			flag = false;
		}
		if (prevWords.contains(currWord)) {
			flag = false;
		}

		//System.out.println(currWord.substring(currWord.length() - length, currWord.length() - length + 1));

		return flag;
	}

}
