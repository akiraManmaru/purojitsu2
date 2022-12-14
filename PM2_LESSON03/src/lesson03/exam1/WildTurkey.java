package lesson03.exam1;

/**
 * WildTurkey（野生の七面鳥）のクラス
 */
public class WildTurkey implements Turkey {
	/**
	 * 泣く動作
	 */
	public void gobble() {
		System.out.println("ゴホゴホ");
	}
	/**
	 * 飛ぶ動作
	 */
	public void fly() {
		System.out.println("ちょっとだけ飛んでいます");
	}
}
