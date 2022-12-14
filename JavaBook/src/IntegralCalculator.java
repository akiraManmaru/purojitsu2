/*
提出者 21-1-037-0034 池上開世
課題 13-3
提出日 2021/12/24
*/
/*
 * 5つのクラスの機能を使って積分計算機の機能を実現するクラス
 */
public class IntegralCalculator {
	private int numOfGrid;
	private ConditionChecker checker;
	private LogarithmFunction2 logFunction;
	private Integrator2 integrator;
	private Display display;

	public IntegralCalculator(int numOfGrid) {
		this.numOfGrid = numOfGrid;
		checker = new ConditionChecker();
		display = new Display();
	}

	//積分対象の対数関数を生成するためのメソッド
	public void makeLogFunction() {
		do {
			System.out.print("x^a log(bx + c) の a, b, c の浮動小数点数(bは0以外)をスペースで区切って入力: ");

			/*a, b, c の値をキーボード読み込み。詳しくはConditionChecker.java のputABCメソッド参照*/
			checker.putABC();
		} while (checker.isBzero());//bが0かどうかを判断し、0なら繰り返し入力を求める。
		logFunction = new LogarithmFunction2(checker.a, checker.b, checker.c);
	}

	//入力された関数が区間で積分可能か判断し、可能になるまで繰り返し入力を求める。
	public void makeIntegrator() {
		checker.showConditionOfStartEndPoint();//積分可能な区間を表示する
		do {
			System.out.print(
					"積分の始点と終点の値(浮動小数点数)をスペースで区切って入力: ");
			checker.putStartAndEndPoint();//startPointとendPointを受け取る
		} while (checker.checkStartAndEndPoint() == false || checker.checkIntegralSection() == false);
		integrator = new Integrator2(checker.startPoint, checker.endPoint, logFunction);//オブジェクト生成
	}

	//見出し、積分対象の関数を表示するメソッド
	public void displayLogFunction() {
		display.showExpression(logFunction.getExpression());
		System.out.println();

	}

	//見出し、積分区間終点、積分式、積分区間始点を表示する
	public void displayIntegralForm() {
		display.showIntegralForm(checker.startPoint, checker.endPoint, logFunction.getExpression());
		System.out.println();

	}

	//計算結果を表示するメソッド
	public void go() {
		display.showResult(integrator.sectionalMensuration(numOfGrid));

	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		final int numOfGrid = 100000000; // 積分区間の分割数(積分器の精度)
		IntegralCalculator calculator = new IntegralCalculator(numOfGrid);
		calculator.makeLogFunction(); // 対数関数の生成
		calculator.displayLogFunction(); // 生成された対数関数式の表示
		calculator.makeIntegrator(); // 積分器の生成
		calculator.displayIntegralForm(); // 積分式の表示
		calculator.go(); // 積分を計算し、結果を表示する。

	}

}
