/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 8-1
 * 提出日 2021/11/9
 */
public class FiveEvenNumbers {

	private int[] even; // int型配列フィールド evenの宣言

	public FiveEvenNumbers() {//コンストラクタ

		this.even = new int[5];// フィールドevenを,サイズ5の配列として生成
		/* for文を使ってeven[0...4]に値を代入 */
		for (int i = 0; i < 5; i++) {
			even[i] = 2 * i;
		}

	}

	//for文を使い結果を表示するメソッド
	public void showAll() {

		/* for文を使って実行例のように表示 */
		System.out.print("5番目までの偶数：");
		for (int i = 0; i < 5; i++) {
			System.out.printf(" %d", even[i]);
		}

	}

	//メインメソッド
	public static void main(String[] args) {

		FiveEvenNumbers fen1 = new FiveEvenNumbers();// このクラスのオブジェクトを生成
		fen1.showAll();// オブジェクトにメソッドshowAllを実行させる
		System.out.println("");

	}

}
