/*
 * 提出者 21-1-037-0034 池上開世
 * 予習課題 4-1
 * 提出日 2021/10/5
 */
/*
 * 算術演算子の使用例（特筆すべきことなし）
 */
import java.util.Scanner;
public class ArithmeticOperations {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("一つ目の整数を入力してください");
		int input1 = keyBoardScanner.nextInt();
		System.out.print("二つ目の整数を入力してください");
		int input2 = keyBoardScanner.nextInt();
		System.out.println("和　差　積　商　剰余　富豪斑点の順に表示します");
		System.out.println(input1 + input2);
		System.out.println(input1 - input2);
		System.out.println(input1 * input2);
		System.out.println(input1 / input2);
		System.out.println(input1 % input2);
		System.out.println(-input1);
		keyBoardScanner.close();

	}

}
