/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 4-1
 * 提出日 2021/10/5
 */

import java.util.Scanner;

/*
 * 入力した２数の和　差　積　商を求めるクラス
 */
public class ArithmeticOperations2 {
	//フィールド
	private int operand, operand2;

	//コンストラクタ
	public ArithmeticOperations2(int operand, int operand2) {
		this.operand = operand;
		this.operand2 = operand2;
	}

	//2数の和を求めるメソッド
	public int calcSum() {
		return operand + operand2;
	}

	//2数の差を求めるメソッド
	public int calcDiff() {
		return operand - operand2;
	}

	//2数の積を求めるメソッド
	public long calcProduct() {
		return ((long) operand * (long) operand2); //long型に変換
	}

	//2数の商を求めるメソッド
	public double calcQuotient() {
		return ((double) operand / operand2); //double型に変換
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("一つ目の整数を入力してください：");
		int input1 = keyBoardScanner.nextInt();
		System.out.print("二つ目の整数を入力してください：");
		int input2 = keyBoardScanner.nextInt();

		ArithmeticOperations2 arithOpe1 = new ArithmeticOperations2(input1, input2);
		int num1 = arithOpe1.calcSum();
		int num2 = arithOpe1.calcDiff();
		long num3 = arithOpe1.calcProduct();
		double num4 = arithOpe1.calcQuotient();
		System.out.println("和　差　積　商の順番に表示します");
		System.out.printf("%d  %d  %d  %f", num1, num2, num3, num4);
		keyBoardScanner.close();

	}

}
