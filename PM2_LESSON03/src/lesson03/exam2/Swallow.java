package lesson03.exam2;

/**
 * Passerineインターフェースを実装するSwallow（ツバメ）のクラス
 * @author Kimiaki Shirahama
 */
public class Swallow implements Passerine {
	/**
	 * 泣く動作
	 */
	public void scream() {
		System.out.println("ピッピッピッ");
	}
	/**
	 * 飛ぶ動作
	 */
	public void fly() {
		System.out.println("サー、サー");
	}
}
