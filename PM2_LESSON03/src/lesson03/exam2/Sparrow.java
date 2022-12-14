package lesson03.exam2;

/**
 * Passerineインターフェースを実装するSparrow（スズメ）のクラス
 * @author Kimiaki Shirahama
 */
public class Sparrow implements Passerine {
	/**
	 * 泣く動作
	 */
	public void scream() {
		System.out.println("ピヨピヨピヨ");
	}
	/**
	 * 飛ぶ動作
	 */
	public void fly() {
		System.out.println("パサパサ、パサパサ");
	}
}
