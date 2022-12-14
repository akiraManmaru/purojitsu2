
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 7-3
 * 提出日 2021/10/29
 */
import java.util.Scanner;
/*
 * 積分の近似値が正確な値に収束することを確認するクラス
 */

public class IntegralExperiment {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		System.out.println("f(x)=x^a log(bx + c)の積分近似計算実験");
		/* キーボード入力の準備 */
		Scanner kbScanner = new Scanner(System.in);
		/* キーボードから x^a log(bx + c) の a,b,c の値を入力する。bが0の間繰り返す*/
		double a;
		double b;
		double c;
		do {
			System.out.print("a(実数),b(0以外の実数),c(実数)をスペース区切で入力: ");
			a = kbScanner.nextDouble();
			b = kbScanner.nextDouble();
			c = kbScanner.nextDouble();
		} while (b == 0);
		/* 積分計算可能な区間を案内する。bx+c>0 となるxの範囲は、bの正負により異なる。*/
		if (b < 0) {
			System.out.printf("終点は %.4f未満でなければなりません。\n", 0 - c / b);
		} else {
			System.out.printf("始点は %.4fより大きくなければなりません。\n", 0 - c / b);
		}
		/* キーボードから積分区間の始点と終点を入力する */
		System.out.print("積分の始点と終点をスペースで区切って入力: ");
		double start = kbScanner.nextDouble();
		double end = kbScanner.nextDouble();
		/* 始点 >= 終点でないこと、積分区間に対数関数が計算不可となる部分がないことを確認 */
		if (start >= end) {
			System.out.println("始点と終点が同じか始点のほうが大きくなっています。");
		} else if ((end >= -c / b && b < 0) || (start < -c / b) && (b > 0)) {
			System.out.println("積分区間に bx+c が0以下になる部分があります。");
		} else if ((a - (int) a) >= 0 && start < 0) {
			System.out.println("a は浮動小数点数ですが、積分区間にxが負になる部分があります。");
		} else if (a < 0 && start * end <= 0) {
			System.out.println("a は負ですが、積分区間にx==0が含まれます。");
		} else {
			LogarithmFunction function2 = new LogarithmFunction(a, b, c);
			if (c < 0) {
				System.out.printf("f(x) = x^%.1f log(%.1fx - %.1f)の定積分 [%2.1f, %2.1f] の近似値\n", a, b, Math.abs(c), start,
						end);
			} else {
				System.out.printf("f(x) = x^%.1f log(%.1fx + %.1f)の定積分 [%2.1f, %2.1f] の近似値\n", a, b, c, start, end);
			}
			for (int i = 2; i <= 16384; i *= 2) {

				Integrator inte2 = new Integrator(start, end, function2);

				System.out.printf("%6d分割:%16.12f\n", i, inte2.sectionalMensuration(i));

			}

		}
		kbScanner.close();

	}

}
