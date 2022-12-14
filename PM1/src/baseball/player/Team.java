package baseball.player;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Team {

	private static final Map<Character, String> teamTable = new HashMap<Character, String>() {
		{
			put('f', "日");
			put('h', "ソ");
			put('m', "ロ");
			put('l', "西");
			put('e', "楽");
			put('b', "オ");
			put('c', "広");
			put('g', "巨");
			put('a', "デ");
			put('t', "神");
			put('s', "ヤ");
			put('d', "中");

		}
	};

	private static List<Character> plist = Arrays.asList('f', 'h', 'm', 'l', 'e', 'b');

	public static String toStringTeam(char team) {
		String hoge = null;
		for (char chr : teamTable.keySet()) {
			if (chr == team) {
				hoge = teamTable.get(chr);
				break;
			}
		}
		return hoge;
	}

	public static boolean isPacific(char team) {
		if (plist.contains(team)) {
			return true;
		} else {
			return false;
		}

	}

}
