
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-3
 * 提出日 2021/10/12
 * 際提出日 2021/10/21
 */

import java.util.Scanner;

/*
 * チェックデジットの動きを模擬するクラス
 */
public class CheckDigit {
	/* フィールド */
	private int a1, a2, a3, a4, a5;

	/**
	 *  コンストラクタ　入力された数字列から各桁の数字を求め，フィールドに代入する
	 */
	public CheckDigit(int num) {
		a1 = num / 10000;
		a2 = num % 10000 / 1000;
		a3 = num % 1000 / 100;
		a4 = num % 100 / 10;
		a5 = num % 10;
	}

	/**
	 *  フィールドの各桁の数字を用いてチェックデジットを算出するメソッド
	 */
	public int calcCheckDigit() {
		return (a1 + a2 * 2 + a3 * 3 + a4 * 4) % 10;
	}

	/**
	 *  フィールドのa5と，calcCheckDigitメソッドで算出したチェックデジットを比較し
	 *  数字列が正当なものか検査結果をboolean型で返すメソッド
	 */
	public boolean isValid() {
		boolean success;
		if (a5 == this.calcCheckDigit()) {
			success = true;
		} else {
			success = false;
		}
		return success;
	}

	/**
	 * 動作確認用のmain メソッド
	 * @param args
	 */
	public static void main(String[] args) {
		// ここから完成品

		// キーボード入力を読み取る準備
		Scanner kbScanner = new Scanner(System.in);
		// 数値を入力
		System.out.print("5桁の整数を入力してください：");
		int inputNumber = kbScanner.nextInt();

		// ここまで完成品

		// 入力された整数が5桁か否かで処理を分岐
		if ((inputNumber < 10000) || (inputNumber > 99999)) {
			System.out.println("5桁の整数ではありません");
		} else {
			// オブジェクトの生成
			CheckDigit checkDigit = new CheckDigit(inputNumber);

			// チェックデジットを算出し，入力された数値が正当なものか検査，結果を表示する．
			if (checkDigit.isValid()) {
				System.out.println("検査結果OK");
			} else {
				// 実行例通り出力するようprintfメソッドを記述
				System.out.printf("検査結果NG,入力された数字%d,本来のテェックデジット%d", inputNumber, checkDigit.calcCheckDigit());
			}
		}
		// スキャナオブジェクトをクローズする
		kbScanner.close();
	}
}