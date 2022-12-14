package lesson05b.test;

import lesson05b.shiritori.Game;
import lesson05b.shiritori.SaigokaraNiMojiShiritori;

public class TestDrive16SaigokaraNiMojiShiritori {
	public static void main(String[] args) {
		String[][] words = { new String[] {"とりにく", "まんさつ"}, new String[] {"にいさん"}};
		String[] names = { "半田", "水谷"};
		Game game = new SaigokaraNiMojiShiritori(names, words);
		game.game();

		words = new String[][]{ new String[] {"といれ", "すいせん", "まりお"}, new String[] {"いかずちのつえ", "せんとちひろのかみかくし", "りれみと"}, new String[] {"つきがきれいですね", "おおさき　あまな", "みつみね　ゆいか"}};
		names = new String[]{ "大谷", "半田", "水谷"};
		game = new SaigokaraNiMojiShiritori(names, words);
		game.game();

	}

}
