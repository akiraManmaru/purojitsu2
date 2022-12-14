package lesson05b.test;

import lesson05b.shiritori.Game;
import lesson05b.shiritori.Shiritori;

public class TestDrive10Shiritori {
	/**
	 * 講義資料のしりとりの実行例と一致するはず．．．
	 */

	public static void main(String[] args){

		String[][] words = { new String[] {"りんご", "らくだ", "くま"}, new String[] {"ごりら", "だいがく"}};
		String[] names = { "水谷", "半田"};
		Game game = new Shiritori(names, words);
		game.game();

		words = new String[][]{ new String[] {"りすと", "いかだ", "くま"}, new String[] {"とうだい", "だいがく", "きん"}, new String[] {"いがく", "まんと"}};
		names = new String[]{ "水谷", "半田", "大谷"};
		game = new Shiritori(names, words);
		game.game();

	}




}
