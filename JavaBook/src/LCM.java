
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 6-2
 * 提出日 2021/10/19
 */
import java.util.Scanner;

/*
 * 累積の最小公倍数を計算すクラス
 */
public class LCM {
	//フィールド
	private int currentLCM;

	//コンストラクタ
	public LCM() {
		this.currentLCM = 1;
	}

	//最大公約数を計算するメソッド
	//ユークリッド
	public int calcGCD(int number, int divisor) {
		int r = 1;
		if (divisor > number) {
			int a = number;
			number = divisor;
			divisor = a;
		}
		while (r > 0) { //ループ文
			r = number % divisor;
			if (r != 0) {
				number = divisor;
				divisor = r;
			}

		}
		return divisor;
	}

	//最大公約数から最小公倍数を計算するメソッド
	public int updateLCM(int number) {
		return currentLCM = number * currentLCM / this.calcGCD(number, currentLCM);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		System.out.print("正の整数の個数を入力してください:");
		int input = kbScanner.nextInt();
		LCM lcm = new LCM(); //オブジェクト生成
		for (int i = 0; i < input; i++) {
			System.out.printf("%d個目の正の整数を入力してください:", i + 1);
			int input1 = kbScanner.nextInt();
			System.out.printf("累積の最小公倍数は%dです\n", lcm.updateLCM(input1));
		}
		System.out.println("終了します");
		kbScanner.close();
	}

}
