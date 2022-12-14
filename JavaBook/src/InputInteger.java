import java.util.Scanner;

public class InputInteger {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);

		System.out.print("整数を入力してください：");
		while (!keyBoardScanner.hasNextInt()) {
			keyBoardScanner.next();
			System.out.print("整数を入力してください：");
		}
		int input = keyBoardScanner.nextInt();
		System.out.printf("入力された整数は%dです\n", input);
		keyBoardScanner.close();

	}

}
