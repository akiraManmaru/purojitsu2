import java.util.Scanner;

public class InputPositiveInteger {

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		Scanner keyBoardScanner = new Scanner(System.in);
		System.out.print("正整数を入力してください：");
		int input;
		while (true) {
			if (keyBoardScanner.hasNextInt()) {
				input = keyBoardScanner.nextInt();
				if (input > 0) {
					break;
				} else {
					System.out.printf("%dは正ではありません.\n", input);
				}
			} else {
				keyBoardScanner.next();
			}
			System.out.print("正整数を入力してください：");
		}
		System.out.printf("入力された正整数は%dです.\n", input);
		keyBoardScanner.close();
	}

}
