package lesson05b.shiritori;

import java.util.List;

public class NMojiShiritoriRule implements Rule {
	private int position;

	public NMojiShiritoriRule(int position) {
		this.position = position;

	}

	public boolean checkCurrentWord(List<String> prevHand, String currHand) {
		boolean flag = false;
		String a = currHand.substring(0, 1);
		String b = prevHand.get(prevHand.size() - 1);

		if (a.equals(b.substring(b.length() - position, b.length() - position + 1))) {
			flag = true;
		}
		if (currHand.substring(currHand.length() - position, currHand.length() - position + 1).equals("ん")) {
			flag = false;
		}
		if (prevHand.contains(currHand)) {
			flag = false;
		}

		//System.out.println(b.substring(b.length() - position, b.length()));

		return flag;
	}

}
