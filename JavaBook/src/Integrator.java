
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 7-2
 * 提出日 2021/10/26
 */
import java.util.Scanner;
/*
 * 方程式を任意の区間で積分し、面積を求めるクラス
 */

public class Integrator {
	//フィールド
	private double startPoint;//積分の始点
	private double endPoint;//積分の終点
	private LogarithmFunction function;

	//コンストラクタ
	public Integrator(double startPoint, double endPoint, LogarithmFunction function) {
		this.startPoint = startPoint;
		this.endPoint = endPoint;
		this.function = function;
	}

	//分割された区間の長さを求めるメソッド
	private double calcGridSpacing(int numOfGrid) {
		return (endPoint - startPoint) / numOfGrid;//始点と終点の差をとって区間の数で割ったものを返す
	}

	//面積を計算するメソッド
	public double sectionalMensuration(int numOfGrid) {
		double sigma = 0.0;
		for (double i = startPoint; i < endPoint; i = i + calcGridSpacing(numOfGrid)) {//x座標に区間の長さを足していく
			sigma += function.evaluate(i);
		}
		return calcGridSpacing(numOfGrid) * sigma;//sigmaに高さをかけて返す
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		/* キーボード入力の準備 */
		Scanner kbScanner = new Scanner(System.in);
		/* キーボードから x^a log(bx + c) の a,b,c の値を入力する */
		System.out.print("x^a log(bx + c) の a, b, c の値(実数)をスペースで区切って入力: ");
		double a = kbScanner.nextDouble();
		double b = kbScanner.nextDouble();
		double c = kbScanner.nextDouble();
		/* 入力された値を元に,対数関数を表すオブジェクトを生成する */
		LogarithmFunction loga1 = new LogarithmFunction(a, b, c);
		/* キーボードから積分区間の始点、終点、分割数の値を入力する */
		System.out.print("積分区間の始点(実数)、終点(実数)、分割数(整数)の値をスペースで区切って入力: ");
		double start = kbScanner.nextDouble();
		double end = kbScanner.nextDouble();
		int numOfGrid = kbScanner.nextInt();
		Integrator integ1 = new Integrator(start, end, loga1); // このクラスのオブジェクト生成
		double resultOfIntegral = integ1.sectionalMensuration(numOfGrid);// integrator のsectionalMensurationメソッド呼び出し
		System.out.printf("%2.1fから%2.1fの区間を%d分割した場合の区分求積法による近似値: %16.12f\n", start, end, numOfGrid, resultOfIntegral);
		kbScanner.close();

	}

}
