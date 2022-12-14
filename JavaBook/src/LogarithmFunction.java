
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 7-1
 * 提出日 2021/10/26
 */
import java.util.Scanner;
/*
 * 関数の結果を求めるクラス
 */

public class LogarithmFunction {
	//フィールド
	private double a;
	private double b;
	private double c;

	//コンストラクタ
	public LogarithmFunction(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}

	//解を返すメソッド
	public double evaluate(double x) {
		return Math.pow(x, a) * Math.log(b * x + c);
	}

	//方程式を綺麗にするメソッド
	public void showFunction() {
		if (c < 0) {
			System.out.printf("f(x) = x^%.1f log(%.1fx - %.1f)\n", a, b, Math.abs(c));
		} else {
			System.out.printf("f(x) = x^%.1f log(%.1fx + %.1f)\n", a, b, c);
		}

	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner kbScanner = new Scanner(System.in);
		System.out.println("x^a log(bx + c) の a, b, c の値をスペースで区切って入力:");
		double a = kbScanner.nextDouble();
		double b = kbScanner.nextDouble();
		double c = kbScanner.nextDouble();
		LogarithmFunction logarithmFunction = new LogarithmFunction(a, b, c);
		logarithmFunction.showFunction();
		System.out.println("xの値を入力:");
		double x = kbScanner.nextDouble();

		logarithmFunction.evaluate(x);
		System.out.printf("f(%.2f) = %.2f\n", x, logarithmFunction.evaluate(x));
		kbScanner.close();

	}

}
