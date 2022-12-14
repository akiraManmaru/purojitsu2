
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 6-1
 * 提出日 2021/10/19
 */
import java.util.Scanner;

/*
 * 冪乗を計算するクラス
 */
public class Power {
	//フィールド 
	private int base;

	//コンストラクタ
	public Power(int base) {
		this.base = base;
	}

	//冪乗を計算するメソッド
	public long calcPower(int exponent) {
		long result = 1;
		//if (exponent > 0) {
		for (int i = 0; i < exponent; i++) {//ループ文
			result *= base;
		}
		//}
		return result;
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		/* べき乗の底の入力 */
		System.out.print("底を入力してください: ");
		int base = kbScanner.nextInt();
		/* オブジェクト生成 */
		Power power = new Power(base);
		/* 指数の入力 */
		System.out.print("指数を入力してください: ");
		int exponent = kbScanner.nextInt();
		/* 結果の表示 */
		System.out.printf("%d の %d 乗は%d です\n", base, exponent, power.calcPower(exponent));
		kbScanner.close();

	}

}
