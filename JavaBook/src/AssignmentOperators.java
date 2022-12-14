/*
 * 提出者 21-1-037-0034 池上開世
 * 予習課題 4-1
 * 提出日 2021/10/5
 */
/*
 * 代入演算子の使用例
 */
import java.util.Scanner;
public class AssignmentOperators {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("整数を入力してください");
		int input = keyBoardScanner.nextInt();
		
		input += 5; //input = input + 5;
		System.out.printf("入力に５を加えると%dになります.\n", input);
		input *= 3; //input = input * 3;
		System.out.printf("さらに3をかけると%dになります.\n", input);
		keyBoardScanner.close();

	}

}
