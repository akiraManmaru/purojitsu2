import java.util.Scanner;

public class SwitchExample {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);

		System.out.print("一つ目の整数を入力してください：");
		int input1 = keyBoardScanner.nextInt();
		System.out.print("二つ目の整数を入力してください：");
		int input2 = keyBoardScanner.nextInt();
		System.out.print("演算子を入力してください");
		String operaterString = keyBoardScanner.next();
		char operator = operaterString.charAt(0);

		switch (operator) {
		case '+':
			System.out.printf("和:%d + %d = %d\n", input1, input2, (input1 + input2));
			break;
		case '-':
			System.out.printf("差:%d - %d = %d\n", input1, input2, (input1 - input2));
			break;
		case '*':
		case '×':
			System.out.printf("積:%d * %d = %d\n", input1, input2, (input1 * input2));
			break;
		case '/':
			System.out.printf("商:%d / %d = %d\n", input1, input2, (input1 / input2));
			break;
		case '%':
			System.out.printf("剰余:%d % %d = %d\n", input1, input2, (input1 % input2));
			break;
		default:
			System.out.println("演算子が入力されませんでした");
			break;
		}
		keyBoardScanner.close();
	}

}
