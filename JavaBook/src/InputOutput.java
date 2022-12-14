/*
 * 提出者 21-1-037-0034 池上開世
 * 課題 2-3
 * 提出日 2021/9/21
 */
/*
 * キーボートからの入力と出力の練習
 */
import java.util.Scanner;
public class InputOutput {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		//オブジェクト生成
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("整数を入力してください:");
		
		//打ち込んだ値をinput1に代入
		int input1 = keyBoardScanner.nextInt();
		//%?dで？には桁数が入る
		System.out.printf("入力は%4dです.\n", input1);
		
		System.out.print("浮動小数点数を入力してください:");
		
		//打ち込んだ値をinput2に代入
		double input2 = keyBoardScanner.nextDouble();
		System.out.printf("入力は小数点表記で%6.2f,指数表記で%10.2eです.\n", input2, input2);
		keyBoardScanner.close();

	}

}
