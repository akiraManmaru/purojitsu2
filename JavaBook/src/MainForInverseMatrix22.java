
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-2
 * 提出日 2021/10/12
 */

import java.util.Scanner;

/*
 * 値を入力し、InverseMatrix22で計算した逆行列を表示するクラス
 */
public class MainForInverseMatrix22 {
	// このクラスのメインメソッド
	public static void main(String[] args) {

		// ここから完成品
		int a, b, c, d; // 行列の各成分

		// キーボード入力を読み取る準備
		Scanner kbScanner = new Scanner(System.in);

		// 行列の各成分の入力を求め、局所変数a, b, c, dに代入
		System.out.print("行列の(1,1)成分を入力してください: ");
		a = kbScanner.nextInt();

		System.out.print("行列の(1,2)成分を入力してください: ");
		b = kbScanner.nextInt();

		System.out.print("行列の(2,1)成分を入力してください: ");
		c = kbScanner.nextInt();

		System.out.print("行列の(2,2)成分を入力してください: ");
		d = kbScanner.nextInt();

		// ここまで完成品

		// オブジェクト生成と変数matによる参照
		InverseMatrix22 inversmatrix22 = new InverseMatrix22(a, b, c, d);

		// 行列が正則かどうかチェックし，結果に応じてメッセージを表示
		inversmatrix22.showInverseMatrix();

		// スキャナオブジェクトをクローズする
		kbScanner.close();
	}
}