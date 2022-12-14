package lesson05b.test;

import lesson05b.shiritori.Game;
import lesson05b.shiritori.Nijitori;

public class TestDrive12Nijitori {
	/**
	 * 講義資料のにじとりの実行例と一致するはず．．．
	 */
	public static void main(String[] args) {
		String[][] words = { new String[] {"とりにく", "まんさつ"}, new String[] {"にくまん"}};
		String[] names = { "半田", "水谷"};
		Game game = new Nijitori(names, words);
		game.game();

		words = new String[][]{ new String[] {"とりがい", "かんりよう", "がくもん"}, new String[] {"がいこうきみつ", "ようじんさ"}, new String[] {"みつかん", "ようがく"}};
		names = new String[]{ "水谷", "半田", "大谷"};
		game = new Nijitori(names, words);
		game.game();

	}

}
