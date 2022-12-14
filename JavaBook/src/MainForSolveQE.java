
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-4
 * 提出日 2021/10/12
 */
import java.util.Scanner;

/*
 * 二次方程式の解を求めるクラス、このクラスでは入力と出力を行い計算はしない。
 */
public class MainForSolveQE {
	public static void main(String[] args) {
		// ここから完成品

		// キーボード入力を読み取る準備
		Scanner kbScanner = new Scanner(System.in);

		// キーボード入力から係数 a, b, c を受け取る
		System.out.print("2次の項の係数a の値を入力してください: ");
		int a = kbScanner.nextInt();
		System.out.print("1次の項の係数b の値を入力してください: ");
		int b = kbScanner.nextInt();
		System.out.print("定数項c の値を入力してください: ");
		int c = kbScanner.nextInt();
		// ここまで完成品

		// オブジェクトを生成。
		SolveQE solveQE = new SolveQE(a, b, c);

		/*  SolveQEクラスのshowSolutionメソッドを用いて、解を計算した
		結果を画面表示する。*/
		solveQE.showSolution();

		// スキャナオブジェクトをクローズする
		kbScanner.close();
	}
}