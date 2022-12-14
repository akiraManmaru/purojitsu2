
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 8-2
 * 提出日 2021/11/9
 */
import java.util.Scanner;
/*
 * 入力された個数分偶数を表示するクラス
 */

public class EvenNumbers {
	public int size;
	private int[] even; // int型配列フィールド even の宣言

	public EvenNumbers(int size) {//コンストラクタ
		this.size = size;

		// フィールドevenを,サイズがsizeの配列として生成
		even = new int[size];
		/* for文を使って配列へ適当な偶数の値を代入 */
		for (int i = 0; i < size; i++) {
			even[i] = i * 2;
		}

	}

	public void showAll() {//for文を用い結果を表示するメソッド

		/* for文を使って実行例の2行目のように表示 */
		System.out.printf("%d番目までの偶数：", even.length);
		for (int i = 0; i < even.length; i++) {
			System.out.printf(" %d", even[i]);
		}

	}

	public static void main(String[] args) {
		Scanner keyBoardScanner = new Scanner(System.in);// キーボード入力のためのオブジェクトを生成
		System.out.print("配列サイズを入力してください");// 実行例1行目のキーボード入力以外を表示
		int input = keyBoardScanner.nextInt();// あるint型変数にキーボードから値を入力
		EvenNumbers en1 = new EvenNumbers(input);// キーボード入力の値を引数としてオブジェクトを生成
		en1.showAll();// オブジェクトにメソッドshowAllを実行させる
		keyBoardScanner.close();// キーボード入力のためのオブジェクトをclose

	}

}
