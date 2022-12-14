/*
提出者 21-1-037-0034 池上開世
課題 13-2
提出日 2021/12/21
*/
/*
 *入力された係数の関数式を表示し、計算するクラス
 */
public class LogarithmFunction2 {
	private double a;
	private double b;
	private double c;
	private String expression;

	//コンストラクタ
	public LogarithmFunction2(double a, double b, double c) {
		this.a = a;
		this.b = b;
		this.c = c;
		makeExpression();
	}

	//関数の計算を行うメソッド
	public double evaluate(double x) {
		return Math.pow(x, a) * Math.log(b * x + c);
	}

	//関数式を作るメソッド
	public void makeExpression() {
		if (a == 0.0) {
			expression = "log("; //x^a は aが0の場合1 なので表示しない
		} else if (a == 1.0) {
			expression = "x log("; //x^a は aが1の場合 x と表示
		} else {
			expression = "x^" + String.format("%4.2f", a) + " log(";
		}
		if (b != 0.0) {
			if (b == 1.0) {
				expression += "x";
			} else if (b == -1.0) {
				expression += "-x";
			} else {
				expression += String.format("%4.2f", Math.abs(b));
			}
		}
		if (c != 0.0) {
			if (b != 0.0) {
				if (c >= 0.0) {
					expression += "+";
				} else if (c < 0.0) {
					expression += "-";
				}
				expression += String.format("%4.2f", Math.abs(c));
			}
		} else {
			if (b == 0.0) { //c ==0, b == 0 の場合)
				expression += "0.00";

			}
		}
		expression += ')';

	}

	//関数式を取得するメソッド
	public String getExpression() {
		return expression;
	}

	//メインメソッド
	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		int numOfConstants = 3;
		DataStorage dStorage = new DataStorage();
		/* キーボードから x^a log(bx + c) の a,b,c の値を入力する */
		System.out.print("x^a log(bx + c) の ");
		System.out.print("a, b, c の値をスペースで区切って入力: ");
		dStorage.enterData(numOfConstants);
		/* 入力された値を元に、対数関数を表すオブジェクトを生成する */
		LogarithmFunction2 function = new LogarithmFunction2(dStorage.valueAt(0),

				dStorage.valueAt(1), dStorage.valueAt(2));

		System.out.printf("f(x) = %s\n", function.getExpression());
		/* キーボードから関数に与える引数の値を入力する */
		System.out.print("xの値を入力: ");
		dStorage.enterData(1);
		double x = dStorage.valueAt(0);
		/* 関数の計算結果を表示 */
		System.out.printf("f(%1.2f) = %8.2f", x, function.evaluate(x));

	}

}
