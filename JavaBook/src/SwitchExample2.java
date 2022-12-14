
/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 5-1
 * 提出日 2021/10/12
 */
import java.util.Scanner;
/*
 * 入力された2数の和 差 積 商 剰余を求めるクラス
 */

public class SwitchExample2 {
	/* フィールド */
	private int operand1, operand2;

	/**
	 * コンストラクタ
	 */
	public SwitchExample2(int operand1, int operand2) {
		this.operand1 = operand1;
		this.operand2 = operand2;
	}

	/**
	 * 加算を行うメソッド
	 */
	public int calcSum() {
		return operand1 + operand2;
	}

	/**
	 * 減算を行うメソッド
	 */
	public int calcDiff() {
		return operand1 - operand2;
	}

	/**
	 * 乗算を行うメソッド
	 */
	public long calcProduct() {
		return (long) operand1 * (long) operand2; //long型に変更
	}

	/**
	 * 除算を行うメソッド
	 */
	public double calcQuotient() {
		return (double) operand1 / (double) operand2; //double型に変更
	}

	/**
	 * 剰余算を行うメソッド
	 */
	public int calcModulo() {
		return operand1 % operand2;
	}

	public static void main(String[] args) {
		// ここから完成品
		// キーボード入力を読み取る準備
		Scanner kbScanner = new Scanner(System.in);

		System.out.print("一つ目の整数を入力してください: ");
		int input1 = kbScanner.nextInt();
		System.out.print("二つ目の整数を入力してください: ");
		int input2 = kbScanner.nextInt();
		System.out.print("演算子を入力してください: ");
		String operatorString = kbScanner.next();
		// 入力された文字列の最初の1文字を抽出
		char operator = operatorString.charAt(0);
		// ここまで完成品

		// 入力された整数を用いてSwitchExample2クラスのオブジェクトを生成
		SwitchExample2 switchExample2 = new SwitchExample2(input1, input2);

		// 入力された演算子によって処理を分岐
		switch (operator) {
		case '+':
			System.out.printf("和:%d + %d = %d\n", input1, input2, switchExample2.calcSum());
			break;
		case '-':
			System.out.printf("差:%d - %d = %d\n", input1, input2, switchExample2.calcDiff());
			break;
		case '*':
			System.out.printf("積:%d * %d = %d\n", input1, input2, switchExample2.calcProduct());
			break;
		case '/':
			System.out.printf("商:%d / %d = %.2f\n", input1, input2, switchExample2.calcQuotient());
			break;
		case '%':
			System.out.printf("余剰:%d %% %d = %d\n", input1, input2, switchExample2.calcModulo());
			break;
		default: //演算子でない場合
			System.out.println("演算子が入力されませんでした");
			break;
		}

		// スキャナオブジェクトをクローズする
		kbScanner.close();
	}

}