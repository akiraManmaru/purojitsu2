package lesson05b.shiritori;

import java.util.ArrayList;
import java.util.List;

/**
 * クラスGame
 * ゲームの大まかな流れやデータ（プレイヤ，ルール）を管理する
 * @author handa
 *
 */
public abstract class Game {
	/**
	 * このメソッドgameの内部について，コメントを外して「ここを考える」という箇所を記述すること．メソッド内のそれ以外のところは書き換えてはいけない．
	 */
	private String currWord;
	private String initialWord;
	protected List<Player> players;
	private Rule rule;

	public Game(Rule rule, String initialWord) {
		this.rule = rule;
		this.initialWord = initialWord;
		players = new ArrayList<>();
	}

	private void sendMessage() {
		for (Player player : players) {
			player.update(currWord);
		}
	};

	public final void game() {
		//System.out.println("game");
		List<String> prevWords = new ArrayList<>();
		int curr = 0;
		currWord = initialWord;
		sendMessage();
		prevWords.add(initialWord);
		System.out.println(initialWord);
		while (players.size() != 1) {
			String word = players.get(curr).getWord();//curr番目の人に単語を聞く

			if (word == null || !rule.checkCurrentWord(prevWords, word)) {
				players.remove(curr);//curr番目の人が負けたのでplayersから削除
				curr--;
				continue;
			}
			//System.out.println(word);

			currWord = word;
			sendMessage();
			prevWords.add(word);
			System.out.printf("%s さんの手: %s\n", players.get(curr).getName(), currWord);
			if (players.size() - 1 > curr) {
				curr++;
			} else {
				curr = 0;
			}
		}
		System.out.printf("%s さんの勝ち\n", players.get(0).getName());

	}
}